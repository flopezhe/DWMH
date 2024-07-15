package learn.dwmh.data;

import learn.dwmh.models.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements RowMapper<Location> {
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location();
        location.setLocationId(rs.getInt("location_id"));
        location.setUserId(rs.getInt("user_id"));
        location.setStandardRate(rs.getBigDecimal("standard_rate"));
        location.setWeekendRate(rs.getBigDecimal("weekend_rate"));
        location.setAddress(rs.getString("address"));
        location.setCity(rs.getString("city"));
        location.setZipCode(rs.getString("postal_code"));
        location.setState(rs.getString("usps_code"));



        return location;
    }
}
