package learn.dwmh.data;

import learn.dwmh.DataHelper;
import learn.dwmh.models.Location;
import learn.dwmh.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

import static learn.dwmh.TestHelper.makeGuestUser;
import static learn.dwmh.TestHelper.makeUser;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
    UserRepository repository = new UserRepository(jdbcTemplate);

    @Test
    void findById() {
        Location location = new Location(1, 1,"address1","city1","zip1", 1,
                new BigDecimal("10.50"), new BigDecimal("10.50"));
        User expected = new User(1, "John", "Doe", "test@gmail.com",
                "1234567890", location);;
        User actual = repository.findById(1);
        assertEquals(expected,actual);
    }
}