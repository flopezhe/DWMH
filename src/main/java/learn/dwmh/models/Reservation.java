package learn.dwmh.models;

import org.springframework.cglib.core.Local;

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

    public Reservation(int reservationId, User guestUserId, Location location, LocalDate startDate, LocalDate endDate, BigDecimal totalAmount){
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation reservation = (Reservation) o;

        if (reservationId != reservation.reservationId) return false;
        if (!Objects.equals(totalAmount, reservation.totalAmount)) return false;
        if (!Objects.equals(guestUserId, reservation.guestUserId)) return false;
        if (!Objects.equals(location, reservation.location)) return false;
        if (!Objects.equals(startDate, reservation.startDate)) return false;
        return Objects.equals(endDate, reservation.endDate);
    }

    @Override
    public int hashCode() {
        int result = reservationId;
        result = 31 * result + (totalAmount != null ? totalAmount.hashCode() : 0);
        result = 31 * result + (guestUserId != null ? guestUserId.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

}
