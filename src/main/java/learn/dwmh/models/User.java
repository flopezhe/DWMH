package learn.dwmh.models;

public class User {

    private int userId;
    private String lastName;
    private int phoneNum;
    private String email;
    private Location location;
    private String firstName;

    public User(){}

    public User(int userId, String lastName, int phoneNum, String email, Location location, String firstName) {
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


}
