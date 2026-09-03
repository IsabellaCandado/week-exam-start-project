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
        Sighting s1 = new Sighting();
        s1.setId(1);
        s1.setSightingCode("123");
        s1.setName("Sighting 1");
        s1.setDescription("Bird");
        s1.setScientificName("Bird");
        s1.setSightedAt("2026-09-02");
        s1.setLocation("Leticia");
        s1.setQuantity(1);
        s1.setConfidenceLevel(5);
        s1.setExpeditionId(1);
        sightings.put(s1.getId(), s1);

        Sighting s2 = new Sighting();
        s2.setId(2);
        s2.setSightingCode("321");
        s2.setName("Sighting 2");
        s2.setDescription("Turtle");
        s2.setScientificName("Turtle");
        s2.setSightedAt("2026-09-02");
        s2.setLocation("Choco");
        s2.setQuantity(1);
        s2.setConfidenceLevel(5);
        s2.setExpeditionId(2);
        sightings.put(s2.getId(), s2);
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
