package com.example.projver2.Databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.projver2.application.CasePaperPatient;

import java.util.ArrayList;

public class CasePaperDBAdapter {
    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public CasePaperDBAdapter(Context c) {
        this.c = c;
        helper = new DBHelper(c);
    }
    public  boolean savePatient(CasePaperPatient casePaperPatient){
        try{
            db = helper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(Constants.PATIENTNAME, casePaperPatient.getPatient_name());
            cv.put(Constants.PATIENTAGE, casePaperPatient.getPatient_age());
            cv.put(Constants.HISTORY,casePaperPatient.getPast_History());
            cv.put(Constants.ADDICTION,casePaperPatient.getAddiction());
            cv.put(Constants.GENDER, casePaperPatient.getGender());

            long result = db.insert(Constants.TB_NAME1, Constants.ROW_ID,cv);

            if(result > 0)
                return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            helper.close();
        }
        return false;
    }

    public ArrayList<CasePaperPatient> retrivePatient(){

        ArrayList<CasePaperPatient> casePaperPatients = new ArrayList<>();
        String[] columns = {Constants.ROW_ID, Constants.PATIENTNAME, Constants.PATIENTAGE,Constants.HISTORY,Constants.ADDICTION, Constants.GENDER};


        try{
            db = helper.getWritableDatabase();
            Cursor c =  db.query(Constants.TB_NAME1,columns,null,null,null,null,null);

            //traversing data
            CasePaperPatient p;
            if(c!=null){
                while (c.moveToNext()){
                    int P_id = c.getInt(0);
                    String p_name = c.getString(1);
                    int p_age = c.getInt(2);
                    String History = c.getString(3);
                    String Addiction = c.getString(4);
                    String p_gender = c.getString(5);


                    p=new CasePaperPatient();
                    p.setId(P_id);
                    p.setPatient_name(p_name);
                    p.setPatient_age(p_age);
                    p.setPast_History(History);
                    p.setAddiction(Addiction);
                    p.setGender(p_gender);

                    casePaperPatients.add(p);
                }
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return casePaperPatients;
    }
    public ArrayList<CasePaperPatient> searchPatient(String pattren){

        ArrayList<CasePaperPatient> casePaperPatients = new ArrayList<>();
        String[] columns = {Constants.ROW_ID, Constants.PATIENTNAME, Constants.PATIENTAGE, Constants.GENDER};


        try{
            db = helper.getWritableDatabase();
            Cursor c =  db.rawQuery("select * from "+ Constants.TB_NAME1 +" where Patient_name like '"+pattren+"%'",null);

            //traversing data
            CasePaperPatient p;
            if(c!=null){
                while (c.moveToNext()){
                    int P_id = c.getInt(0);
                    String p_name = c.getString(1);
                    int p_age = c.getInt(2);
                    String History = c.getString(3);
                    String Addiction = c.getString(4);
                    String p_gender = c.getString(5);


                    p=new CasePaperPatient();
                    p.setId(P_id);
                    p.setPatient_name(p_name);
                    p.setPatient_age(p_age);
                    p.setPast_History(History);
                    p.setAddiction(Addiction);
                    p.setGender(p_gender);

                    casePaperPatients.add(p);
                }
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return casePaperPatients;
    }
}
