package learn.dwmh;

import learn.dwmh.data.LocationRepository;
import learn.dwmh.data.UserRepository;
import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TestHelper {


    public static Reservation makeReservation(int reservationId) {
        return new Reservation(1,
                makeUser(1),
                makeLocation(1),
                LocalDate.of(2025, 2, 2),
                LocalDate.of(2025, 2,10),
                new BigDecimal("63.00"));
    }


    public static Location makeLocation(int locationId) {
        return new Location();
    }

    public static User makeUser(int userId) {

        return new User();
    }
}