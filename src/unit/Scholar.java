package unit;

import board.Board;
import rule.Score;

public class Scholar extends Unit{

    public Scholar(int positionX, int positionY, String teamName) {
        super("scholar", positionX, positionY, teamName, Score.SCHOLAR_SCORE);
    }

    @Override
    protected boolean isPossible(int moveToX, int moveToY) {
        if (isAbleToMoveNEWS(moveToX, moveToY)) {
            return true;
        } else if (isAbleToMoveDiagonal(moveToX, moveToY)) {
            return true;
        }

        return false;
    }

    private boolean isAbleToMoveNEWS(int moveToX, int moveToY) {
        if (checkInPalaceWithFourPoint(moveToX, moveToY)) {
            return false;
        }

        if (moveToX == positionX) {
            return Math.abs(moveToY - positionY) == 1;
        } else if (moveToY == positionY) {
            return Math.abs(moveToX - positionX) == 1;
        }

        return false;
    }

    private boolean checkInPalaceWithFourPoint(int moveToX, int moveToY) {
        if (!isInPalace(positionX, positionY)) {
            return true;
        }
        if (!isInPalace(moveToX, moveToY)) {
            return true;
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

    private boolean isAbleToMoveDiagonal(int moveToX, int moveToY) {
        if (checkInPalaceWithFourPoint(moveToX, moveToY)) {
            return false;
        }

        return isCenterOfPalace(moveToX, moveToY) || isCenterOfPalace(positionX, positionY);
    }

    private boolean isCenterOfPalace(int pointX, int pointY) {
        if (isGreen) {
            return pointX == Board.I && pointY == Board.O;
        } else {
            return pointX == Board.B && pointY == Board.O;
        }
    }
}
