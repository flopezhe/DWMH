package learn.dwmh.data;

import learn.dwmh.models.Reservation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


public class ReservationRepoDouble implements IReservation{


    private final LocationRepoDouble locationRepoDouble = new LocationRepoDouble();
    private final UserRepoDouble userRepoDouble = new UserRepoDouble();

    public List<Reservation> reservations = new ArrayList<>();

    private int nextId = 1;


    public ReservationRepoDouble(){

        LocalDate startDate1 = LocalDate.of(2024, 8, 1);
        LocalDate endDate1 = LocalDate.of(2024, 8, 10);

        LocalDate startDate2 = LocalDate.of(2024, 8, 11);
        LocalDate endDate2 = LocalDate.of(2024, 8, 15);

        LocalDate startDate3 = LocalDate.of(2024, 8, 20);
        LocalDate endDate3 = LocalDate.of(2024, 8, 25);

        Reservation reservation1=  new Reservation(1, userRepoDouble.users.get(0).getLocation(), userRepoDouble.users.get(1), startDate1, endDate1, new BigDecimal("105.00"));
        reservations.add(reservation1);
        Reservation reservation2 = new Reservation(2, userRepoDouble.users.get(0).getLocation(),userRepoDouble.users.get(1),startDate2,endDate2, new BigDecimal("200"));
        reservations.add(reservation2);
        Reservation reservation3 = new Reservation(3, userRepoDouble.users.get(0).getLocation(),userRepoDouble.users.get(1),startDate3, endDate3, new BigDecimal("200"));
        reservations.add(reservation3);
    }


    @Override
    public Reservation findById(int reservationId) {
        for(Reservation r : reservations){
            if(r.getReservationId() == reservationId){
                return r;
            }
        }

        return null;
    }

    @Override
    public List<Reservation> findAvailability(int locationId){
        List<Reservation> result = new ArrayList<>();
        for(Reservation r : reservations){
            if(r.getLocation().getLocationId() == locationId){
                result.add(r);
            }
        }

        return result;
    }


    @Override
    public Reservation add(Reservation reservation) {
        return reservation;
    }

    @Override
    public int updateReservation(Reservation reservation) {
        if(findById(reservation.getReservationId()) == null){
            return 1;
        } else{
            return 0;
        }
    }

    @Override
    public int deleteReservation(int reservationId) {
        if(findById(reservationId) != null){
            return 1;
        } else{
            return 0;
        }
    }

}
