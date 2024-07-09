package learn.dwmh.models;

import java.math.BigDecimal;

public class Location {


    private BigDecimal standardRate;
    private BigDecimal weekendRate;
    private String address;
    private String state;
    private String city;
    private String zipCode ;

    public Location(BigDecimal standardRate, BigDecimal weekendRate, String address, String state, String city, String zipCode) {
        this.standardRate = standardRate;
        this.weekendRate = weekendRate;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
    }

    public BigDecimal getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(BigDecimal standardRate) {
        this.standardRate = standardRate;
    }

    public BigDecimal getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(BigDecimal weekendRate) {
        this.weekendRate = weekendRate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
