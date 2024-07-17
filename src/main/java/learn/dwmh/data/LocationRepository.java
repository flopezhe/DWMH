package learn.dwmh.data;

import learn.dwmh.models.Location;
import org.springframework.jdbc.core.JdbcTemplate;



public class LocationRepository implements ILocation{

    private final JdbcTemplate jdbcTemplate;

    public LocationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Location findById(int locationId) {

        final String sql = """
                select
                l.location_id,
                l.address,
                l.city,
                l.postal_code,
                l.standard_rate,
                l.weekend_rate,
                u.user_id,u.first_name,u.last_name,u.email,u.phone,
                s.state_id,
                s.`name`,
                s.usps_code
                from location l
                inner join `user` u on l.user_id = u.user_id
                inner join state s on l.state_id = s.state_id
                where location_id = ?;
                """;

        return jdbcTemplate.query(sql, new LocationMapper(), locationId)
                .stream().findFirst().orElse(null);
    }

}
