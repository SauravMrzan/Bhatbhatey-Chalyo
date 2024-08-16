/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Aum
 */
public class UserProfileModel {
    private String customerId;
    private String namee;
    private String contact;
    private String address;
    private String licenseNo;
    private String gender;

    public UserProfileModel(String customerId, String name, String contact, String address, String licenseNo, String gender) {
        this.customerId = customerId;
        this.namee = name;
        this.contact = contact;
        this.address = address;
        this.licenseNo = licenseNo;
        this.gender = gender;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String name) {
        this.namee = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}