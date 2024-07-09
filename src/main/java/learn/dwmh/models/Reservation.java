package learn.dwmh.models;

import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Reservation {

    private int reservationId;
    private BigDecimal totalAmount;
    private User user;
    private Location location;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(int reservationId, BigDecimal totalAmount, User user, Location location, LocalDate startDate, LocalDate endDate){
        this.reservationId = reservationId;
        this.totalAmount = totalAmount;
        this.user = user;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Location getLocation(){return location;}
    public void setLocation(Location location) {
        this.location = location;
    }
    public int getReservationId(){return reservationId;}

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public User getUser(){return user;}

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStartDate(){return startDate;}

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate(){return endDate;}

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalAmount(){ return totalAmount;}

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
