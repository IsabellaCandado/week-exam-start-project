package edu.co.icesi.services;

import edu.co.icesi.entities.Sighting;
import edu.co.icesi.repositories.ExpeditionRepository;
import edu.co.icesi.repositories.SightingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SightingService {

    @Autowired
    private SightingRepository sightingRepository;

    @Autowired
    private ExpeditionRepository expeditionRepository;

    public Collection<Sighting> getSightings() {
        return sightingRepository.findAll();
    }

    public String addSighting(Sighting sighting) {
        if(expeditionRepository.contains(sighting.getExpeditionId())) {
            sightingRepository.add(sighting);
            return "Sighting added. " + sighting;
        } else {
            return "Sighting not added because expedition ID does not exist. ";
        }
    }
}
