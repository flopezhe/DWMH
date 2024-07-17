package learn.dwmh.ui;

import learn.dwmh.data.LocationRepository;
import learn.dwmh.domain.ReservationService;
import learn.dwmh.domain.Result;
import learn.dwmh.domain.UserService;

import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;

import java.time.LocalDate;
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
        if(user != null) {
            if (email != null && user.getLocation().getLocationId() != 0) {
                view.displayHostUser(user);
            } else {
                System.out.println("Host not found.");
            }
        } else {
            view.displayMessage("Invalid host.");
        }
    }

    public void viewReservationsOfHost(String email){
        User user = userService.findByEmail(email);
        if(user == null){
            System.out.println("Invalid email.");
            return;
        } else{
        int locationId = user.getLocation().getLocationId();

        List<Reservation> reservationList = reservationService.findAvailability(locationId);
        if(reservationList.isEmpty()){
            System.out.println("No reservations found.");
        } else {
            view.displayReservationDetails(reservationList);
        }
        }
    }

    public void makeNewReservation(){
        Scanner scanner = new Scanner(System.in);
        String userEmail = view.getGuestEmail();
        User guest = userService.findByEmail(userEmail);
        String hostEmail = view.getHostEmail();
        User host = userService.findByEmail(hostEmail);



        if( guest != null && host != null){
            viewHost(hostEmail);
        if (host.getEmail().equals(userEmail)){
            System.out.printf("%n%n Host is not allowed to reserve their own location. %n%n");
        } else {
            Reservation reservation = new Reservation();

            List<Reservation> futureReservs = reservationService.findAvailability(host.getLocation().getLocationId());
            if (futureReservs == null) {
                System.out.println("No reservations at the moment.");
            } else {
                viewReservationsOfHost(hostEmail);
            }


            LocalDate startDate = view.getStartDate();
            LocalDate endDate = view.getEndDate();

            reservation.setReservationId(reservation.getReservationId());
            reservation.setGuestUserId(guest);
            reservation.setStartDate(startDate);
            reservation.setEndDate(endDate);
            reservation.setLocation(host.getLocation());
            reservation.setTotalAmount(reservationService.calculateTotalAmount(reservation.getLocation(),
                    reservation.getStartDate(), reservation.getEndDate()));
            System.out.println("Are you sure  you want to create reservation below? (y or n)");
            System.out.printf(" Reservation Details:%n Location: %s%n State : %s%n Start Date: %s%n End Date: %s%n Total: %s%n",
                    reservation.getLocation().getAddress(), reservation.getLocation().getState(), reservation.getStartDate(),
                    reservation.getEndDate(), reservation.getTotalAmount());
            String answer = scanner.nextLine();
            if (answer.equals("y")) {
                Result<Reservation> result = reservationService.add(reservation);
                if (result.isSuccess()) {
                    view.displayMessage("Reservation created.");
                } else {
                    System.out.println(result.getMessages());
                }
            } else {
                view.displayMessage("We won't add this reservation.");
            }
        }
        } else {
            view.displayMessage("Invalid inputs, users are not in the system.");
        }

    }

    public void editReservation(){
        Scanner scanner = new Scanner(System.in);
        String userEmail = view.getGuestEmail();
        String hostEmail = view.getHostEmail();

        User guest = userService.findByEmail(userEmail);
        User host = userService.findByEmail(hostEmail);

        if(guest != null && host != null) {
            viewHost(hostEmail);
            viewReservationsOfHost(hostEmail);

            view.displayMessage("Please enter reservation id to edit:");
            int resId = Integer.parseInt(scanner.nextLine());

            Reservation reservation = reservationService.findByReservationId(resId);

            LocalDate startDate = view.getStartDate();
            LocalDate endDate = view.getEndDate();
            reservation.setStartDate(startDate);
            reservation.setEndDate(endDate);
            reservation.setTotalAmount(reservationService.calculateTotalAmount(reservation.getLocation(),
                    reservation.getStartDate(), reservation.getEndDate()));
            if (userEmail.equals(reservation.getGuestUserId().getEmail())) {
                System.out.println("Are you sure  you want to update reservation below? (y or n)");
                System.out.printf(" Reservation Details:%n Reservation ID: %s%n Location: %s%n Start Date: %s%n End Date: %s%n Total: %s%n",
                        reservation.getReservationId(), reservation.getLocation().getAddress(), reservation.getStartDate(),
                        reservation.getEndDate(), reservation.getTotalAmount());
                String answer = scanner.nextLine();
                if (answer.equals("y")) {
                    Result<Reservation> result = reservationService.updateReservation(reservation);
                    if (result.isSuccess()) {
                        System.out.println("Reservation was updated!");
                    } else {
                        System.out.println(result.getMessages());
                    }
                } else {
                    System.out.println("We won't update this reservation.");
                }
            } else {
                view.displayMessage("Cant update other guests reservation");
            }
        } else {
            view.displayMessage("Invalid inputs, users are not in the system.");
        }
    }


    public void cancelReservation(){
        Scanner scanner = new Scanner(System.in);
        String userEmail = view.getGuestEmail();
        String hostEmail = view.getHostEmail();
        User guest = userService.findByEmail(userEmail);
        User host = userService.findByEmail(hostEmail);
        if(guest != null && host != null) {
            viewHost(hostEmail);
            viewReservationsOfHost(hostEmail);
            view.displayMessage("Please enter reservation id to delete:");
            int resId = Integer.parseInt(scanner.nextLine());

            Reservation reservation = reservationService.findByReservationId(resId);

            if (!userEmail.equals(reservation.getGuestUserId().getEmail())) {
                view.displayMessage("Cant Delete another users reservation");
            } else {
                System.out.println("Are you sure  you want to delete reservation below? (y or n)");
                System.out.printf(" Reservation Details:%n Reservation Id: %s%n Location: %s%n Start Date: %s%n End Date: %s%n Total: %s%n",
                        reservation.getReservationId(), reservation.getLocation().getAddress(), reservation.getStartDate(),
                        reservation.getEndDate(), reservation.getTotalAmount());
                String answer = scanner.nextLine();
                if (answer.equals("y")) {
                    Result<Void> result = reservationService.deleteReservation(resId);
                    if (result.isSuccess()) {
                        view.displayMessage("Deleted successfully.");
                    } else {
                        System.out.println(result.getMessages());
                    }
                } else {
                    System.out.println("We won't delete this reservation.");
                }
            }
        } else {
            view.displayMessage("Invalid inputs, users are not in the system.");
        }

    }


}
