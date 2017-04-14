package io.itmatic.botox.model;

/**
 * Created by Manoj on 4/12/2017.
 */
public class Provider {

    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String zipcode;
    private String access_token;
    private boolean is_driving_licence;
    private String gdcno;
    private String gmcno;
    private String full_name;
    private String image_url;
    private String mode_of_transport;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getImage_url() {
        return image_url;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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
