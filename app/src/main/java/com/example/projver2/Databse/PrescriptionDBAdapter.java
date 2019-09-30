package com.example.projver2.Databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.projver2.application.Prescription;

import java.util.ArrayList;

public class PrescriptionDBAdapter {
    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public PrescriptionDBAdapter(Context c) {
        this.c = c;
        helper = new DBHelper(c);
    }

    public boolean savePrescription(Prescription prescription) {

        try {
            db = helper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(Constants.FOREIGN_ID, prescription.getPatient_id());
            cv.put(Constants.COMPLAINTS, prescription.getComplaints());
            cv.put(Constants.GENERAL, prescription.getGeneral_Examination());
            cv.put(Constants.SYSTEM, prescription.getSystem_Examination());
            cv.put(Constants.TREATMENT, prescription.getTreatment());
            cv.put(Constants.PRESCRIBEMEDS, prescription.getPrescribed_Medicine());
            cv.put(Constants.INVEST, prescription.getInvestigations());
            cv.put(Constants.DATE, prescription.getDate_Created());
            cv.put(Constants.FEE, prescription.getFee_Charged());

            long result = db.insert(Constants.TB_NAME2, Constants.PRIMARY_ID, cv);

            if (result > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.close();
        }
        return false;
    }

    public ArrayList<Prescription> retrivePrescription(int id) {
        ArrayList<Prescription> prescriptions = new ArrayList<>();
        String Pres_columns[] = {Constants.FOREIGN_ID, Constants.PRIMARY_ID, Constants.COMPLAINTS, Constants.GENERAL, Constants.SYSTEM, Constants.TREATMENT, Constants.PRESCRIBEMEDS, Constants.INVEST, Constants.DATE, Constants.FEE};

        try {
            db = helper.getWritableDatabase();
            String qry = "select * from " + Constants.TB_NAME2 + " where Patient_id = " + id;
            Cursor c = db.rawQuery(qry, null);
            Prescription p;
            if (c != null) {
                while (c.moveToNext()) {
                    int F_id = c.getInt(0);
                    int P_id = c.getInt(1);
                    String Complaints = c.getString(2);
                    String General_Examination = c.getString(3);
                    String System_Examination = c.getString(4);
                    String Treatment = c.getString(5);
                    String Prescribed_Medicine = c.getString(6);
                    String Investigations = c.getString(7);
                    String Date = c.getString(8);
                    int fee = c.getInt(9);


                    p = new Prescription();
                    p.setPatient_id(F_id);
                    p.setPrescription_id(P_id);
                    p.setComplaints(Complaints);
                    p.setGeneral_Examination(General_Examination);
                    p.setSystem_Examination(System_Examination);
                    p.setTreatment(Treatment);
                    p.setPrescribed_Medicine(Prescribed_Medicine);
                    p.setInvestigations(Investigations);
                    p.setDate_Created(Date);
                    p.setFee_Charged(fee);
                    prescriptions.add(p);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptions;
    }

    public boolean DeletePrescription(int id) {
        db = helper.getWritableDatabase();
        return db.delete(Constants.TB_NAME2, Constants.PRIMARY_ID +  "=" + id, null) > 0;
    }
}
