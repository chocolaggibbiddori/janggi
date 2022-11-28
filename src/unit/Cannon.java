package unit;

import rule.Score;

public class Cannon extends Unit {
    public Cannon(int positionX, int positionY, String teamName) {
        super("cannon", positionX, positionY, teamName, Score.CANNON_SCORE);
    }

    @Override
    protected boolean isPossible(int moveToX, int moveToY) {
        int xDiff = moveToX - positionX;
        int yDiff = moveToY - positionY;
        boolean isOnXLine = yDiff == 0;
        int diff = (isOnXLine) ? xDiff : yDiff;
        int absDiff = Math.abs(diff);
        int hurdleCount = 0;

        if (isOnLine(moveToX, moveToY)) {
            return false;
        }
        if (diff == 0) {
            return false;
        }

        diff /= absDiff;
        for (int i = 1; i < absDiff; i++) {
            boolean isExistHurdle = isExistHurdle(isOnXLine, diff * i);

            if (isExistHurdle) {
                hurdleCount++;
            }
            if (hurdleCount >= 2) {
                return false;
            }
        }

        return hurdleCount == 1;
    }

    private boolean isOnLine(int moveToX, int moveToY) {
        return positionX != moveToX && positionY != moveToY;
    }

    private boolean isExistHurdle(boolean isOnXLine, int diff) {
        int xIdx = positionX;
        int yIdx = positionY;
        if (isOnXLine) {
            xIdx += diff;
        } else {
            yIdx += diff;
        }

        return board.boardArray[xIdx][yIdx] != null;
    }
}
