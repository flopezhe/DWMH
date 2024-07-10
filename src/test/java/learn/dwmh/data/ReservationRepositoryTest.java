package learn.dwmh.data;

import learn.dwmh.DataHelper;
import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

//import static learn.dwmh.TestHelper.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static learn.dwmh.TestHelper.makeReservation;
import static org.junit.jupiter.api.Assertions.*;

class ReservationRepositoryTest {
    static final int MISSING_ID = 100;

    JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
    ReservationRepository repository = new ReservationRepository(jdbcTemplate);

    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state();");
    }

    @Test
    void findById() {

        Reservation expected = makeReservation(1);
        Reservation actual = repository.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    void findByUserId() {
    }

    @Test
    void findByLocationId() {
    }
}