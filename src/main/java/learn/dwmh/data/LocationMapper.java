package learn.dwmh.data;

import learn.dwmh.models.Location;
import learn.dwmh.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper<Location> {
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location();
        location.setLocationId(rs.getInt("location_id"));
        location.setStandardRate(rs.getBigDecimal("standard_rate"));
        location.setAddress(rs.getString("address"));
        location.setCity(rs.getString("city"));
        location.setState(rs.getInt("state_id"));
        location.setZipCode(rs.getString("postal_code"));

//        User user = new User();
//        user.setUserId(rs.getInt("user_id"));
//        user.setFirstName(rs.getString("first_name"));
//        user.setLastName(rs.getString("last_name"));
//        user.setEmail((rs.getString("email")));
//        user.setPhoneNum(rs.getInt("phone"));
//        location.setLocationId(user);

        return location;
    }
}
