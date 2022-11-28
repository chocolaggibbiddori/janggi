package unit;

import board.Board;
import rule.Score;

import java.util.ArrayList;

public class Car extends Unit{

    Board board;

    public Car(int positionX, int positionY, String teamName) {
        super("car", positionX, positionY, teamName, Score.CAR_SCORE);
        board = Board.getInstance();
    }

    @Override
    protected boolean isPossible(int moveToX, int moveToY) {
        boolean moveDirectIsX;
        int xDiff = moveToX - positionX;
        int yDiff = moveToY - positionY;
        ArrayList<Integer> steps = new ArrayList<>();

        if (isOnLine(moveToX, moveToY)) {
            return false;
        }

        moveDirectIsX = (positionX != moveToX);
        if (moveDirectIsX) {
            addSteps(steps, xDiff);
            return !isBlocked(positionX, moveToX, steps, true);
        } else {
            addSteps(steps, yDiff);
            return !isBlocked(positionY, moveToY, steps, false);
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

    private boolean isBlocked(int start, int end, ArrayList<Integer> steps, boolean moveDirectIsX) {
        if (moveDirectIsX) {
            for (int step : steps) {
                if (board.boardArray[start + step][positionY] != null) {
                    return true;
                }
            }
        } else {
            for (int step : steps) {
                if (board.boardArray[positionX][end + step] != null) {
                    return true;
                }
            }
        }

        return false;
    }
}
