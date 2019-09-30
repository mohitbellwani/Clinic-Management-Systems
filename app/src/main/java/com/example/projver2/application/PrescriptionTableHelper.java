package com.example.projver2.application;

import android.content.Context;

import com.example.projver2.Databse.PrescriptionDBAdapter;

import java.util.ArrayList;

public class PrescriptionTableHelper {
    Context c;
    private String[] Prescription_headers={"Symptoms_diagnosed","Medicine_prescribed","Prescription_dated","Consultance_fees","Patient_id","Prescription_id"};
    private String[][] Prescription_details;

    public PrescriptionTableHelper(Context c) {
        this.c = c;
    }
    public String[] getPrescription_headers(){
        return Prescription_headers;
    }

    public String[][] getPrescription_details(int id){
        ArrayList<Prescription> prescriptions =new PrescriptionDBAdapter(c).retrivePrescription(id);
        Prescription p;

        Prescription_details = new String[prescriptions.size()][10];
        for (int i =0 ;i < prescriptions.size();i++){
            p = prescriptions.get(i);
            Prescription_details[i][0] = p.getComplaints();
            Prescription_details[i][1] = p.getTreatment();
            Prescription_details[i][2] = p.getDate_Created();
            Prescription_details[i][3] = p.getFee_Charged().toString();
            Prescription_details[i][4] = p.getPatient_id().toString();
            Prescription_details[i][5] = p.getPrescription_id().toString();
            Prescription_details[i][6] = p.getGeneral_Examination();
            Prescription_details[i][7] = p.getSystem_Examination();
            Prescription_details[i][8] = p.getPrescribed_Medicine();
            Prescription_details[i][9] = p.getInvestigations();

        }
        return Prescription_details;
    }
}
