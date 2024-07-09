package learn.dwmh.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Reservation {

    private int reservationId;
    private BigDecimal totalAmount;
    private User user;
    private Location location;
    private LocalDate startDate;
    private LocalDate endDate;
    public void getLocation(){};
    public void getReservationId(){};
    public void getUser(){};
    public void getStartDate(){};
    public void getEndDate(){};
    public void getTotalAmount(){};
}
