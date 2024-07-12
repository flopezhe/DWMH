package learn.dwmh;

import learn.dwmh.data.LocationRepository;
import learn.dwmh.data.ReservationRepository;
import learn.dwmh.data.UserRepository;
import learn.dwmh.domain.ReservationService;
import learn.dwmh.domain.UserService;
import learn.dwmh.ui.ConsoleIO;
import learn.dwmh.ui.Controller;
import learn.dwmh.ui.View;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
        ConsoleIO io = new ConsoleIO();
        View view = new View(io);

        ReservationRepository reservationRepository = new ReservationRepository(jdbcTemplate);
        UserRepository userRepository = new UserRepository(jdbcTemplate);
        LocationRepository locationRepository = new LocationRepository(jdbcTemplate);


        ReservationService reservationService = new ReservationService(reservationRepository, userRepository, locationRepository);
        UserService userService = new UserService(userRepository, reservationRepository);

        Controller controller = new Controller(view,reservationService, userService);
        controller.run();



    }
}
