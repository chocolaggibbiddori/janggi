package rule;

import board.Board;
import unit.King;
import unit.Unit;

public class Rule {

    Unit[][] units = Board.getInstance().boardArray;

    public boolean isRightInput(String point) {
        if (point == null) {
            return false;
        }
        return isLengthTwo(point) && !isOutOfBoard(point);
    }

    public boolean isLengthTwo(String point) {
        if (point.length() != 2) {
            System.out.println("올바른 위치를 입력하여 주십시오.");
            return false;
        }

        return true;
    }

    public boolean isOutOfBoard(String point) {
        char first = point.charAt(0);
        char second = point.charAt(1);
        boolean isOutX = first < 'a' || first > 'j';
        boolean isOutY = second < 'k' || second > 's';

        if (isOutX || isOutY) {
            System.out.println("보드 바깥 지점입니다.");
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
