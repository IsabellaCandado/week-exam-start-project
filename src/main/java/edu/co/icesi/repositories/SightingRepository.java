package edu.co.icesi.repositories;

import edu.co.icesi.entities.Sighting;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class SightingRepository {
    private HashMap<Integer, Sighting> sightings;

    public SightingRepository() {
        sightings = new HashMap<>();
    }

    @PostConstruct
    public void init() {

    }

    public void add(Sighting sighting) {
        sightings.put(sighting.getId(), sighting);
    }

    public Collection<Sighting> findAll() {
        return sightings.values();
    }

    public boolean contains(int id) {
        return sightings.containsKey(id);
    }

    public Sighting get(int id) {
        return sightings.get(id);
    }

    public boolean containsByCode(String code) {
        for (Sighting sighting : sightings.values()) {
            if (sighting.getSightingCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
}
