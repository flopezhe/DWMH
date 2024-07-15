package learn.dwmh.domain;



import learn.dwmh.data.*;
import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


import static learn.dwmh.TestHelper.*;
import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTest {

    ReservationRepoDouble reservationRepo;
    UserRepoDouble userRepo;
    LocationRepoDouble locationRepo;
    ReservationService service ;

    @BeforeEach
    void setUp(){
        reservationRepo = new ReservationRepoDouble();
        userRepo = new UserRepoDouble();
        locationRepo = new LocationRepoDouble();
        service = new ReservationService(reservationRepo, userRepo, locationRepo);
    }


    @Test
    void add() {
        Location location = new Location(1, 2,"address1", "city1", "zip1", "CA", new BigDecimal("10.50"), new BigDecimal("10.50"));
        Reservation reservation = new Reservation();
        reservation.setGuestUserId(new User(2, "Jane", "Doe", "guest@example.com", "0987654321", null));
        reservation.setLocation(location);
        reservation.setStartDate(LocalDate.of(2025, 8, 1));
        reservation.setEndDate(LocalDate.of(2025, 8, 10));
        reservation.setTotalAmount(new BigDecimal("105.00"));

        Result<Reservation> result = service.add(reservation);

        assertTrue(result.isSuccess());



    }

    @Test
    void updateReservation() {

        User user = makeGuestUser(2);
        Location location = makeLocation(1);
        LocalDate startDate = LocalDate.of(2026,7,1);
        LocalDate endDate = LocalDate.of(2026,8,1);
        Reservation reservation = new Reservation(4, service.findByReservationId(1).getLocation(), user,startDate,endDate, service.calculateTotalAmount(location, startDate, endDate));
        LocalDate newStart = LocalDate.of(2027, 7, 15);
        LocalDate newEnd = LocalDate.of(2027,7,21);

        reservation.setLocation(location);
        reservation.setStartDate(newStart);
        reservation.setEndDate(newEnd);
        Result<Reservation> result = service.updateReservation(reservation);

        assertTrue(result.isSuccess());

    }

    @Test
    void shouldNotUpdatePastDate(){

        Reservation reservation = service.findByReservationId(1);

        reservation.setStartDate(LocalDate.of(2024,6,20));
        reservation.setEndDate(LocalDate.of(2024,7,1));

        Result<Reservation> result = service.updateReservation(reservation);

        assertFalse(result.isSuccess());
    }


    @Test
    void cantCreatePastReservation(){
        User user = makeUser(2);

        LocalDate startDate = LocalDate.of(2024, 7, 1);
        LocalDate endDate = LocalDate.of(2024, 7, 10);

        Location location = makeLocation(1);

        Reservation reservation = makeReservation(4,location, user, startDate,endDate,new BigDecimal("100"));

        Result<Reservation> result = service.add(reservation);

        assertFalse(result.isSuccess());
    }
    @Test
    void cantCreateStartDateAfterEndDate (){

        User user = makeUser(1);

        LocalDate startDate = LocalDate.of(2026, 8, 20);
        LocalDate endDate = LocalDate.of(2026, 8, 10);

        Location location = makeLocation(1);

        Reservation reservation = makeReservation(4, location , user,
                startDate, endDate, new BigDecimal("100"));

        Result<Reservation> result = service.add(reservation);

        assertFalse(result.isSuccess());




    }

    @Test
    void deleteReservation() {
        Reservation reservation =service.findByReservationId(1);

        Result<Void> result = service.deleteReservation(reservation.getReservationId());

        assertTrue(result.isSuccess());
    }

    @Test
    void findByReservationId() {

        User user = makeUser(1);
        Location location = makeLocation(1);
        LocalDate start = LocalDate.of(2024,8,10);
        LocalDate end = LocalDate.of(2024,8,15);
        Reservation reservation = makeReservation(1, location, user, start, end, new BigDecimal("100"));
        int expected = 1;
        int actual = reservation.getReservationId();

        assertEquals(expected, actual);

    }

    @Test
    void findAvailability() {

        List<Reservation> reservationList = service.findAvailability(1);

        assertEquals(3, reservationList.size());
    }

    @Test
    void calculateTotalAmount() {

        Location location = service.findByReservationId(1).getLocation();
        LocalDate startDate = LocalDate.of(2024,7,15);
        LocalDate endDate = LocalDate.of(2024, 7,16);

        BigDecimal actual = service.calculateTotalAmount(location, startDate, endDate);

        BigDecimal expected = new BigDecimal("21.00");

        assertEquals(expected,actual);
    }
}