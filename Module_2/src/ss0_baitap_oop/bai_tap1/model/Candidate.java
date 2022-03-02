package ss0_baitap_oop.bai_tap1.model;

public class Candidate {
    private int id;
    private String name;
    private String dateOffBirth;
    private int scoreToan;
    private int scoreVan;
    private int scoreAnh;
    public Candidate() {

    }

    public Candidate(int id, String name, String dateOffBirth, int scoreToan, int scoreVan, int scoreAnh) {
        this.id = id;
        this.name = name;
        this.dateOffBirth = dateOffBirth;
        this.scoreToan = scoreToan;
        this.scoreVan = scoreVan;
        this.scoreAnh = scoreAnh;
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

    public String getDateOffBirth() {
        return dateOffBirth;
    }

    public void setDateOffBirth(String dateOffBirth) {
        this.dateOffBirth = dateOffBirth;
    }

    public int getScoreToan() {
        return scoreToan;
    }

    public void setScoreToan(int scoreToan) {
        this.scoreToan = scoreToan;
    }

    public int getScoreVan() {
        return scoreVan;
    }

    public void setScoreVan(int scoreVan) {
        this.scoreVan = scoreVan;
    }

    public int getScoreAnh() {
        return scoreAnh;
    }

    public void setScoreAnh(int scoreAnh) {
        this.scoreAnh = scoreAnh;
    }

    @Override
    public String toString() {
        return "Candidate{" + "id=" + getId() + ", name='" + getName() +  ", dateOffBirth='" + getDateOffBirth()  +
                ", scoreToan=" + getScoreToan() + ", scoreVan=" + getScoreVan() + ", scoreAnh=" + getScoreAnh() + '}';
    }
}
