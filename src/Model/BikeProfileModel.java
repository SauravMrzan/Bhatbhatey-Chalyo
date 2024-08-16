package Model;

import java.util.Date;

/**
 *
 * @author Aum
 */
public class BikeProfileModel {
    private String registrationNo;
    private String model;
    private String brand;
    private int year;
    private double price;
    private String status;
    private Date bookingDate;

    public BikeProfileModel(String registrationNo, String model, String brand, int year, double price, String status, Date bookingDate) {
        this.registrationNo = registrationNo;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.status = status;
        this.bookingDate = bookingDate;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}