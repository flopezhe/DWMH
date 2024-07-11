package learn.dwmh.models;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Reservation {

    private int reservationId;
    private BigDecimal totalAmount;
    private User guestUserId;
    private Location location;
    private LocalDate startDate;
    private LocalDate endDate;


    public Reservation(){}

    public Reservation(int reservationId, Location location, User guestUserId, LocalDate startDate, LocalDate endDate, BigDecimal totalAmount){
        this.reservationId = reservationId;
        this.totalAmount = totalAmount;
        this.guestUserId = guestUserId;
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

    public User getGuestUserId(){return guestUserId;}

    public void setGuestUserId(User guestUserId) {
        this.guestUserId = guestUserId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return reservationId == that.reservationId && Objects.equals(totalAmount, that.totalAmount) && Objects.equals(guestUserId, that.guestUserId) && Objects.equals(location, that.location) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, totalAmount, guestUserId, location, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", totalAmount=" + totalAmount +
                ", guestUserId=" + guestUserId +
                ", location=" + location +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

}
