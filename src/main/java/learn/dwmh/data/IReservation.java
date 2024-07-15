package learn.dwmh.data;

import learn.dwmh.models.Reservation;

import java.util.List;

public interface IReservation {
    Reservation findById(int reservationId);


    List<Reservation> findAvailability(int locationId);



    Reservation add(Reservation reservation) ;

    int updateReservation(Reservation reservation);


    int deleteReservation(int reservationId);

}