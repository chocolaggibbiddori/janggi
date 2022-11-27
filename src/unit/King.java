package unit;

import board.Board;
import rule.Score;

public class King extends Unit{

    private final boolean isGreen = getTeamName().equals(Board.TEAM_GREEN);
    public boolean life = true;

    public King(int positionX, int positionY, String teamName) {
        super("king", positionX, positionY, teamName, Score.KING_SCORE);
    }

    @Override
    protected boolean isPossible(int moveToX, int moveToY, int positionX, int positionY) {
        if (isAbleToMoveNEWS(moveToX, moveToY, positionX, positionY)) {
            return true;
        } else if (isAbleToMoveDiagonal(moveToX, moveToY, positionX, positionY)) {
            return true;
        }

        return false;
    }

    private boolean isAbleToMoveNEWS(int moveToX, int moveToY, int positionX, int positionY) {
        if (checkInPalaceWithFourPoint(moveToX, moveToY, positionX, positionY)) {
            return false;
        }

        if (moveToX == positionX) {
            return Math.abs(moveToY - positionY) == 1;
        } else if (moveToY == positionY) {
            return Math.abs(moveToX - positionX) == 1;
        }

        return false;
    }

    private boolean checkInPalaceWithFourPoint(int moveToX, int moveToY, int positionX, int positionY) {
        if (!isInPalace(positionX, positionY)) {
            return true;
        }
        if (!isInPalace(moveToX, moveToY)) {
            return true;
        }
        return false;
    }

    private boolean isInPalace(int positionX, int positionY) {
        if (isGreen) {
            return (positionX >= Board.H && positionX <= Board.J) && (positionY >= Board.N && positionY <= Board.P);
        } else {
            return (positionX >= Board.A && positionX <= Board.C) && (positionY >= Board.N && positionY <= Board.P);
        }
    }

    private boolean isAbleToMoveDiagonal(int moveToX, int moveToY, int positionX, int positionY) {
        if (checkInPalaceWithFourPoint(moveToX, moveToY, positionX, positionY)) {
            return false;
        }

        return isCenterOfPalace(moveToX, moveToY) || isCenterOfPalace(positionX, positionY);
    }

    private boolean isCenterOfPalace(int positionX, int positionY) {
        if (isGreen) {
            return positionX == Board.I && positionY == Board.O;
        } else {
            return positionX == Board.B && positionY == Board.O;
        }
    }
}
