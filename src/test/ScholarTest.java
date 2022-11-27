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
        scholar = new Scholar(Board.H, Board.N, Board.TEAM_GREEN);
        System.out.println("------------------");
        System.out.println("scholar = " + scholar);
    }

    @AfterEach
    void afterEach() {
        System.out.println("scholar = " + scholar);
    }

    @Test
    void scholarSuccessTest() {
        assertTrue(scholar.move(Board.H, Board.O));
        assertTrue(scholar.move(Board.I, Board.O));
        assertTrue(scholar.move(Board.J, Board.N));
        assertTrue(scholar.move(Board.I, Board.O));
    }

    @Test
    void scholarFailTest() {
        assertFalse(scholar.move(Board.H, Board.M));
        assertFalse(scholar.move(Board.G, Board.N));
        assertFalse(scholar.move(Board.J, Board.P));
        assertFalse(scholar.move(Board.J, Board.N));
    }
}