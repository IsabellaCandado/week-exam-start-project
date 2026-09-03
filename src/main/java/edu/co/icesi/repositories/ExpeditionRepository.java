package edu.co.icesi.repositories;

import edu.co.icesi.entities.Expedition;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class ExpeditionRepository {
    private HashMap<Integer, Expedition> expeditions;

    public ExpeditionRepository() {
        expeditions = new HashMap<>();
    }

    public void add(Expedition expedition) {
        expeditions.put(expedition.getId(), expedition);
    }

    public Collection<Expedition> findAll() {
        return expeditions.values();
    }

    public boolean contains(Expedition expedition) {
        return expeditions.containsKey(expedition.getId());
    }

}
