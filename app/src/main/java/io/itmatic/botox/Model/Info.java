package io.itmatic.botox.Model;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by Manoj on 5/9/2017.
 */

public class Info {

    private int id;
    private boolean hasDrivingLicence;
    private String modeOfTransport;
    private String gdcno;
    private String gmcno;
    private int distance;
    private boolean isVerified;
    private String availableForCallTo;
    private String availableForCallFrom;
    private boolean isEligibleToWork;
    private boolean isSelfEmployed;
    private boolean responsibilityForPatientTerm;
    private int patientsPerMonth;
    private int totalPatients;
    private String qualification;
    private List<Docs> docs;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHasDrivingLicence() {
        return hasDrivingLicence;
    }

    public void setHasDrivingLicence(boolean hasDrivingLicence) {
        this.hasDrivingLicence = hasDrivingLicence;
    }

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public void setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }

    public String getGdcno() {
        return gdcno;
    }

    public void setGdcno(String gdcno) {
        this.gdcno = gdcno;
    }

    public String getGmcno() {
        return gmcno;
    }

    public void setGmcno(String gmcno) {
        this.gmcno = gmcno;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getAvailableForCallTo() {
        return availableForCallTo;
    }

    public void setAvailableForCallTo(String availableForCallTo) {
        this.availableForCallTo = availableForCallTo;
    }

    public String getAvailableForCallFrom() {
        return availableForCallFrom;
    }

    public void setAvailableForCallFrom(String availableForCallFrom) {
        this.availableForCallFrom = availableForCallFrom;
    }

    public List<Docs> getDocs() {
        return docs;
    }

    public void setDocs(List<Docs> docs) {
        this.docs = docs;
    }

    public boolean isEligibleToWork() {
        return isEligibleToWork;
    }

    public void setEligibleToWork(boolean eligibleToWork) {
        isEligibleToWork = eligibleToWork;
    }

    public boolean isSelfEmployed() {
        return isSelfEmployed;
    }

    public void setSelfEmployed(boolean selfEmployed) {
        isSelfEmployed = selfEmployed;
    }

    public boolean isResponsibilityForPatientTerm() {
        return responsibilityForPatientTerm;
    }

    public void setResponsibilityForPatientTerm(boolean responsibilityForPatientTerm) {
        this.responsibilityForPatientTerm = responsibilityForPatientTerm;
    }

    public int getPatientsPerMonth() {
        return patientsPerMonth;
    }

    public void setPatientsPerMonth(int patientsPerMonth) {
        this.patientsPerMonth = patientsPerMonth;
    }

    public int getTotalPatients() {
        return totalPatients;
    }

    public void setTotalPatients(int totalPatients) {
        this.totalPatients = totalPatients;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
