package game;

import board.Board;
import unit.Unit;

public class View {

    public void drawBoard(Unit[][] units) {
        String[] boardRowArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] boardColArray = {"K", "L", "M", "N", "O", "P", "Q", "R", "S"};

        int rowLength = units.length;
        int colLength = units[0].length;

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
                }
            }
            System.out.println();
            if (i != rowLength - 1) {
                for (int num = 1; num <= 2; num++) {
                    for (int c = 0; c < colLength; c++) {
                        if (c != colLength - 1) {
                            System.out.print("    |   ");
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
}
