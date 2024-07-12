package learn.dwmh;

import learn.dwmh.domain.Result;
import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TestHelper {

    public static Reservation makeReservation(int reservationId) {
        return new Reservation(reservationId, makeUserLocation(1), makeUser(1),
                LocalDate.of(2025, 2, 2), LocalDate.of(2025, 2, 10), new BigDecimal("63.00"));
    }

    public static Location makeLocation(int locationId) {
        return new Location(locationId,1, "address1","city1","zip1", 1,
                new BigDecimal("10.50"), new BigDecimal("10.50"));
    }

    public static User makeGuestUser(int guestId) {
        Location location = makeLocation(1);
        return new User(guestId, "John", "Doe", "test@gmail.com",
                "1234567890", location);
    }

    public static Location makeUserLocation(int locationId){
        return new Location(locationId, 1,"address1","city1","zip1", 1,
                new BigDecimal("10.50"), new BigDecimal("10.50"));
    }

    public static User makeUser(int userId) {
        return new User(userId, "John", "Doe", "test@gmail.com", "1234567890", null);
    }

    public static <T> Result<T> makeResult(String message, T payload) {
        Result<T> result = new Result<>();
        if (message != null) {
            result.addMessage(message);
        }
        if (payload != null) {
            result.setPayload(payload);
        }
        return result;
    }
}