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
        final String sql = """
                select r.reservation_id,r.start_date,r.end_date,r.total,
                l.location_id, l.address,l.city,l.postal_code,l.state_id,l.standard_rate,
                l.weekend_rate,u.user_id, u.first_name,u.last_name,u.email,u.phone
                from reservation r
                inner join location l on r.location_id = l.location_id
                inner join user u on r.guest_user_id = u.user_id
                where r.reservation_id = ?;
                """;

        return jdbcTemplate.query(sql, new ReservationMapper(), reservationId)
                .stream().findFirst().orElse(null);
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
