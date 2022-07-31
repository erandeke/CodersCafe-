package com.kedar.cab.repo;

import com.kedar.cab.model.Cab;
import com.kedar.cab.model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabManager {

    Map<Long, Cab> cabs = new HashMap<>();

    public Cab registerCabs(Cab cab) {
        if (!cabs.containsKey(cab.getCabId())) {
            cabs.put(cab.getCabId(), cab);
        }
        return cabs.get(cab.getCabId());
    }

    public void setCurrentLocationForTheCab(Location locationForTheCab, Cab cab) {
        if (cabs.containsKey(cab.getCabId())) {
            cabs.get(cab.getCabId()).setCurrentLocation(locationForTheCab);
        }
    }


    public void updateCabAvailability(Cab cab, Boolean available) {
        if (cabs.containsKey(cab.getCabId())) {
            cabs.get(cab.getCabId()).setCabAvailable(available);
        }
    }

    public List<Cab> getTheCabCloserBy(Location fromPoint, double tripMatchingDistance) {
        List<Cab> list = new ArrayList<>();
        for (Cab cab : cabs.values()) {
            if (cab.isCabAvailable() && cab.getCurrentLocation().calculateDistance(fromPoint) <= tripMatchingDistance) {
                list.add(cab);
            }
        }
        return list;
    }

}
