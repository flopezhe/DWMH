package learn.dwmh.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Location {



    private int locationId;
    private BigDecimal standardRate;
    private BigDecimal weekendRate;
    private String address;
    private String state;
    private String city;
    private String zipCode;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId ;

    public Location(){}

    public Location(int locationId, int userId, String address, String city, String zipCode,String stateId,BigDecimal standardRate, BigDecimal weekendRate) {
        this.locationId = locationId;
        this.userId = userId;
        this.standardRate = standardRate;
        this.weekendRate = weekendRate;
        this.address = address;
        this.state = stateId;
        this.city = city;
        this.zipCode = zipCode;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return locationId == location.locationId && state == location.state && userId == location.userId && Objects.equals(standardRate, location.standardRate) && Objects.equals(weekendRate, location.weekendRate) && Objects.equals(address, location.address) && Objects.equals(city, location.city) && Objects.equals(zipCode, location.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, standardRate, weekendRate, address, state, city, zipCode, userId);
    }
}
