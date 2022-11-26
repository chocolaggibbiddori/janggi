package unit;

public abstract class Unit {

    private String name;
    private int positionX;
    private int positionY;
    private String teamName;

    public Unit(String name, int positionX, int positionY, String teamName) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.teamName = teamName;
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

    public abstract void move();
    public abstract void remove();
}
