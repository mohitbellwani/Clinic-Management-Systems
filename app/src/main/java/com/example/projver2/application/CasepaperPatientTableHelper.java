package com.example.projver2.application;

import android.content.Context;

import com.example.projver2.Databse.CasePaperDBAdapter;

import java.util.ArrayList;

public class CasepaperPatientTableHelper {
    Context c;
    private String[] patientheaders={"Patient_name","Patient_age","gender","Patient_id"};
    private String[][] patientdata;

    public CasepaperPatientTableHelper(Context c) {
        this.c = c;
    }
    public String[] getPatientheaders(){
        return patientheaders;
    }
    public String[][] getPatientdata(){
        ArrayList<CasePaperPatient> casePaperPatients =new CasePaperDBAdapter(c).retrivePatient();
        CasePaperPatient p;

        patientdata = new String[casePaperPatients.size()][6];
        for(int i = 0; i< casePaperPatients.size(); i++) {
            p = casePaperPatients.get(i);

            patientdata[i][0] = p.getPatient_name();
            patientdata[i][1] = p.getPatient_age().toString();
            patientdata[i][2] = p.getGender();
            patientdata[i][3] = p.getId().toString();
            patientdata[i][4] = p.getPast_History();
            patientdata[i][5] = p.getAddiction();
        }
        return patientdata;
    }

    public String[][] searchPatientdata(String pattern){
        ArrayList<CasePaperPatient> casePaperPatients =new CasePaperDBAdapter(c).searchPatient(pattern);
        CasePaperPatient p;

        patientdata = new String[casePaperPatients.size()][6];
        for(int i = 0; i< casePaperPatients.size(); i++) {
            p = casePaperPatients.get(i);

            patientdata[i][0] = p.getPatient_name();
            patientdata[i][1] = p.getPatient_age().toString();
            patientdata[i][2] = p.getGender();
            patientdata[i][3] = p.getId().toString();
            patientdata[i][4] = p.getPast_History();
            patientdata[i][5] = p.getAddiction();
        }
        return patientdata;
    }
}
