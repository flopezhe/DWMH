package learn.dwmh.data;

import learn.dwmh.models.User;

public interface IUser {

    User findById(int userId);

    User findByEmail(String email);

}
