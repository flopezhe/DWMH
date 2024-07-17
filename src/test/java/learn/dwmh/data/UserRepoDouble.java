package learn.dwmh.data;


import learn.dwmh.models.Location;

import learn.dwmh.models.User;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserRepoDouble implements IUser{


    public final List<User> users = new ArrayList<>();


    public UserRepoDouble() {

        Location location1 = new Location(1,1, "address1","city1","zip1", 1,
                new BigDecimal("10.50"), new BigDecimal("10.50"));
        User host = new User(1, "Jane", "Smith", "guest@gmail.com", "0987654321", location1);
        User guest = new User(2, "John", "Doe", "host@gmail.com", "1234567890", null);
        users.add(host);
        users.add(guest);
    }


    @Override
    public User findById(int userId) {
        return users.get(userId-1);
    }

    @Override
    public User findByEmail (String email){
        for (User u : users){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }
}
