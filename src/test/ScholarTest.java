package test;

import board.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.Scholar;

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
        Assertions.assertTrue(scholar.move(Board.H, Board.O));
        Assertions.assertTrue(scholar.move(Board.I, Board.O));
        Assertions.assertTrue(scholar.move(Board.J, Board.N));
        Assertions.assertTrue(scholar.move(Board.I, Board.O));
    }

    @Test
    void scholarFailTest() {
        Assertions.assertFalse(scholar.move(Board.H, Board.M));
        Assertions.assertFalse(scholar.move(Board.G, Board.N));
        Assertions.assertFalse(scholar.move(Board.J, Board.P));
        Assertions.assertFalse(scholar.move(Board.J, Board.N));
    }
}