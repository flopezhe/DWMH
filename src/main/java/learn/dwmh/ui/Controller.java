package learn.dwmh.ui;


import learn.dwmh.DataHelper;
import learn.dwmh.data.ReservationRepository;
import learn.dwmh.data.UserRepository;
import learn.dwmh.domain.ReservationService;
import learn.dwmh.domain.UserService;
import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Controller {
    private final View view;

    private final ReservationService reservationService;
    private final UserService userService;


    public Controller (View view, ReservationService reservationService, UserService userService){
        this.view = view;
        this.reservationService = reservationService;
        this.userService = userService;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            view.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    String email = view.getHostEmail();
                    viewHost(email);
                    viewReservationsOfHost(email);
                    break;
                case 2:
                    makeNewReservation();
                    break;
                case 3:
                    editReservation();
                    break;
                case 4:
                    cancelReservation();
                    break;
                case 5:
                    run = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }


    public void viewHost(String email){
        User user = userService.findByEmail(email);
        if(email != null && user.getLocation() != null){
            view.displayHostUser(user);
        } else{
            System.out.println("Host not found.");
        }
    }

    public void viewReservationsOfHost(String email){
        User user = userService.findByEmail(email);
        int locationId = user.getLocation().getLocationId();
        List<Reservation> reservationList = reservationService.findAvailability(locationId);
        if(reservationList.isEmpty()){
            System.out.println("No reservations found.");
        } else {
            view.displayReservationDetails(reservationList);
        }
    }

    private void makeNewReservation(){
        String userEmail = view.getGuestEmail();
        User guest = userService.findByEmail(userEmail);
        String hostEmail = view.getHostEmail();
        User host = userService.findByEmail(hostEmail);
        viewHost(hostEmail);

        Reservation reservation = new Reservation();

        List<Reservation> futureReservs = reservationService.findAvailability(host.getLocation().getLocationId());
        if( futureReservs== null){
            System.out.println("No reservations at the moment.");
        } else {
            System.out.println(futureReservs);
        }


        LocalDate startDate = view.getStartDate();
        LocalDate endDate = view.getEndDate();


        reservation.setReservationId(1);
        reservation.setGuestUserId(guest);
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setLocation(host.getLocation());
        reservation.setTotalAmount(reservationService.calculateTotalAmount(reservation.getLocation(), reservation.getStartDate(), reservation.getEndDate()));
        reservationService.add(reservation);



    }
    public void editReservation(){}
    public void cancelReservation(){}



}
