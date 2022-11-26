package board;

import unit.Unit;

public class Board {

    private static Board board = null;

    public static final int BOARD_WIDTH = 9;
    public static final int BOARD_HEIGHT = 10;
    public static final String TEAM_GREEN = "Green";
    public static final String TEAM_RED = "Red";
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 3;
    public static final int E = 4;
    public static final int F = 5;
    public static final int G = 6;
    public static final int H = 7;
    public static final int I = 8;

    public Unit[][] boardArray = new Unit[BOARD_WIDTH][BOARD_HEIGHT];

    private Board() {}

    public Board getInstance() {
        if (board == null) {
            board = new Board();
        }

        return board;
    }
}
