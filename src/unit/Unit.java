package unit;

import board.Board;

public abstract class Unit {

    protected final String name;
    protected int positionX;
    protected int positionY;
    protected final String teamName;
    protected final int unitScore;
    protected final boolean isGreen;
    protected final Board board = Board.getInstance();

    public Unit(String name, int positionX, int positionY, String teamName, int unitScore) {
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.teamName = teamName;
        this.unitScore = unitScore;
        isGreen = teamName.equals(Board.TEAM_GREEN);
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
        return teamName + ", " + name;
    }

    public boolean move(int moveToX, int moveToY) {
        if (!isPossible(moveToX, moveToY)) {
            return false;
        }

        board.boardArray[positionX][positionY] = null;
        setPositionX(moveToX);
        setPositionY(moveToY);
        board.boardArray[positionX][positionY] = this;
        return true;
    }

    protected abstract boolean isPossible(int moveToX, int moveToY);

    // TODO 다른 클래스로 이동할 것
    public boolean isMoveToInBoard(int moveToX, int moveToY) {
        return (moveToX < 0) || (moveToX >= Board.BOARD_HEIGHT) || (moveToY < 0) || (moveToY >= Board.BOARD_WIDTH);
    }
}
