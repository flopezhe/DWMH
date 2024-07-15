package learn.dwmh.data;

import learn.dwmh.DataHelper;
import learn.dwmh.models.Location;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;



import static learn.dwmh.TestHelper.makeLocation;
import static org.junit.jupiter.api.Assertions.*;

class LocationRepositoryTest {
    JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
    LocationRepository repository = new LocationRepository(jdbcTemplate);

    @Test
    void findById() {

        Location expected = makeLocation(1);
        Location actual = repository.findById(1);
        assertEquals(expected,actual);

    }
}