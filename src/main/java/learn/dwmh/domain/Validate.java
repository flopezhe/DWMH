package learn.dwmh.domain;

import learn.dwmh.models.Reservation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Validate {

    public static List<String> validateReservation(Reservation reservation) {
        List<String> errors = new ArrayList<>();

        if (reservation == null) {
            errors.add("Reservation object is null.");
        } else {

            if (reservation.getStartDate() == null) {
                errors.add("Start date is required.");
            } else if (reservation.getStartDate().isBefore(LocalDate.now())) {
                errors.add("Start date cannot be in the past.");
            }

            if (reservation.getEndDate() == null) {
                errors.add("End date is required.");
            } else if (reservation.getEndDate().isBefore(reservation.getStartDate())) {
                errors.add("End date cannot be before start date.");
            }


            if (reservation.getTotalAmount() == null || reservation.getTotalAmount().compareTo(BigDecimal.ZERO) < 0) {
                errors.add("Total amount must be specified and cannot be negative.");
            }


        }

        return errors;
    }
}

