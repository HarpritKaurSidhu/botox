package io.itmatic.botox.model;

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
    private String zipcode;
    private String access_token;
    private boolean is_driving_licence;
    private String gdcno;
    private String gmcno;
    private String mode_of_transport;

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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public boolean is_driving_licence() {
        return is_driving_licence;
    }

    public void setIs_driving_licence(boolean is_driving_licence) {
        this.is_driving_licence = is_driving_licence;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
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

    public String getMode_of_transport() {
        return mode_of_transport;
    }

    public void setMode_of_transport(String mode_of_transport) {
        this.mode_of_transport = mode_of_transport;
    }
}
