package learn.dwmh.ui;



import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class View {

    private final ConsoleIO io;

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

    public void displayReservationDetails(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            System.out.printf(" Reservation Details:%n Reservation Id: %s%n User Name: %s%n Start Date: %s%n End Date: %s%n Total: %s%n",
                    reservation.getReservationId(),reservation.getGuestUserId().getFirstName(),reservation.getStartDate(),
                    reservation.getEndDate(), reservation.getTotalAmount());

        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

}
