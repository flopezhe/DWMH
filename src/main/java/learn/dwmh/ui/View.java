package learn.dwmh.ui;

import learn.dwmh.models.Reservation;

import java.util.List;
import java.util.Scanner;

public class View {

    private final TextIO io;

    public View(TextIO io){
        this.io=io;
    }
    public static void displayMenu() {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
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
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }

    public void displayReservations(List<Reservation> reservations){
        if(reservations.size()==0){
            displayHeader("No Reservations Found.");
        }
    }

    public void displayHeader(String message){
        int length = message.length();
        io.println("");
        io.println(message);
        io.println("=".repeat(length));

    }

}
