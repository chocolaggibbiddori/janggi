package test;

import board.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.Elephant;
import unit.Horse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ElephantTest {

    Elephant elephant;
    Board board;

    @BeforeEach
    void beforeEach() {
        elephant = new Elephant(Board.J, Board.M, Board.TEAM_GREEN);
        board = Board.getInstance();
        System.out.println("------------------");
        System.out.println("elephant = " + elephant);
    }

    @AfterEach
    void afterEach() {
        System.out.println("elephant = " + elephant);
    }

    @Test
    void scholarSuccessTest() {
        assertTrue(elephant.move(Board.G, Board.O));
        assertTrue(elephant.move(Board.D, Board.M));
        assertTrue(elephant.move(Board.F, Board.P));
        assertTrue(elephant.move(Board.H, Board.M));
    }

    @Test
    void scholarFailTest() {
        board.boardArray[7][3] = new Horse(7, 3, Board.TEAM_GREEN);
        assertFalse(elephant.move(Board.G, Board.O));
        assertFalse(elephant.move(Board.E, Board.M));
        assertFalse(elephant.move(Board.I, Board.P));
        assertFalse(elephant.move(Board.H, Board.K));
    }
}