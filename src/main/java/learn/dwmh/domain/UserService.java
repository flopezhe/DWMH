package learn.dwmh.domain;

import learn.dwmh.data.ReservationRepository;
import learn.dwmh.data.UserRepository;
import learn.dwmh.models.Reservation;
import learn.dwmh.models.User;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;


    public UserService(UserRepository userRepository, ReservationRepository reservationRepository) {
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    public User findByEmail (String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAll(){
        return userRepository.findAllHosts();
    }

    public List<Reservation> findReservationsByHost(int userId){
        User host = userRepository.findById(userId);
        if (host == null || host.getLocation() == null){
            return List.of();
        }
        return reservationRepository.findAllByLocationId(host.getLocation().getLocationId());
    }
}
