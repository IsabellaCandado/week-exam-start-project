package edu.co.icesi.services;

import edu.co.icesi.entities.Expedition;
import edu.co.icesi.entities.Sighting;
import edu.co.icesi.repositories.ExpeditionRepository;
import edu.co.icesi.repositories.SightingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExpeditionService {

    @Autowired
    private ExpeditionRepository expeditionRepository;

    @Autowired
    private SightingRepository sightingRepository;

    public Collection<Expedition> getExpeditions() {
        return expeditionRepository.findAll();
    }

    public String addExpedition(Expedition expedition) {

        if(!expeditionRepository.contains(expedition.getId()) && !expeditionRepository.containsByCode(expedition.getCode())) {
            if(expedition.getName() != null || !expedition.getName().isEmpty()) {
                if(expedition.getCode().length() >= 5 && expedition.getCode().length() <= 20 ) {
                    expeditionRepository.add(expedition);
                    return "Expedition added. " + expedition;
                } else {
                    return "Expedition code must be between 5 and 20 characters.";
                }
            } else {
                return "Expedition name cannot be empty.";
            }
        } else {
            return "Expedition already exists.";
        }
    }

    public String deleteExpedition(int id) {
        for (Sighting sighting : sightingRepository.findAll()) {
            if (sighting.getExpeditionId() == id) {
                return "Cannot delete expedition with id " + id + " because it has sightings asocciated.";
            }
        }
        expeditionRepository.delete(id);
        return "Expedition deleted.";
    }
}
