package unit;

public abstract class Unit {

    private String name;
    private int positionX;
    private int positionY;
    private String teamName;
    private int unitScore;


    public Unit(String name, int positionX, int positionY, String teamName, int unitScore) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.teamName = teamName;
        this.unitScore = unitScore;
    }

    public int getUnitScore() {
        return unitScore;
    }
    public void setUnitScore(int unitScore) {
        this.unitScore = unitScore;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPositionX() {
        return positionX;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public abstract void move(int moveToX, int moveToY);
}
