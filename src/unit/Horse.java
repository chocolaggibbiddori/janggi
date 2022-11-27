package unit;

import board.Board;
import rule.Score;

public class Horse extends Unit {

    public Horse(int positionX, int positionY, String teamName) {
        super("horse", positionX, positionY, teamName, Score.HORSE_SCORE);
    }

    @Override
    protected boolean isPossible(int moveToX, int moveToY) {
        //좌표값 차이가 3이면
        int xDiff = Math.abs(moveToX - positionX);
        int yDiff = Math.abs(moveToY - positionY);

        if (xDiff + yDiff == 3) {
            //x값이나 y값이 같으면 false
            if (moveToX == positionX || moveToY == positionY) {
                return false;
            }

            //멱이 막히면 false
            return !isBlocked(moveToX, moveToY);
        }

        return false;
    }

    private boolean isBlocked(int moveToX, int moveToY) {
        Board board = Board.getInstance();
        int xDiff = positionX - moveToX;
        int yDiff = positionY - moveToY;

        if (xDiff == 2) {
            return board.boardArray[positionX - 1][positionY] != null;
        } else if (xDiff == -2) {
            return board.boardArray[positionX + 1][positionY] != null;
        } else if (yDiff == 2) {
            return board.boardArray[positionX][positionY - 1] != null;
        } else if (yDiff == -2) {
            return board.boardArray[positionX][positionY + 1] != null;
        }

        return false;
    }
}
