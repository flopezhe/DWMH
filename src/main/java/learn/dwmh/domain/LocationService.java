package learn.dwmh.domain;

import learn.dwmh.data.LocationRepository;

public class LocationService {
private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
}
