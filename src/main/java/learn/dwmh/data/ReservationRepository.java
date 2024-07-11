package learn.dwmh.data;

import learn.dwmh.models.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class ReservationRepository {

    private final JdbcTemplate jdbcTemplate;


    public ReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Reservation findById(int reservationId) {
        String sql = """
                    select
                    r.reservation_id,
                    r.start_date,
                    r.end_date,
                    r.total,
                    l.location_id,
                    l.user_id,
                    l.address,
                    l.city,
                    l.postal_code,
                    l.standard_rate,
                    l.weekend_rate,
                    s.state_id,
                    s.`name`,
                    s.usps_code,
                    u.user_id as guest_user_id,
                    u.first_name,
                    u.last_name,
                    u.email,
                    u.phone
                    from reservation r
                    join location l on r.location_id = l.location_id
                    join `user` u on r.guest_user_id = u.user_id
                    join state s on l.state_id = s.state_id
                    where r.reservation_id = ?
                    """;
        return jdbcTemplate.query(sql, new ReservationMapper(), reservationId)
                .stream().findFirst().orElse(null);
    }

    public List<Reservation> findAllByLocationId(int locationId) {
        String sql = """
                    select
                    r.reservation_id,
                    r.start_date,
                    r.end_date,
                    r.total,
                    l.location_id,
                    l.address,
                    l.city,
                    l.postal_code,
                    l.state_id,
                    l.standard_rate,
                    l.weekend_rate,
                    u.user_id as guest_user_id,
                    u.first_name,
                    u.last_name,
                    u.email,
                    u.phone
                    from reservation r
                    join location l on r.location_id = l.location_id
                    join `user` u on r.guest_user_id = u.user_id
                    where l.location_id = ?
                    """;
        return jdbcTemplate.query(sql, new ReservationMapper(), locationId);
    }

    public List<LocalDate> findAvailableDates(int locationId) {

        return List.of(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2), LocalDate.now().plusDays(3));
    }

    public int createReservation(Reservation reservation) {
        String sql = """
                    insert into reservation (location_id, guest_user_id, start_date, end_date, total)
                    values (?, ?, ?, ?, ?)
                    """;
        return jdbcTemplate.update(sql,
                reservation.getLocation().getLocationId(),
                reservation.getGuestUserId().getUserId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getTotalAmount());
    }

    public List<Reservation> findByHostEmail(String hostEmail) {
        String sql = """
                     select
                     r.reservation_id,
                     r.start_date,
                     r.end_date,
                     r.total,
                     l.location_id,
                     l.address,
                     l.city,
                     l.postal_code,
                     l.state_id,
                     l.standard_rate,
                     l.weekend_rate,
                     u.user_id as guest_user_id,
                     u.first_name,
                     u.last_name,
                     u.email,
                     u.phone
                     from reservation r
                     join location l on r.location_id = l.location_id
                     join `user` u on r.guest_user_id = u.user_id
                     join `user` h on l.user_id = h.user_id
                     where h.email = ?
                     """;
        return jdbcTemplate.query(sql, new ReservationMapper(), hostEmail);
    }

    public Reservation add(Reservation reservation) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("reservation")
                .usingColumns("location_id", "guest_user_id", "total")
                .usingGeneratedKeyColumns("reservation_id");

        HashMap<String, Object> args = new HashMap<>();
        args.put("location_id", reservation.getLocation().getLocationId());
        args.put("guest_user_id", reservation.getGuestUserId().getUserId());
        args.put("total", reservation.getTotalAmount());

        int reservationId = insert.executeAndReturnKey(args).intValue();
        reservation.setReservationId(reservationId);
        return reservation;
    }

    public int updateReservation(Reservation reservation) {
        String sql = """
                    update reservation
                    set location_id = ?,
                    guest_user_id = ?,
                    start_date = ?,
                    end_date = ?,
                    total = ?
                    where reservation_id = ?
                    """;
        return jdbcTemplate.update(sql,
                reservation.getLocation().getLocationId(),
                reservation.getGuestUserId().getUserId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getTotalAmount(),
                reservation.getReservationId());
    }

    public int deleteReservation(int reservationId) {
        String sql = """
                    delete from reservation where reservation_id = ?
                    """;
        return jdbcTemplate.update(sql, reservationId);
    }
}
