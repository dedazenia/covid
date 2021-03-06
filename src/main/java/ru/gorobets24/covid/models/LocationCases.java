package ru.gorobets24.covid.models;

public class LocationCases {
    private String state;
    private String country;
    private int latestCasesTotal;
    private int newLocalCases;

    public int getNewLocalCases() {
        return newLocalCases;
    }

    public void setNewLocalCases(int newLocalCases) {
        this.newLocalCases = newLocalCases;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestCasesTotal() {
        return latestCasesTotal;
    }

    public void setLatestCasesTotal(int latestCasesTotal) {
        this.latestCasesTotal = latestCasesTotal;
    }

    @Override
    public String toString() {
        return "LocationCases{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestCasesTotal=" + latestCasesTotal +
                '}';
    }
}
