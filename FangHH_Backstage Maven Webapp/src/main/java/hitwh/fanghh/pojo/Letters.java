package hitwh.fanghh.pojo;

public class Letters {
    private Integer lettersId;

    private Integer buildingId;

    private String buildingLetters;

    public Integer getLettersId() {
        return lettersId;
    }

    public void setLettersId(Integer lettersId) {
        this.lettersId = lettersId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingLetters() {
        return buildingLetters;
    }

    public void setBuildingLetters(String buildingLetters) {
        this.buildingLetters = buildingLetters == null ? null : buildingLetters.trim();
    }
}