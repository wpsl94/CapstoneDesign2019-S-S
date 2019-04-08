package com.capstonedesign.backend.service;

import com.capstonedesign.backend.domain.Water;
import com.capstonedesign.backend.repository.WaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Tuple;

import java.util.Set;

@Service
public class WaterService {

    private final WaterRepository waterRepository;

    @Autowired
    public WaterService(WaterRepository waterRepository) {
        this.waterRepository = waterRepository;
    }

    public void saveDrinkLog(Water water) {

        waterRepository.saveDrinkLog(water);
    }

    public Set<Tuple> getDrinkLogWithDate(Water water) {

        return waterRepository.getAllDrinkLog(water);
    }
}
