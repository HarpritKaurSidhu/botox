package io.itmatic.botox;

import android.app.Application;

import java.util.ArrayList;

import io.itmatic.botox.Model.Education;
import io.itmatic.botox.Model.Patient;

/**
 * Created by hardeep on 20/04/17.
 */

public class BotoxApplication extends Application {
    private Patient patient;
    private ArrayList<Education> educations=new ArrayList<>();

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPatientToken(){
        return getPatient().getAccessToken();
    }

    public ArrayList<Education> getEducations() {
        return educations;
    }

    public void setEducations(ArrayList<Education> educations) {
        this.educations = educations;
    }
}
