package unit;

import rule.Score;

public class Elephant extends Unit {

    public Elephant(int positionX, int positionY, String teamName) {
        super("elephant", positionX, positionY, teamName, Score.ELEPHANT_SCORE);
    }

    @Override
    protected boolean isPossible(int moveToX, int moveToY) {
        int xDiff = Math.abs(moveToX - positionX);
        int yDiff = Math.abs(moveToY - positionY);
        
        if (xDiff + yDiff != 5) {
            return false;
        }
        if (moveToX == positionX || moveToY == positionY) {
            return false;
        }
        if (xDiff == 4 || yDiff == 4) {
            return false;
        }

        return !isBlocked(moveToX, moveToY);
    }

    private boolean isBlocked(int moveToX, int moveToY) {
        int xDiff = positionX - moveToX;
        int yDiff = positionY - moveToY;
        boolean isXLong = (Math.abs(xDiff) == 3);
        int xFirst, yFirst;
        int xSecond, ySecond;

        if (isXLong) {
            xFirst = positionX - xDiff / 3;
            yFirst = positionY;
            xSecond = positionX - xDiff * 2 / 3;
            ySecond = positionY - yDiff / 2;
        } else {
            xFirst = positionX;
            yFirst = positionY - yDiff / 3;
            xSecond = positionX - xDiff / 2;
            ySecond = positionY - yDiff * 2 / 3;
        }

        boolean isBlockedFirst = board.boardArray[xFirst][yFirst] != null;
        boolean isBlockedSecond = board.boardArray[xSecond][ySecond] != null;

        return isBlockedFirst || isBlockedSecond;
    }
}
