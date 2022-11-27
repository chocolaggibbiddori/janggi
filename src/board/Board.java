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
    public static final int J = 9;

    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;
    public static final int O = 4;
    public static final int P = 5;
    public static final int Q = 6;
    public static final int R = 7;
    public static final int S = 8;

    public Unit[][] boardArray = new Unit[BOARD_HEIGHT][BOARD_WIDTH];

    private Board() {}

    public static Board getInstance() {
        if (board == null) {
            board = new Board();
        }

        return board;
    }
}
