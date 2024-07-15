package learn.dwmh.data;

import learn.dwmh.models.Location;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class LocationRepoDouble implements ILocation{

    public List<Location> locations = new ArrayList<>();



    public LocationRepoDouble(){
        Location location1 = new Location(1,1, "address1","city1","zip1", "CA",
                new BigDecimal("10.50"), new BigDecimal("10.50"));

        locations.add(location1);
    }


    @Override
    public Location findById(int locationId){
        return locations.get(0);
    }

}
