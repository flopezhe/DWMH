package learn.dwmh.ui;


import learn.dwmh.domain.ReservationService;

import learn.dwmh.models.Reservation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class View {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static final Scanner scanner = new Scanner(System.in);

    private final ReservationService reservationService;

    public View(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void displayMenu() {
        boolean run = true;
        while (run) {
            System.out.println("\n===== Reservation Management System =====");
            System.out.println("1. View Reservations for Host Location");
            System.out.println("2. Make a Reservation");
            System.out.println("3. Edit a Reservation");
            System.out.println("4. Cancel a Reservation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewReservations();
                    break;
                case 2:
                    makeReservation();
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

    private void viewReservations() {
        // read by email or several hosts
    }

    private void makeReservation() {
        // create
    }

    private void editReservation() {
        // update options only date changes can be made and recalculate total maybe use below code
    }

    private void cancelReservation() {
        // cancel only future reservation displayMessage
    }

    public void displayReservationDetails(Reservation reservation) {
        //displays details at the end, I believe I can use this for any output
    }

    public void displayAvailableDates(List<LocalDate> availableDates) {
        // display dates host is available for
    }

    public void displaySummary(BigDecimal totalAmount) {
        // displays amount guest will be paying or due
        System.out.printf("Total Amount: $%.2f%n", totalAmount);
    }

    public void displayMessage(String message) {
        // generic message
        System.out.println(message);
    }

}
