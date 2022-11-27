package unit;

import board.Board;
import rule.Score;

public class Soldier extends Unit {

    boolean isGreen = getTeamName().equals(Board.TEAM_GREEN);
    int forwardDirect = isGreen ? -1 : 1;

    public Soldier(int positionX, int positionY, String teamName) {
        super("soldier", positionX, positionY, teamName, Score.SOLDIER_SCORE);
    }

    @Override
    protected boolean isPossible(int moveToX, int moveToY, int positionX, int positionY) {
        if (isAbleToMoveForward(moveToX, moveToY, positionX, positionY)) {
            return true;
        } else if (isAbleToMoveSide(moveToX, moveToY, positionX, positionY)) {
            return true;
        } else if (isAbleToMoveDiagonal(moveToX, moveToY, positionX, positionY)) {
            return true;
        }

        return false;
    }

    private boolean isAbleToMoveForward(int moveToX, int moveToY, int positionX, int positionY) {
        return positionX + forwardDirect == moveToX && positionY == moveToY;
    }

    private boolean isAbleToMoveSide(int moveToX, int moveToY, int positionX, int positionY) {
        return positionX == moveToX && (positionY - 1 == moveToY || positionY + 1 == moveToY);
    }

    private boolean isAbleToMoveDiagonal(int moveToX, int moveToY, int positionX, int positionY) {
        if (!isInPalace(positionX, positionY)) {
            return false;
        }
        if (!isInPalace(moveToX, moveToY)) {
            return false;
        }

        if (isGreen) {
            if (positionX == Board.C && moveToX == Board.B && moveToY == Board.O) {
                return true;
            } else if (positionX == Board.B && positionY == Board.O && moveToX == Board.A) {
                return true;
            }
        } else {
            if (positionX == Board.H && moveToX == Board.I && moveToY == Board.O) {
                return true;
            } else if (positionX == Board.I && positionY == Board.O && moveToX == Board.J) {
                return true;
            }
        }

        return false;
    }

    private boolean isInPalace(int positionX, int positionY) {
        if (isGreen) {
            return (positionX >= Board.A && positionX <= Board.C) && (positionY >= Board.N && positionY <= Board.P);
        } else {
            return (positionX >= Board.H && positionX <= Board.J) && (positionY >= Board.N && positionY <= Board.P);
        }
    }
}
