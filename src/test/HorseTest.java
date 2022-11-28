package test;

import board.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.Horse;
import unit.Soldier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HorseTest {

    Horse horse;
    Board board;

    @BeforeEach
    void beforeEach() {
        horse = new Horse(Board.H, Board.N, Board.TEAM_GREEN);
        board = Board.getInstance();
        System.out.println("------------------");
        System.out.println("horse = " + horse);
    }

    @AfterEach
    void afterEach() {
        System.out.println("horse = " + horse);
    }

    @Test
    void scholarSuccessTest() {
        assertTrue(horse.move(Board.F, Board.O));
        assertTrue(horse.move(Board.E, Board.M));
        assertTrue(horse.move(Board.G, Board.L));
        assertTrue(horse.move(Board.H, Board.N));
    }

    @Test
    void scholarFailTest() {
        board.boardArray[Board.G][Board.N] = new Soldier(Board.G, Board.N, Board.TEAM_GREEN);
        assertFalse(horse.move(Board.F, Board.O));
        assertFalse(horse.move(Board.E, Board.N));
        assertFalse(horse.move(Board.H, Board.Q));
        assertFalse(horse.move(Board.H, Board.N));
        assertFalse(horse.move(Board.F, Board.P));
    }
}