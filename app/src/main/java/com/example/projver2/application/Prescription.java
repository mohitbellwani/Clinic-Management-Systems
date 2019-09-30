package com.example.projver2.application;


public class Prescription {
    Integer Patient_id,Prescription_id,Fee_Charged;
    String Complaints;
    String General_Examination;
    String System_Examination;
    String Treatment;
    String Prescribed_Medicine;
    String Investigations;
    String Date_Created;

    public String getDate_Created() {
        return Date_Created;
    }

    public void setDate_Created(String date_Created) {
        Date_Created = date_Created;
    }

    public Integer getPatient_id() {
        return Patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        Patient_id = patient_id;
    }

    public Integer getPrescription_id() {
        return Prescription_id;
    }

    public void setPrescription_id(Integer prescription_id) {
        Prescription_id = prescription_id;
    }

    public Integer getFee_Charged() {
        return Fee_Charged;
    }

    public void setFee_Charged(Integer fee_Charged) {
        Fee_Charged = fee_Charged;
    }

    public String getComplaints() {
        return Complaints;
    }

    public void setComplaints(String complaints) {
        Complaints = complaints;
    }

    public String getGeneral_Examination() {
        return General_Examination;
    }

    public void setGeneral_Examination(String general_Examination) {
        General_Examination = general_Examination;
    }

    public String getSystem_Examination() {
        return System_Examination;
    }

    public void setSystem_Examination(String system_Examination) {
        System_Examination = system_Examination;
    }

    public String getTreatment() {
        return Treatment;
    }

    public void setTreatment(String treatment) {
        Treatment = treatment;
    }

    public String getPrescribed_Medicine() {
        return Prescribed_Medicine;
    }

    public void setPrescribed_Medicine(String prescribed_Medicine) {
        Prescribed_Medicine = prescribed_Medicine;
    }

    public String getInvestigations() {
        return Investigations;
    }

    public void setInvestigations(String investigations) {
        Investigations = investigations;
    }





}
