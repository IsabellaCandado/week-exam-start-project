package edu.co.icesi.entities;

public class Expedition {
    private int id;
    private String name;
    private String code;
    private String region;
    private String baseCamp;
    private String leader;
    private String startDate;
    private String endDate;
    private String state;

    public Expedition() {}

    public Expedition(int id, String name, String code, String region, String baseCamp, String leader, String startDate, String endDate, String state) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.region = region;
        this.baseCamp = baseCamp;
        this.leader = leader;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBaseCamp() {
        return baseCamp;
    }

    public void setBaseCamp(String baseCamp) {
        this.baseCamp = baseCamp;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Expedition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", region='" + region + '\'' +
                ", baseCamp='" + baseCamp + '\'' +
                ", leader='" + leader + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
