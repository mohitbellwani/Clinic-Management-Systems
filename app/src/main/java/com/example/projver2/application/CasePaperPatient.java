package com.example.projver2.application;

public class CasePaperPatient {
    String Patient_name;
    String gender;
    Integer Patient_age;
    Integer id;
    String Past_History;
    String Addiction;

    public String getPast_History() {
        return Past_History;
    }

    public void setPast_History(String past_History) {
        Past_History = past_History;
    }

    public String getAddiction() {
        return Addiction;
    }

    public void setAddiction(String addiction) {
        Addiction = addiction;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }



    public Integer getPatient_age() {
        return Patient_age;
    }

    public void setPatient_age(Integer patient_age) {
        Patient_age = patient_age;
    }

    public String getPatient_name() {
        return Patient_name;
    }

    public void setPatient_name(String patient_name) {
        Patient_name = patient_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
