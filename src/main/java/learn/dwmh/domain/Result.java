package learn.dwmh.domain;

import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Result {
    public static void viewReservationsForHost(Location location, List<Reservation> reservations) {
        System.out.println("Location:");
        System.out.printf("ID: %d%n", location.getLocationId());
        System.out.printf("Address: %s%n", location.getAddress());
        System.out.printf("City: %s%n", location.getCity());
        System.out.printf("Zip Code: %s%n", location.getZipCode());
        System.out.println();

        if (reservations.isEmpty()) {
            System.out.println("No reservations found for this host location.");
        } else {
            System.out.println("Reservations:");
            for (Reservation reservation : reservations) {
                displayReservationDetails(reservation);
            }
        }
    }

    public static void displayReservationDetails(Reservation reservation) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        System.out.printf("Reservation ID: %d%n", reservation.getReservationId());
        System.out.printf("Guest: %s %s%n", reservation.getGuestUserId().getFirstName(), reservation.getGuestUserId().getLastName());
        System.out.printf("Dates: %s to %s%n", formatter.format(reservation.getStartDate()), formatter.format(reservation.getEndDate()));
        System.out.printf("Total Amount: $%.2f%n", reservation.getTotalAmount());
        System.out.println();
    }

    public static void displayAvailableDates(List<LocalDate> availableDates) {
        System.out.println("Available Dates:");
        for (LocalDate date : availableDates) {
            System.out.println(date);
        }
        System.out.println();
    }

    public static void displaySummary(BigDecimal totalAmount) {
        System.out.printf("Total Amount: $%.2f%n", totalAmount);
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }
}
