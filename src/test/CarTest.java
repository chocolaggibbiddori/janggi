package test;

import board.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.Car;
import unit.Horse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    Car car;
    Board board = Board.getInstance();

    @BeforeEach
    void beforeEach() {
        car = new Car(Board.J, Board.K, Board.TEAM_GREEN);
        System.out.println("------------------");
        System.out.println("car = " + car);
    }

    @AfterEach
    void afterEach() {
        System.out.println("car = " + car);
    }

    @Test
    void carSuccessTest() {
        assertTrue(car.move(Board.A, Board.K));
        assertTrue(car.move(Board.A, Board.P));
        assertTrue(car.move(Board.E, Board.P));
        assertTrue(car.move(Board.E, Board.M));
        assertTrue(car.move(Board.D, Board.M));
    }

    @Test
    void carFailTest() {
        board.boardArray[7][3] = new Horse(7, 3, Board.TEAM_GREEN);
        board.boardArray[7][4] = new Horse(7, 4, Board.TEAM_GREEN);
        assertTrue(car.move(Board.H, Board.K));
        assertFalse(car.move(Board.H, Board.O));
        assertFalse(car.move(Board.H, Board.P));
    }
}