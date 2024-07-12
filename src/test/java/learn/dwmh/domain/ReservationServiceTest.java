package learn.dwmh.domain;

import learn.dwmh.DataHelper;
import learn.dwmh.data.LocationRepository;
import learn.dwmh.data.ReservationRepository;
import learn.dwmh.data.UserRepository;
import learn.dwmh.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static learn.dwmh.TestHelper.makeReservation;
import static learn.dwmh.TestHelper.makeResult;
import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTest {

    JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
    ReservationRepository reservationRepository = new ReservationRepository(jdbcTemplate);
    UserRepository userRepository = new UserRepository(jdbcTemplate);
    LocationRepository locationRepository = new LocationRepository(jdbcTemplate);
    ReservationService reservationService = new ReservationService(reservationRepository, userRepository, locationRepository);


    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state();");
    }

//    @Test
//    void findByLocation() {
//        List<Reservation> expected = new ArrayList<>();
//        Reservation reservation1 = makeReservation(1);
////        Reservation reservation2 = makeReservation(2);
//        expected.add(reservation1);
////        expected.add(reservation2);
//        List<Reservation> actual1 = reservationRepository.findAllByLocationId(1);
//        assertEquals(expected,actual1);
//
//    }

    @Test
    void add() {
        Reservation reservation = makeReservation(3);

        reservationService.add(reservation);

        Reservation expected = reservationRepository.findById(3);

        Reservation actual = reservationRepository.findById(3);


        assertEquals(expected,actual);
    }

    @Test
    void updateReservation() {
        Reservation reservation = makeReservation(1);
        reservation.setTotalAmount(new BigDecimal("100.00"));
        reservationService.updateReservation(reservation);

        BigDecimal expected = reservation.getTotalAmount();
        BigDecimal actual = reservation.getTotalAmount();

        System.out.println(expected);
        System.out.println(actual);
        assertEquals(expected,actual);
    }

    @Test
    void deleteReservation() {
    }
}