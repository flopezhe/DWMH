package learn.dwmh.data;

import learn.dwmh.models.Location;
import learn.dwmh.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail((rs.getString("email")));
        user.setPhoneNum(rs.getString("phone"));

        Location location = new Location();
        location.setLocationId(rs.getInt("location_id"));
        location.setUserId(rs.getInt("user_id"));
        location.setStandardRate(rs.getBigDecimal("standard_rate"));
        location.setWeekendRate(rs.getBigDecimal("weekend_rate"));
        location.setAddress(rs.getString("address"));
        location.setCity(rs.getString("city"));
        location.setZipCode(rs.getString("postal_code"));
        location.setState(rs.getInt("state_id"));
        user.setLocation(location);

        return user;
    }
}
