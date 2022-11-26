package test;

import board.Board;
import unit.Soldier;
import unit.Unit;

public class SoldierTest {

    Board boardInstance = Board.getInstance();
    Unit[][] board = boardInstance.boardArray;

    public void greenSuccessTest() {
        Soldier soldier1 = new Soldier(Board.G, Board.K, Board.TEAM_GREEN);
        Soldier soldier2 = new Soldier(Board.C, Board.N, Board.TEAM_GREEN);
        Soldier soldier3 = new Soldier(Board.C, Board.P, Board.TEAM_GREEN);
        Soldier soldier4 = new Soldier(Board.B, Board.O, Board.TEAM_GREEN);
        Soldier soldier5 = new Soldier(Board.B, Board.O, Board.TEAM_GREEN);
        Soldier soldier6 = new Soldier(Board.B, Board.O, Board.TEAM_GREEN);

        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        soldier1.move(Board.F, Board.K);
        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        soldier1.move(Board.F, Board.L);
        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        soldier1.move(Board.F, Board.K);
        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier2.getPositionX() + ", " + soldier2.getPositionY() + ")");
        soldier2.move(Board.B, Board.O);
        System.out.println("(" + soldier2.getPositionX() + ", " + soldier2.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier3.getPositionX() + ", " + soldier3.getPositionY() + ")");
        soldier3.move(Board.B, Board.O);
        System.out.println("(" + soldier3.getPositionX() + ", " + soldier3.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier4.getPositionX() + ", " + soldier4.getPositionY() + ")");
        soldier4.move(Board.A, Board.N);
        System.out.println("(" + soldier4.getPositionX() + ", " + soldier4.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier5.getPositionX() + ", " + soldier5.getPositionY() + ")");
        soldier5.move(Board.A, Board.P);
        System.out.println("(" + soldier5.getPositionX() + ", " + soldier5.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier6.getPositionX() + ", " + soldier6.getPositionY() + ")");
        soldier6.move(Board.A, Board.O);
        System.out.println("(" + soldier6.getPositionX() + ", " + soldier6.getPositionY() + ")");
        System.out.println("-------------------------------------------");
    }

    public void redSuccessTest() {
        Soldier soldier1 = new Soldier(Board.E, Board.K, Board.TEAM_RED);
        Soldier soldier2 = new Soldier(Board.H, Board.N, Board.TEAM_RED);
        Soldier soldier3 = new Soldier(Board.H, Board.P, Board.TEAM_RED);
        Soldier soldier4 = new Soldier(Board.I, Board.O, Board.TEAM_RED);
        Soldier soldier5 = new Soldier(Board.I, Board.O, Board.TEAM_RED);
        Soldier soldier6 = new Soldier(Board.I, Board.O, Board.TEAM_RED);

        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        soldier1.move(Board.F, Board.K);
        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        soldier1.move(Board.F, Board.L);
        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        soldier1.move(Board.F, Board.K);
        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier2.getPositionX() + ", " + soldier2.getPositionY() + ")");
        soldier2.move(Board.I, Board.O);
        System.out.println("(" + soldier2.getPositionX() + ", " + soldier2.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier3.getPositionX() + ", " + soldier3.getPositionY() + ")");
        soldier3.move(Board.I, Board.O);
        System.out.println("(" + soldier3.getPositionX() + ", " + soldier3.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier4.getPositionX() + ", " + soldier4.getPositionY() + ")");
        soldier4.move(Board.J, Board.N);
        System.out.println("(" + soldier4.getPositionX() + ", " + soldier4.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier5.getPositionX() + ", " + soldier5.getPositionY() + ")");
        soldier5.move(Board.J, Board.P);
        System.out.println("(" + soldier5.getPositionX() + ", " + soldier5.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier6.getPositionX() + ", " + soldier6.getPositionY() + ")");
        soldier6.move(Board.J, Board.O);
        System.out.println("(" + soldier6.getPositionX() + ", " + soldier6.getPositionY() + ")");
        System.out.println("-------------------------------------------");
    }

    public void greenFailTest() {
        Soldier soldier1 = new Soldier(Board.G, Board.K, Board.TEAM_GREEN);
        Soldier soldier2 = new Soldier(Board.C, Board.N, Board.TEAM_GREEN);

        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        soldier1.move(Board.H, Board.K);
        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        soldier1.move(Board.F, Board.L);
        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        soldier1.move(Board.E, Board.K);
        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier2.getPositionX() + ", " + soldier2.getPositionY() + ")");
        soldier2.move(Board.B, Board.P);
        System.out.println("(" + soldier2.getPositionX() + ", " + soldier2.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier2.getPositionX() + ", " + soldier2.getPositionY() + ")");
        soldier2.move(Board.A, Board.P);
        System.out.println("(" + soldier2.getPositionX() + ", " + soldier2.getPositionY() + ")");
        System.out.println("-------------------------------------------");
    }

    public void redFailTest() {
        Soldier soldier1 = new Soldier(Board.E, Board.K, Board.TEAM_RED);
        Soldier soldier2 = new Soldier(Board.H, Board.N, Board.TEAM_RED);

        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        soldier1.move(Board.D, Board.K);
        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        soldier1.move(Board.F, Board.L);
        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        soldier1.move(Board.G, Board.K);
        System.out.println("(" + soldier1.getPositionX() + ", " + soldier1.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier2.getPositionX() + ", " + soldier2.getPositionY() + ")");
        soldier2.move(Board.I, Board.P);
        System.out.println("(" + soldier2.getPositionX() + ", " + soldier2.getPositionY() + ")");
        System.out.println("-------------------------------------------");

        System.out.println("(" + soldier2.getPositionX() + ", " + soldier2.getPositionY() + ")");
        soldier2.move(Board.J, Board.P);
        System.out.println("(" + soldier2.getPositionX() + ", " + soldier2.getPositionY() + ")");
        System.out.println("-------------------------------------------");
    }
}
