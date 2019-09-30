package com.example.projver2.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projver2.Databse.PrescriptionDBAdapter;
import com.example.projver2.R;

public class Prescription_details_show extends AppCompatActivity {
TextView Patient_Name,Date,Addict,Past,Complaints,General_Examination,System_Examination,Treatment,Prescribed_Medicine,Investigations,Fee;
Button del;
Integer id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_details_show);
        Patient_Name = (TextView) findViewById(R.id.Name);
        Date = (TextView) findViewById(R.id.Date);
        Addict = (TextView) findViewById(R.id.Addict);
        Past = (TextView) findViewById(R.id.Past);
        Complaints = (TextView) findViewById(R.id.Complaints);
        General_Examination = (TextView) findViewById(R.id.General_Examinatron);
        System_Examination = (TextView) findViewById(R.id.System_Examination);
        Treatment = (TextView) findViewById(R.id.Treatment);
        Prescribed_Medicine = (TextView) findViewById(R.id.Prescribed_Medicine);
        Investigations = (TextView) findViewById(R.id.Investigations);
        Fee = (TextView) findViewById(R.id.Consultancy);
        del = (Button) findViewById(R.id.Delete);
        final PrescriptionDBAdapter prescriptionDBAdapter = new PrescriptionDBAdapter(this);
        id = getIntent().getIntExtra("id",0);

        Patient_Name.setText("Name : "+getIntent().getStringExtra("Patient_Name"));
        Date.setText("Date"+getIntent().getStringExtra("Date"));
        Addict.setText("Additions : "+getIntent().getStringExtra("Addiction"));
        Past.setText("Past History : "+getIntent().getStringExtra("Past_History"));
        Complaints.setText("Complains : \n"+getIntent().getStringExtra("Complaints"));
        General_Examination.setText("General_Examination : \n"+getIntent().getStringExtra("General_Examination"));
        System_Examination.setText("System_Examination : \n"+getIntent().getStringExtra("System_Examination"));
        Treatment.setText("Treatment_given \n"+getIntent().getStringExtra("Treatment"));
        Prescribed_Medicine.setText("Prescribed_Medicine \n"+getIntent().getStringExtra("Prescribed_Medicine"));
        Investigations.setText("Investigations : \n"+getIntent().getStringExtra("Investigation"));
        Fee.setText("Consultancy_Fees taken : "+getIntent().getStringExtra("Consultancy_Fee"));

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prescriptionDBAdapter.DeletePrescription(id);
                Intent intent = new Intent(Prescription_details_show.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
