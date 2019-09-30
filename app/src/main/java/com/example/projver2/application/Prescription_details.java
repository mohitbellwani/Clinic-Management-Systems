package com.example.projver2.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projver2.Databse.PrescriptionDBAdapter;
import com.example.projver2.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Prescription_details extends AppCompatActivity {
    Button newbtn;
    private Integer id;
    EditText Comp,GE,SE,Treat,PM,Inv,Fee;
    TextView PN,Date,PH,AD;
    String formattedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_details);
        try {
            id = getIntent().getIntExtra("patient_id", 0);
            final PrescriptionDBAdapter prescriptionDBAdapter = new PrescriptionDBAdapter(this);
            newbtn = (Button) findViewById(R.id.savenew);
            Comp = (EditText) findViewById(R.id.Comp);
            GE = (EditText) findViewById(R.id.GE);
            SE = (EditText) findViewById(R.id.SE);
            Treat = (EditText) findViewById(R.id.Treat);
            PM = (EditText) findViewById(R.id.PM);
            Inv = (EditText) findViewById(R.id.Inv);
            Fee = (EditText) findViewById(R.id.Consultancy);
            PN = (TextView) findViewById(R.id.Name);
            Date = (TextView) findViewById(R.id.Date);
            PH = (TextView) findViewById(R.id.Past);
            AD = (TextView) findViewById(R.id.Addict);
            Date c = Calendar.getInstance().getTime();
            System.out.println("Current time => " + c);

            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            formattedDate = df.format(c);

            PN.setText("Patient_name \n" + getIntent().getStringExtra("Patient_Name"));
            Date.setText(formattedDate);
            PH.setText("Past_History \n" + getIntent().getStringExtra("Past_History"));
            AD.setText("Addictions \n" + getIntent().getStringExtra("Addiction"));

            newbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Prescription p = new Prescription();
                        p.setPatient_id(id);
                        p.setComplaints(Comp.getText().toString());
                        p.setGeneral_Examination(GE.getText().toString());
                        p.setSystem_Examination(SE.getText().toString());
                        p.setTreatment(Treat.getText().toString());
                        p.setPrescribed_Medicine(PM.getText().toString());
                        p.setInvestigations(Inv.getText().toString());
                        p.setDate_Created(formattedDate);
                        p.setFee_Charged(Integer.parseInt(Fee.getText().toString()));

                        if (prescriptionDBAdapter.savePrescription(p)) {
                            Comp.setText("");
                            GE.setText("");
                            SE.setText("");
                            Treat.setText("");
                            PM.setText("Prescribed_Medicine = None");
                            Inv.setText("Investigations = None");
                            Fee.setText("");
                            Intent intent = new Intent(Prescription_details.this, MainActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(Prescription_details.this, "failed", Toast.LENGTH_LONG).show();
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        Toast.makeText(Prescription_details.this,"SOME ERR OCCURED !!!!!!!!!!!!!",Toast.LENGTH_LONG).show();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(Prescription_details.this,"SOME ERR OCCURED !!!!!!!!!!!",Toast.LENGTH_LONG).show();
        }
    }
}
