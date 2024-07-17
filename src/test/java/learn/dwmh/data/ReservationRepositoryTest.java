package learn.dwmh.data;

import learn.dwmh.DataHelper;
import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;


import java.math.BigDecimal;
import java.time.LocalDate;


import static learn.dwmh.TestHelper.*;
import static org.junit.jupiter.api.Assertions.*;

class ReservationRepositoryTest {

    JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
    ReservationRepository repository = new ReservationRepository(jdbcTemplate);


    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state();");
    }

    @Test
    void findById() {

        Reservation reservation = repository.findById(1);

        String expected = "John";

        String actual = reservation.getGuestUserId().getFirstName();
        assertEquals(expected, actual);

    }



    @Test
    void add() {

        Reservation reservation = new Reservation();
        User user = makeUser(1);

        LocalDate startDate = LocalDate.of(2024, 8, 1);
        LocalDate endDate = LocalDate.of(2024, 8, 10);

        Location location = makeLocation(1);
        reservation.setReservationId(3);
        reservation.setLocation(location);
        reservation.setGuestUserId(user);
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setTotalAmount(new BigDecimal("100.00"));


        Reservation expected = new Reservation(3, location, user, startDate, endDate, new BigDecimal("100.00"));

        Reservation actual = repository.add(reservation);

        assertEquals(3, actual.getReservationId());
        assertEquals(expected,actual);
    }

    @Test
    void updateReservation() {
        User user = makeUser(1);

        LocalDate startDate = LocalDate.of(2024, 8, 1);
        LocalDate endDate = LocalDate.of(2024, 8, 10);

        Location location = makeLocation(1);


        Reservation reservation = new Reservation(1, location, user, startDate, endDate, new BigDecimal("100.00"));

        repository.updateReservation(reservation);

        Reservation reservation1 = repository.findById(1);

        LocalDate actual = reservation1.getStartDate();

        LocalDate expected = startDate;

        assertEquals(expected,actual);

    }

    @Test
    void deleteReservation() {

        repository.deleteReservation(1);

        Reservation actual = repository.findById(1);

        assertNull(actual);
    }
}