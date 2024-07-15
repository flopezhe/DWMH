package learn.dwmh.data;

import learn.dwmh.models.User;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserRepository implements IUser {

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
            l.weekend_rate,
            s.state_id,
            s.`name`,
            s.usps_code
            from `user` u
            left join location l on u.user_id = l.user_id
            inner join state s on l.state_id = s.state_id
            where u.user_id = ?
            """;

        return jdbcTemplate.query(sql, new UserMapper(), userId)
                .stream().findFirst().orElse(null);
    }



    // read by email
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
           l.weekend_rate,
           s.state_id,
           s.`name`,
           s.usps_code
           from `user` u
           left join location l on u.user_id = l.user_id
           inner join state s on l.state_id = s.state_id
           where u.email = ?
           """;

        return jdbcTemplate.query(sql, new UserMapper(), email)
                .stream().findFirst().orElse(null);
    }
}
