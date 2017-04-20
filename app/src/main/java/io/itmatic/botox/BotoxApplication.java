package io.itmatic.botox;

import android.app.Application;

import io.itmatic.botox.Model.Patient;

/**
 * Created by hardeep on 20/04/17.
 */

public class BotoxApplication extends Application {
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPatientToken(){
        return getPatient().getAccessToken();
    }

}
