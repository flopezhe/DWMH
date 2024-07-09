package learn.dwmh.data;

import learn.dwmh.models.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private final JdbcTemplate jdbcTemplate;


    public ReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Reservation findById(int reservationId){
        Reservation reservation = new Reservation();
        return reservation;
    }

    public List<Reservation> findByUserId(int userId){
        List<Reservation> reservations = new ArrayList<>();
        return reservations;
    }

    public List<Reservation> findByLocationId(int locationId){
        List<Reservation> reservations = new ArrayList<>();
        return reservations;
    }


}
