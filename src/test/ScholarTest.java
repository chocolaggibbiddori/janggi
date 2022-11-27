package test;

import board.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.Scholar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScholarTest {

    Scholar scholar;

    @BeforeEach
    void beforeEach() {
        scholar = new Scholar(Board.C, Board.N, Board.TEAM_RED);
        System.out.println("------------------");
        System.out.println("scholar = " + scholar);
    }

    @AfterEach
    void afterEach() {
        System.out.println("scholar = " + scholar);
    }

    @Test
    void scholarSuccessTest() {
        assertTrue(scholar.move(Board.C, Board.O));
        assertTrue(scholar.move(Board.B, Board.O));
        assertTrue(scholar.move(Board.A, Board.N));
        assertTrue(scholar.move(Board.B, Board.O));
    }

    @Test
    void scholarFailTest() {
        assertFalse(scholar.move(Board.C, Board.M));
        assertFalse(scholar.move(Board.D, Board.N));
        assertFalse(scholar.move(Board.A, Board.P));
        assertFalse(scholar.move(Board.A, Board.N));
    }
}