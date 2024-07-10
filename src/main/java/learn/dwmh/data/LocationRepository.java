package learn.dwmh.data;

import learn.dwmh.models.Location;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class LocationRepository {

    private final JdbcTemplate jdbcTemplate;

    public LocationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Location findById(int locationId) {

        final String sql = """
                select location_id, address, city,postal_code,
                state_id,standard_rate, weekend_Rate
                from location
                where location_id = ?;""";

        return jdbcTemplate.query(sql, new LocationMapper(), locationId)
                .stream().findFirst().orElse(null);
    }


}
