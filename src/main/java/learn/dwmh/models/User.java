package learn.dwmh.models;

import java.util.Objects;

public class User {

    private int userId;
    private String lastName;
    private int phoneNum;
    private String email;
    private Location location;
    private String firstName;

    public User(){}

    public User(int userId, String firstName, String lastName, String email, int phoneNum, Location location) {
        this.userId = userId;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
        this.location = location;
        this.firstName = firstName;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (!Objects.equals(lastName, user.lastName)) return false;
        if (!Objects.equals(phoneNum, user.phoneNum)) return false;
        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(location, user.location)) return false;
        return Objects.equals(firstName, user.firstName);
    }


    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + phoneNum;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        return result;
    }

}
