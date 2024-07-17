package learn.dwmh.domain;

import learn.dwmh.data.LocationRepoDouble;
import learn.dwmh.data.ReservationRepoDouble;
import learn.dwmh.data.UserRepoDouble;
import learn.dwmh.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

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
    void findById(){

        User one = userRepo.findById(1);

        String expected = "Jane";

        assertEquals(expected, one.getFirstName());
    }

    @Test
    void findByEmail(){
        String expected = service.findByReservationId(1).getGuestUserId().getEmail();

        User guest = userRepo.findByEmail("host@gmail.com");

        assertEquals(expected , guest.getEmail());
    }
}
