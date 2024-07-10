package learn.dwmh.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Location {



    private int locationId;
    private BigDecimal standardRate;
    private BigDecimal weekendRate;
    private String address;
    private int state;
    private String city;
    private String zipCode ;

    public Location(){}

    public Location(int locationId, String address, String city, String zipCode,int state,BigDecimal standardRate, BigDecimal weekendRate) {
        this.locationId = locationId;
        this.standardRate = standardRate;
        this.weekendRate = weekendRate;
        this.address = address;
        this.state = state;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (locationId != location.locationId) return false;
        if (!Objects.equals(standardRate, location.standardRate)) return false;
        if (!Objects.equals(weekendRate, location.weekendRate)) return false;
        if (!Objects.equals(address, location.address)) return false;
        if (!Objects.equals(state, location.state)) return false;
        if (!Objects.equals(city, location.city)) return false;
        return Objects.equals(zipCode, location.zipCode);
    }


    @Override
    public int hashCode() {
        int result = locationId;
        result = 31 * result + (standardRate != null ? standardRate.hashCode() : 0);
        result = 31 * result + (weekendRate != null ? weekendRate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }
}
