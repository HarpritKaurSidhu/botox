package io.itmatic.botox;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import io.itmatic.botox.Model.Area;
import io.itmatic.botox.Model.Education;
import io.itmatic.botox.Model.Patient;
import io.itmatic.botox.Model.Provider;

/**
 * Created by hardeep on 20/04/17.
 */

public class BotoxApplication extends Application {
    private Patient patient;
    private Provider provider;
    private List<Area> areas;
    private ArrayList<Education> educations=new ArrayList<>();

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

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

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
