package unit;

import board.Board;
import rule.Score;

public class Soldier extends Unit {

    int forwardDirect = isGreen ? -1 : 1;

    public Soldier(int positionX, int positionY, String teamName) {
        super("soldier", positionX, positionY, teamName, Score.SOLDIER_SCORE);
    }

    @Override
    protected boolean isPossible(int moveToX, int moveToY) {
        if (isAbleToMoveForward(moveToX, moveToY)) {
            return true;
        } else if (isAbleToMoveSide(moveToX, moveToY)) {
            return true;
        } else if (isAbleToMoveDiagonal(moveToX, moveToY)) {
            return true;
        }

        return false;
    }

    private boolean isAbleToMoveForward(int moveToX, int moveToY) {
        return positionX + forwardDirect == moveToX && positionY == moveToY;
    }

    private boolean isAbleToMoveSide(int moveToX, int moveToY) {
        return positionX == moveToX && (positionY - 1 == moveToY || positionY + 1 == moveToY);
    }

    private boolean isAbleToMoveDiagonal(int moveToX, int moveToY) {
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

    private boolean isInPalace(int pointX, int pointY) {
        if (isGreen) {
            return (pointX >= Board.H && pointX <= Board.J) && (pointY >= Board.N && pointY <= Board.P);
        } else {
            return (pointX >= Board.A && pointX <= Board.C) && (pointY >= Board.N && pointY <= Board.P);
        }
    }
}
