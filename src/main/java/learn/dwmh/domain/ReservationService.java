package learn.dwmh.domain;

import learn.dwmh.data.*;
import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    private final IReservation reservationRepository;

    private final IUser userRepository;

    private final ILocation locationRepository;

    public ReservationService(IReservation reservationRepository, IUser userRepository1, ILocation locationRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository1;
        this.locationRepository = locationRepository;
    }

    public Reservation findByReservationId(int reservationId){
        return reservationRepository.findById(reservationId);
    }

    public List<Reservation> findAvailability(int locationId){
        return reservationRepository.findAvailability(locationId);
    }




    public Result<Reservation> add(Reservation reservation) {
        BigDecimal totalAmount = calculateTotalAmount(reservation.getLocation(), reservation.getStartDate(), reservation.getEndDate());
        reservation.setTotalAmount(totalAmount);

        Result<Reservation> result = validateReservation(reservation);
        if(!result.isSuccess()){
            return result;
        }

        Reservation addedReservation = reservationRepository.add(reservation);
        result.setPayload(addedReservation);
        result.setSuccess(true);
        return result;
    }

    public Result<Reservation> updateReservation(Reservation reservation) {

        BigDecimal totalAmount = calculateTotalAmount(reservation.getLocation(), reservation.getStartDate(), reservation.getEndDate());

        reservation.setStartDate(reservation.getStartDate());
        reservation.setEndDate(reservation.getEndDate());
        reservation.setTotalAmount(totalAmount);

        Result<Reservation> result = validateReservation(reservation);
        if(!result.isSuccess()){
            return result;
        }

        int updateCount = reservationRepository.updateReservation(reservation);
        if(updateCount == 1){
            result.setSuccess(true);
            result.setPayload(reservation);
        } else {
            result.setSuccess(false);
            result.addMessage("Update Failed");
        }

        return result;
    }


    public Result<Void> deleteReservation(int reservationId) {
        Result<Void> result = new Result<>();

        int deleteCt = reservationRepository.deleteReservation(reservationId);
        if(deleteCt == 1){
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
            result.addMessage("Delete Failed");
        }
        return result;
    }




    public BigDecimal calculateTotalAmount(Location hostLocation, LocalDate startDate, LocalDate endDate) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        BigDecimal standardRate = hostLocation.getStandardRate();
        BigDecimal weekendRate = hostLocation.getWeekendRate();

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
                totalAmount = totalAmount.add(weekendRate);
            } else {
                totalAmount = totalAmount.add(standardRate);
            }
        }

        return totalAmount;
    }


    private Result<Reservation> validateReservation(Reservation reservation) {
        Result<Reservation> result = new Result<>();

        if (reservation.getGuestUserId() == null) {
            result.addMessage("Guest is required.");
        }
//        } else {
//            User guest = userRepository.findById(reservation.getGuestUserId().getUserId());
//            if (guest == null) {
//                result.addMessage("Guest must exist in the database.");
//            }
//
//        }


        // follow guest logic
        if (reservation.getLocation() == null) {
            result.addMessage("Host location is required.");
        } else {
            Location location1 = locationRepository.findById(reservation.getLocation().getLocationId());
            if (location1 == null) {
                result.addMessage("Host location must exist in the database.");
            }
        }

        List<Reservation> reservations = reservationRepository.findAvailability(reservation.getLocation().getLocationId());
        for (Reservation r : reservations) {
            LocalDate existingStart = r.getStartDate();
            LocalDate existingLast = r.getEndDate();
//            if (!r.getGuestUserId().getEmail().equals(reservation.getGuestUserId().getEmail())) {
                if ((reservation.getStartDate().isBefore(existingLast) && reservation.getEndDate().isAfter(existingStart))) {
                    result.addMessage("Invalid Dates, current reservation exists during those dates.");
                }

                if (reservation.getStartDate().isEqual(existingLast) || reservation.getEndDate().isEqual(existingStart)) {
                    result.addMessage("Invalid D, current reservation exists during those dates.");
                }
            //}
        }

            if (reservation.getStartDate() == null || reservation.getEndDate() == null) {
                result.addMessage("Start date and end date are required.");
            } else {


                if (!reservation.getStartDate().isBefore(reservation.getEndDate())) {
                    result.addMessage("Start date must come before end date.");
                }

                if (!reservation.getStartDate().isAfter(LocalDate.now())) {
                    result.addMessage("Start date must be in the future.");
                }

                if (reservation.getTotalAmount() == null || reservation.getTotalAmount().compareTo(BigDecimal.ZERO) < 0) {
                    result.addMessage("Total amount must be specified and cannot be negative.");
                }

            }
            result.setSuccess(result.getMessages().isEmpty());
            return result;
        }



}

