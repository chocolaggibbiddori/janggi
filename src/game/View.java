package game;

import board.Board;
import unit.Unit;

public class View {

    public void drawBoard(Unit[][] units) {
        String[] boardRowArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] boardColArray = {"K", "L", "M", "N", "O", "P", "Q", "R", "S"};

        int rowLength = units.length;
        int colLength = units[0].length;

        for (int i = 0; i < colLength; i++) {
            System.out.print("    ");
            System.out.print(boardColArray[i]);
            System.out.print("   ");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < rowLength; i++) {
            System.out.print(boardRowArray[i] + "  ");
            for (int j = 0; j < colLength; j++) {
                if (units[i][j] == null) {
                    System.out.print("    ");
                } else {
                    System.out.print(units[i][j]);
                }
                if (j != colLength - 1) {
                    System.out.print("----");
                } else {
                    System.out.println("  " + boardRowArray[i]);
                }
            }
            if (i != rowLength - 1) {
                for (int num = 1; num <= 2; num++) {
                    for (int c = 0; c < colLength; c++) {
                        if (c != colLength - 1) {
                            if (i == 0 || i == 7) {
                                if (num == 1) {
                                    if (c == 3) {
                                        System.out.print("    |  \\");
                                    } else if (c == 5) {
                                        System.out.print(" /  |   ");
                                    } else {
                                        System.out.print("    |   ");
                                    }
                                } else {
                                    if (c == 4) {
                                        System.out.print(" \\  |  /");
                                    } else {
                                        System.out.print("    |   ");
                                    }
                                }
                            } else if (i == 1 || i == 8) {
                                if (num == 1) {
                                    if (c == 4) {
                                        System.out.print(" /  |  \\");
                                    } else {
                                        System.out.print("    |   ");
                                    }
                                } else {
                                    if (c == 3) {
                                        System.out.print("    |  /");
                                    } else if (c == 5) {
                                        System.out.print(" \\  |   ");
                                    } else {
                                        System.out.print("    |   ");
                                    }
                                }
                            } else {
                                System.out.print("    |   ");
                            }
                        } else {
                            System.out.println("    |  ");
                        }
                    }
                }
            }
        }
        System.out.println();

        for (int i = 0; i < colLength; i++) {
            System.out.print("    ");
            System.out.print(boardColArray[i]);
            System.out.print("   ");
        }
        System.out.println();
    }

    public void drawScore(int greenScore, double redScore) {
        System.out.println("초나라 점수: " + greenScore);
        System.out.println("한나라 점수: " + redScore);
        System.out.println();
    }
}
