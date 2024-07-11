package learn.dwmh.data;

import learn.dwmh.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findById(int userId) {
        String sql = """
            select
            u.user_id,
            u.first_name,
            u.last_name,
            u.email,
            u.phone,
            l.location_id,
            l.address,
            l.city,
            l.postal_code,
            l.state_id,
            l.standard_rate,
            l.weekend_rate
            from `user` u
            left join location l on u.user_id = l.user_id
            where u.user_id = ?
            """;

        return jdbcTemplate.query(sql, new UserMapper(), userId)
                .stream().findFirst().orElse(null);
    }


    public User findByEmail(String email) {
        String sql = """
           select
           u.user_id,
           u.first_name,
           u.last_name,
           u.email,
           u.phone,
           l.location_id,
           l.address,
           l.city,
           l.postal_code,
           l.state_id,
           l.standard_rate,
           l.weekend_rate
           from `user` u
           left join location l on u.user_id = l.user_id
           where u.email = ?
           """;

        return jdbcTemplate.query(sql, new UserMapper(), email)
                .stream().findFirst().orElse(null);
    }
}
