package rule;

import board.Board;
import unit.King;
import unit.Unit;

public class Rule {

    Unit[][] units = Board.getInstance().boardArray;

    public boolean isOutOfBoard(int moveToX, int moveToY) {
        boolean isOutX = moveToX < Board.A || moveToX > Board.J;
        boolean isOutY = moveToY < Board.K || moveToY > Board.S;

        if (isOutX || isOutY) {
            System.out.println("해당 위치로 이동할 수 없습니다.");
            return true;
        }

        return false;
    }

    public boolean isKingDie(int moveToX, int moveToY) {
        if (!(units[moveToX][moveToY] instanceof King)) {
            return false;
        }

        System.out.println("Game Over");
        return true;
    }
}
