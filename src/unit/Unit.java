package unit;

import board.Board;
import game.Game;
import rule.Rule;

public abstract class Unit {

    protected final String name;
    protected int positionX;
    protected int positionY;
    protected final String teamName;
    protected final int unitScore;
    protected final boolean isGreen;
    protected final Board board = Board.getInstance();
    private final Rule rule = new Rule();

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
        String teamName = (this.teamName.equals(Board.TEAM_GREEN)) ? "G" : "R";
        return teamName + name.substring(0, 3);
    }

    public boolean move(int moveToX, int moveToY) {
        Unit unit = board.boardArray[moveToX][moveToY];

        if (unit != null && unit.getTeamName().equals(this.teamName)) {
            System.out.println("해당 지점으로 이동할 수 없습니다.");
            return false;
        }
        if (!isPossible(moveToX, moveToY)) {
            System.out.println("해당 지점으로 이동할 수 없습니다.");
            return false;
        }

        if (rule.isKingDie(moveToX, moveToY)) {
            Game.gameOver = true;
        }
        if (unit != null) {
            if (unit.getTeamName().equals(Board.TEAM_GREEN)) {
                Game.greenScore -= unit.getUnitScore();
            } else {
                Game.redScore -= unit.getUnitScore();
            }
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
