package edu.co.icesi.entities;

public class Sighting {
    private int id;
    private String sightingCode;
    private String name;
    private String description;
    private String scientificName;
    private String sightedAt;
    private String location;
    private int quantity;
    private int confidenceLevel;
    private int expeditionId;

    public Sighting() {}

    public Sighting(int id, String sightingCode, String name, String description, String scientificName, String sightedAt, String location, int quantity, int confidenceLevel, int expeditionId) {
        this.id = id;
        this.sightingCode = sightingCode;
        this.name = name;
        this.description = description;
        this.scientificName = scientificName;
        this.sightedAt = sightedAt;
        this.location = location;
        this.quantity = quantity;
        this.confidenceLevel = confidenceLevel;
        this.expeditionId = expeditionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSightingCode() {
        return sightingCode;
    }

    public void setSightingCode(String sightingCode) {
        this.sightingCode = sightingCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getSightedAt() {
        return sightedAt;
    }

    public void setSightedAt(String sightedAt) {
        this.sightedAt = sightedAt;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getConfidenceLevel() {
        return confidenceLevel;
    }

    public void setConfidenceLevel(int confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }

    public int getExpeditionId() {
        return expeditionId;
    }

    public void setExpeditionId(int expeditionId) {
        this.expeditionId = expeditionId;
    }

    @Override
    public String toString() {
        return "Sighting{" +
                "id=" + id +
                ", sightingCode='" + sightingCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", sightedAt='" + sightedAt + '\'' +
                ", location='" + location + '\'' +
                ", quantity=" + quantity +
                ", confidenceLevel=" + confidenceLevel +
                ", expeditionId=" + expeditionId +
                '}';
    }
}
