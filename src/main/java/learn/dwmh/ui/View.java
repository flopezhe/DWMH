package learn.dwmh.ui;


import learn.dwmh.domain.ReservationService;

import learn.dwmh.domain.UserService;
import learn.dwmh.models.Location;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;

import java.io.FilterOutputStream;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class View {

    private final ConsoleIO io;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static final Scanner scanner = new Scanner(System.in);

    public View(ConsoleIO io) {
        this.io = io;
    }


    public void displayMenu() {
            System.out.println("1. View Reservations By Email");
            System.out.println("2. Make a Reservation");
            System.out.println("3. Edit a Reservation");
            System.out.println("4. Cancel a Reservation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

    }

    public String getHostEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Host Email:");
        return scanner.nextLine();
    }

    public String getGuestEmail(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("User Email:");
        return scanner.nextLine();
    }

    public void displayHostUser(User user){

         System.out.println("Host info:");
         System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
         System.out.printf("Location: %s, %s, %s, %s ", user.getLocation().getAddress(), user.getLocation().getCity(), user.getLocation().getState(), user.getLocation().getZipCode());
         System.out.println("Email: " + user.getEmail());

    }

    public LocalDate getStartDate(){

        return io.readLocalDate("Start Date MM/dd/yyyy: ");
    }

    public LocalDate getEndDate(){

        return io.readLocalDate("End Date MM/dd/yyyy: ");
    }

    public Reservation createReservation(User user, Location location) {
       return new Reservation();
    }


    private void edit() {
        // update options only date changes can be made and recalculate total maybe use below code
    }

    private void cancel() {
        // cancel only future reservation displayMessage
    }

    public void displayReservationDetails(List<Reservation> reservations) {
        //displays details at the end, I believe I can use this for any output
        for (Reservation reservation : reservations) {
            System.out.printf(" Reservation Details:%n Start Date: %s%n End Date: %s%n Total: %s%n", reservation.getStartDate(), reservation.getEndDate(), reservation.getTotalAmount());

        }
    }

    public void displayAvailableDates(List<LocalDate> availableDates) {
        // display dates host is available for
    }
// I believe displayReservationDetails will suffice for now comment out
//    public void displaySummary(BigDecimal totalAmount) {
//        // displays amount guest will be paying or due
//        System.out.printf("Total Amount: $%.2f%n", totalAmount);
//    }

    public void displayMessage(String message) {
        // generic message
        System.out.println(message);
    }

}
