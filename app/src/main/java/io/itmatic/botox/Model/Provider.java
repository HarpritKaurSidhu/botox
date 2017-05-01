package io.itmatic.botox.Model;

/**
 * Created by Manoj on 4/12/2017.
 */
public class Provider {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String zipCode;
    private String accessToken;
    private boolean isDrivingLicence;
    private String gdcno;
    private String dob;
    private String gmcno;
    private String fullName;
    private String image_url;
    private String modeOfTransport;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public boolean isDrivingLicence() {
        return isDrivingLicence;
    }

    public void setDrivingLicence(boolean drivingLicence) {
        isDrivingLicence = drivingLicence;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
