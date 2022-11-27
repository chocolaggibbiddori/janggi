package unit;

import board.Board;

public abstract class Unit {

    private final String name;
    private int positionX;
    private int positionY;
    private final String teamName;
    private final int unitScore;

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
    public String getTeamName() {
        return teamName;
    }
    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "(" + positionX + ", " + positionY + ")";
    }

    public boolean move(int moveToX, int moveToY) {
        int positionX = getPositionX();
        int positionY = getPositionY();

        if (isPossible(moveToX, moveToY, positionX, positionY)) {
            setPositionX(moveToX);
            setPositionY(moveToY);
            return true;
        }

        return false;
    }

    protected abstract boolean isPossible(int moveToX, int moveToY, int positionX, int positionY);

    // TODO 다른 클래스로 이동할 것
    public boolean isMoveToInBoard(int moveToX, int moveToY) {
        return (moveToX < 0) || (moveToX >= Board.BOARD_HEIGHT) || (moveToY < 0) || (moveToY >= Board.BOARD_WIDTH);
    }
}
