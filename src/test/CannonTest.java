package test;

import board.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.Cannon;
import unit.Horse;
import unit.Soldier;
import unit.Unit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CannonTest {

    Board board = Board.getInstance();
    Cannon cannon;

    @BeforeEach
    void beforeEach() {
        cannon = new Cannon(Board.H, Board.L, Board.TEAM_GREEN);
        board.boardArray[7][1] = cannon;
        board.boardArray[7][3] = new Horse(Board.H, Board.N, Board.TEAM_GREEN);
        board.boardArray[7][5] = new Horse(Board.H, Board.P, Board.TEAM_GREEN);
        board.boardArray[6][1] = new Soldier(Board.G, Board.L, Board.TEAM_GREEN);
    }

    @AfterEach
    void afterEach() {
        for (Unit[] units : board.boardArray) {
            for (Unit unit : units) {
                unit = null;
            }
        }
    }

    @Test
    void cannonSuccessTest() {
        assertTrue(cannon.move(Board.H, Board.O));
        assertTrue(cannon.move(Board.H, Board.L));
        assertTrue(cannon.move(Board.B, Board.L));
        assertTrue(cannon.move(Board.J, Board.L));
    }

    @Test
    void cannonFailTest() {
        assertFalse(cannon.move(Board.H, Board.M));
        assertFalse(cannon.move(Board.H, Board.Q));
        assertFalse(cannon.move(Board.J, Board.L));
    }
}
