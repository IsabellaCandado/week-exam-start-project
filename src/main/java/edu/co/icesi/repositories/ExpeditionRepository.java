package edu.co.icesi.repositories;

import edu.co.icesi.entities.Expedition;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class ExpeditionRepository {
    private HashMap<Integer, Expedition> expeditions;

    public ExpeditionRepository() {
        expeditions = new HashMap<>();
    }

    @PostConstruct
    public void init() {
        Expedition expedition1 = new Expedition();
        expedition1.setId(1);
        expedition1.setName("Expedition 1");
        expedition1.setCode("12345");
        expedition1.setRegion("Amazonia");
        expedition1.setBaseCamp("Leticia");
        expedition1.setLeader("Isabella");
        expedition1.setStartDate("2026-09-01");
        expedition1.setEndDate("2026-09-03");
        expedition1.setState("Completed");
        expeditions.put(1, expedition1);

        Expedition expedition2 = new Expedition();
        expedition2.setId(2);
        expedition2.setName("Expedition 2");
        expedition2.setCode("54321");
        expedition2.setRegion("Pacific Coast");
        expedition2.setBaseCamp("Choco");
        expedition2.setLeader("Jhoan");
        expedition2.setStartDate("2026-08-29");
        expedition2.setEndDate("2026-09-03");
        expedition2.setState("Completed");
        expeditions.put(2, expedition2);
    }

    public void add(Expedition expedition) {
        expeditions.put(expedition.getId(), expedition);
    }

    public Collection<Expedition> findAll() {
        return expeditions.values();
    }

    public boolean contains(int id) {
        return expeditions.containsKey(id);
    }

    public Expedition get(int id) {
        return expeditions.get(id);
    }

    public boolean containsByCode(String code) {
        for (Expedition expedition : expeditions.values()) {
            if (expedition.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public void delete(int id) {
        expeditions.remove(id);
    }

}
