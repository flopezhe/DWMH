package learn.dwmh.data;

import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationMapper implements RowMapper<Reservation> {

    public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setReservationId(rs.getInt("reservation_id"));
        reservation.setStartDate(rs.getDate("start_date").toLocalDate());
        reservation.setEndDate(rs.getDate("end_date").toLocalDate());
        reservation.setTotalAmount(rs.getBigDecimal("total"));

        Location location = new Location();
        location.setLocationId(rs.getInt("location_id"));
        location.setUserId(rs.getInt("user_id"));
        location.setAddress(rs.getString("address"));
        location.setCity(rs.getString("city"));
        location.setZipCode(rs.getString("postal_code"));
        location.setState(rs.getString("usps_code"));
        location.setStandardRate(rs.getBigDecimal("standard_rate"));
        location.setWeekendRate(rs.getBigDecimal("weekend_rate"));
        reservation.setLocation(location);

        User guestUser = new User();
        guestUser.setUserId(rs.getInt("guest_user_id"));
        guestUser.setFirstName(rs.getString("first_name"));
        guestUser.setLastName(rs.getString("last_name"));
        guestUser.setEmail(rs.getString("email"));
        guestUser.setPhoneNum(rs.getString("phone"));
        reservation.setGuestUserId(guestUser);


        return reservation;
    }
}




