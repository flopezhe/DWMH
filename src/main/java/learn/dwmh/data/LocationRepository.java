package learn.dwmh.data;

import org.springframework.jdbc.core.JdbcTemplate;

public class LocationRepository {

    private final JdbcTemplate jdbcTemplate;

    public LocationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
