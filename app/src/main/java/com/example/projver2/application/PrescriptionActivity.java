package com.example.projver2.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projver2.R;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class PrescriptionActivity extends AppCompatActivity {
    TableView<String[]> tb;
    PrescriptionTableHelper helper;
    Integer id;
    Button newbutton;
    String Past,Addict,NM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        newbutton = (Button) findViewById(R.id.predetpg);
        tb = (TableView<String[]>) findViewById(R.id.presview);

        helper = new PrescriptionTableHelper(this);
        tb.setColumnCount(4);

        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this,helper.getPrescription_headers()));


        id = getIntent().getIntExtra("patient_id",0);
        Past = getIntent().getStringExtra("Past_History");
        Addict = getIntent().getStringExtra("Addiction");
        NM = getIntent().getStringExtra("Patient_Name");
        //Toast.makeText(this,"id : "+id,Toast.LENGTH_LONG).show();
        tb.setDataAdapter(new SimpleTableDataAdapter(this,helper.getPrescription_details(id)));


        tb.addDataClickListener(new TableDataClickListener<String[]>() {
            @Override
            public void onDataClicked(int rowIndex, String[] clickedData) {
                String Complaints = String.valueOf((clickedData)[0]);
                String Treatment = String.valueOf((clickedData)[1]);
                String Date = String.valueOf((clickedData)[2]);
                String Fee = String.valueOf((clickedData)[3]);
                String id = String.valueOf((clickedData)[5]);
                String General_Examination = String.valueOf((clickedData)[6]);
                String System_Examination = String.valueOf((clickedData)[7]);
                String Prescribed_Medicine = String.valueOf((clickedData)[8]);
                String Investigation = String.valueOf((clickedData)[9]);

                //type cast
                Integer param = Integer.parseInt(id);


                //Toast.makeText(PrescriptionActivity.this,"id is :"+param,Toast.LENGTH_LONG).show();
                Intent predet = new Intent(getApplicationContext(),Prescription_details_show.class);
                predet.putExtra("id",param);
                predet.putExtra("Date",Date);
                predet.putExtra("Past_History",Past);
                predet.putExtra("Addiction",Addict);
                predet.putExtra("Patient_Name",NM);
                predet.putExtra("Complaints",Complaints);
                predet.putExtra("Treatment",Treatment);
                predet.putExtra("Consultancy_Fee",Fee);
                predet.putExtra("General_Examination",General_Examination);
                predet.putExtra("System_Examination",System_Examination);
                predet.putExtra("Prescribed_Medicine",Prescribed_Medicine);
                predet.putExtra("Investigation",Investigation);
                startActivity(predet);
            }
        });
        newbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent predet = new Intent(getApplicationContext(),Prescription_details.class);
                predet.putExtra("patient_id",id);
                predet.putExtra("Past_History",Past);
                predet.putExtra("Addiction",Addict);
                predet.putExtra("Patient_Name",NM);
                startActivity(predet);
            }
        });

    }
}