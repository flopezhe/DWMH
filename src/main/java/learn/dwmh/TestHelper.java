package learn.dwmh;

import learn.dwmh.domain.Result;
import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TestHelper {

    public static Reservation makeReservation(int reservationId, Location location , User user, LocalDate startDate, LocalDate endDate, BigDecimal totalAmount) {

        location=makeUserLocation(1);
        user = makeUser(1);

        return new Reservation(reservationId, location, user,
                startDate, endDate, totalAmount);
    }

    public static Location makeLocation(int locationId) {
        return new Location(locationId,1, "address1","city1","zip1", 1,
                new BigDecimal("10.50"), new BigDecimal("10.50"));
    }

    public static User makeGuestUser(int guestId) {
        Location location = makeLocation(1);
        return new User(guestId, "John", "Doe", "test@gmail.com",
                "1234567890", null);
    }

    public static Location makeUserLocation(int locationId){
        return new Location(locationId, 1,"address1","city1","zip1", 1,
                new BigDecimal("10.50"), new BigDecimal("10.50"));
    }

    public static User makeUser(int userId) {
        return new User(userId, "John", "Doe", "test@gmail.com", "1234567890", null);
    }

}