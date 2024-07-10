package learn.dwmh.data;

import learn.dwmh.models.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findById(int userId) {

        final String sql = """
                select u.user_id, u.first_name,u.last_name,u.email,u.phone,
                    l.location_id, l.address,l.city,l.postal_code,l.state_id,l.standard_rate,
                    l.weekend_rate
                from user u
                inner join location l on u.location_id = l.location_id
                where u.user_id = ?;
                """;

        return jdbcTemplate.query(sql, new UserMapper(), userId)
                .stream().findFirst().orElse(null);
    }

    
}
