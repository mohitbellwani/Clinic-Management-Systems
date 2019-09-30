package com.example.projver2.Databse;

public class Constants {
    //casepaper columns
    static final String ROW_ID = "Patient_id";
    static final String  PATIENTNAME = "Patient_Name";
    static final String  PATIENTAGE = "Patient_Age";
    static final String  HISTORY= "Past_History";
    static final String  ADDICTION= "Addiction";
    static final String GENDER = "Gender";

    // Prescription columns
    static final String FOREIGN_ID = "Patient_id";
    static final String PRIMARY_ID = "Prescription_id";
    static final String COMPLAINTS = "Complaints";
    static final String GENERAL = "General_Examination";
    static final String SYSTEM = "System_Examination";
    static final String TREATMENT = "Treatment";
    static final String PRESCRIBEMEDS = "Prescribed_Medicine";
    static final String INVEST = "Investigations";
    static final String DATE = "Prescription_Dated";
    static final String FEE = "Fee_Charged";


    //databse and table for casepaper
    static final String DB_NAME = "clinic.db";
    static final String TB_NAME1 = "CasePaper";
    static final String TB_NAME2 = "Prescription";
    static final int VERSION = 1;

    //create and drop table
    static final String CREATETABLE1 = "create table CasePaper(Patient_id integer primary key autoincrement,Patient_Name text ,Patient_Age integer ,Past_History text ,Addiction text,Gender text)";
    static final String DROPTABLE1 = "Drop Table  If Exists CasePaper";
    static final String CREATETABLE2 = "create table Prescription(Patient_id integer,Prescription_id integer primary key autoincrement,Complaints text,General_Examination text,System_Examination text,Treatment text,Prescribed_Medicine text,Investigations text,Prescription_Dated text,Fee_Charged integer,foreign key(Patient_id) references CasePaper(Patient_id))";
    static final String DROPTABLE2 = "Drop Table  If Exists Prescription";

}
