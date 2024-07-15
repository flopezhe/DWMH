package learn.dwmh.data;

import learn.dwmh.DataHelper;
import learn.dwmh.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
    UserRepository repository = new UserRepository(jdbcTemplate);

    @Test
    void findByEmail() {
        User user = repository.findByEmail("test@gmail.com");

        String expected = "John";

        String actual = user.getFirstName();

        assertEquals(expected,actual);

    }
}