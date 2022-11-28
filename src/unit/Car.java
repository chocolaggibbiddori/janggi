package unit;

import rule.Score;

import java.util.ArrayList;

public class Car extends Unit{

    public Car(int positionX, int positionY, String teamName) {
        super("car", positionX, positionY, teamName, Score.CAR_SCORE);
    }

    @Override
    protected boolean isPossible(int moveToX, int moveToY) {
        int xDiff = moveToX - positionX;
        int yDiff = moveToY - positionY;
        ArrayList<Integer> steps = new ArrayList<>();

        if (isOnLine(moveToX, moveToY)) {
            return false;
        }

        if (positionX != moveToX) {
            addSteps(steps, xDiff);
            return !isBlocked(steps, true);
        } else {
            addSteps(steps, yDiff);
            return !isBlocked(steps, false);
        }
    }

    private boolean isOnLine(int moveToX, int moveToY) {
        return positionX != moveToX && positionY != moveToY;
    }

    private void addSteps(ArrayList<Integer> steps, int diff) {
        int absDiff = Math.abs(diff);
        if (absDiff == 1) {
            return;
        }

        steps.add(diff / absDiff);
        for (int i = 1; i < absDiff - 1; i++) {
            steps.add(steps.get(0) * (i + 1));
        }
    }

    private boolean isBlocked(ArrayList<Integer> steps, boolean moveDirectIsX) {
        for (int step : steps) {
            boolean isBlock = moveDirectIsX ? isBlockedCheck(step, 0) : isBlockedCheck(0, step);
            if (isBlock) {
                return true;
            }
        }

        return false;
    }

    private boolean isBlockedCheck(int xIdx, int yIdx) {
        return board.boardArray[positionX + xIdx][positionY + yIdx] != null;
    }
}
