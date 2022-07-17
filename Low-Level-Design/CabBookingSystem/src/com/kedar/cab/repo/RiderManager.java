package com.kedar.cab.repo;

import com.kedar.cab.model.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderManager {

    Map<Long, Rider> riderRegister = new HashMap<>();


    public void storeInRiderRegister(Rider rider) {
        if (!riderRegister.containsKey(rider.getRiderId())) {
            riderRegister.put(rider.getRiderId(), rider);
        }
    }


}
