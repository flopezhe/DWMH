package learn.dwmh.domain;

import learn.dwmh.data.ReservationRepository;
import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<String> validateReservation(Reservation reservation) {
        return Validate.validateReservation(reservation);
    }

    public void viewReservationsForHost(Location location) {
        List<Reservation> reservations = reservationRepository.findAllByLocationId(location.getLocationId());
        Result.viewReservationsForHost(location, reservations);
    }

    public int makeReservation(User guestUser, Location hostLocation, LocalDate startDate, LocalDate endDate) {
        List<LocalDate> availableDates = reservationRepository.findAvailableDates(hostLocation.getLocationId());
        Result.displayAvailableDates(availableDates);

        BigDecimal totalAmount = calculateTotalAmount(hostLocation, startDate, endDate);
        Result.displaySummary(totalAmount);


        Reservation reservation = new Reservation();
        reservation.setLocation(hostLocation);
        reservation.setGuestUserId(guestUser);
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setTotalAmount(totalAmount);

        int reservationId = reservationRepository.createReservation(reservation);
        if (reservationId > 0) {
            Result.displayMessage("Reservation successfully created. Reservation ID: " + reservationId);
        } else {
            Result.displayMessage("Failed to create reservation.");
        }
        return reservationId;
    }

    public void editReservation(int reservationId, LocalDate newStartDate, LocalDate newEndDate) {
        Reservation reservation = reservationRepository.findById(reservationId);

        if (reservation == null) {
            Result.displayMessage("Reservation not found.");
            return;
        }


        reservation.setStartDate(newStartDate);
        reservation.setEndDate(newEndDate);

        BigDecimal totalAmount = calculateTotalAmount(reservation.getLocation(), newStartDate, newEndDate);
        Result.displaySummary(totalAmount);

        int rowsAffected = reservationRepository.updateReservation(reservation);
        if (rowsAffected > 0) {
            Result.displayMessage("Reservation successfully updated.");
        } else {
            Result.displayMessage("Failed to update reservation.");
        }
    }

    public void cancelReservation(int reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId);

        if (reservation == null) {
            Result.displayMessage("Reservation not found.");
            return;
        }

        if (reservation.getEndDate().isBefore(LocalDate.now())) {
            Result.displayMessage("Cannot cancel past reservations.");
            return;
        }

        int rowsAffected = reservationRepository.deleteReservation(reservationId);
        if (rowsAffected > 0) {
            Result.displayMessage("Reservation successfully canceled.");
        } else {
            Result.displayMessage("Failed to cancel reservation.");
        }
    }

    private BigDecimal calculateTotalAmount(Location hostLocation, LocalDate startDate, LocalDate endDate) {

        BigDecimal totalAmount = BigDecimal.ZERO;
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            if (date.getDayOfWeek().getValue() >= 6) {
                totalAmount = totalAmount.add(hostLocation.getWeekendRate());
            } else {
                totalAmount = totalAmount.add(hostLocation.getStandardRate());
            }
            date = date.plusDays(1);
        }
        return totalAmount;
    }
}

