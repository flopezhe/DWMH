package learn.dwmh.domain;

import learn.dwmh.data.IReservation;
import learn.dwmh.data.IUser;
import learn.dwmh.data.ReservationRepository;
import learn.dwmh.data.UserRepository;

import learn.dwmh.models.User;


public class UserService {

    private final IUser userRepository;
    private final IReservation reservationRepository;


    public UserService(IUser userRepository, IReservation reservationRepository) {
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    public User findByEmail (String email) {
        return userRepository.findByEmail(email);
    }


}
