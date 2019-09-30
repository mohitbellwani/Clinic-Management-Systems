package com.example.projver2.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.projver2.Databse.CasePaperDBAdapter;
import com.example.projver2.R;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    EditText name,age,ph,ad;
    Button btn,sbtn;
    RadioButton rb;
    RadioGroup rg;
    TableView<String[]> tb;
    CasepaperPatientTableHelper tableHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            final CasePaperDBAdapter casePaperDbAdapter = new CasePaperDBAdapter(this);

            //objects
            name = (EditText) findViewById(R.id.patientname);
            age = (EditText) findViewById(R.id.patientage);
            ph = (EditText) findViewById(R.id.Past);
            ad = (EditText) findViewById(R.id.Addict);
            rg = (RadioGroup) findViewById(R.id.radioGroup);
            btn = (Button) findViewById(R.id.New);
            sbtn = (Button) findViewById(R.id.Find);
            tb = (TableView<String[]>) findViewById(R.id.tableview);

            //table helper
            tableHelper = new CasepaperPatientTableHelper(this);
            tb.setColumnCount(3);


            //table header adapter
            tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, tableHelper.getPatientheaders()));

            //table data adapter
            tb.setDataAdapter(new SimpleTableDataAdapter(this, tableHelper.getPatientdata()));

            //table click
            tb.addDataClickListener(new TableDataClickListener<String[]>() {
                @Override
                public void onDataClicked(int rowIndex, String[] clickedData) {
                    String id = String.valueOf((clickedData)[3]);
                    Integer param = Integer.parseInt(id);
                    String PH = String.valueOf((clickedData)[4]);
                    String AD = String.valueOf((clickedData)[5]);
                    String NM = String.valueOf((clickedData)[0]);

                    // Toast.makeText(MainActivity.this,"id"+param,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), PrescriptionActivity.class);
                    intent.putExtra("Patient_Name", NM);
                    intent.putExtra("patient_id", param);
                    intent.putExtra("Past_History", PH);
                    intent.putExtra("Addiction", AD);

                    startActivity(intent);


                }
            });

            //button save New record
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        int selectedId = rg.getCheckedRadioButtonId();
                        rb = (RadioButton) findViewById(selectedId);

                        CasePaperPatient p = new CasePaperPatient();
                        p.setPatient_name(name.getText().toString().toUpperCase());
                        p.setPatient_age(parseInt(age.getText().toString()));
                        p.setPast_History(ph.getText().toString());
                        p.setAddiction(ad.getText().toString());
                        p.setGender(rb.getText().toString().toUpperCase());

                        if (casePaperDbAdapter.savePatient(p)) {
                            name.setText("");
                            age.setText("");
                            ph.setText("Past_History = None");
                            ad.setText("Addiction = None");
                            rg.clearCheck();

                            //update table adapter data
                            tb.setDataAdapter(new SimpleTableDataAdapter(MainActivity.this, tableHelper.getPatientdata()));
                        } else {
                            Toast.makeText(MainActivity.this, "didn't save", Toast.LENGTH_LONG).show();
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this,"SOME ERR OCCURED !!!!!!!!!!!!!",Toast.LENGTH_LONG).show();
                    }
                }
            });
            //button  search like clause

            sbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String pattern = name.getText().toString().toUpperCase();
                    tb.setDataAdapter(new SimpleTableDataAdapter(MainActivity.this, tableHelper.searchPatientdata(pattern)));

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this,"SOME ERR OCCURED !!!!!!!!!!!!!",Toast.LENGTH_LONG).show();
        }

    }
}