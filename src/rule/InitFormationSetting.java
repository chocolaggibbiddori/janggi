package rule;

import board.Board;
import unit.*;

public class InitFormationSetting {

    Board board = Board.getInstance();
    Unit[][] units = board.boardArray;

    @Override
    public String toString() {
        for (int i = 0; i < units.length; i++) {
            Unit[] unit = units[i];
            for (int j = 0; j < unit.length; j++) {
                Unit unit1 = unit[j];
                System.out.println("(" + i + ", " + j + ")" + "=" + unit1);
            }
        }

        return "\n";
    }

    public Unit[][] makeFormation(Formation greenFormation, Formation redFormation) {
        makeCommonFormation();
        makeGreenFormation(greenFormation);
        makeRedFormation(redFormation);

        return units;
    }

    private void makeCommonFormation() {
        units[Board.A][Board.K] = new Car(Board.A, Board.K, Board.TEAM_RED);
        units[Board.A][Board.N] = new Scholar(Board.A, Board.N, Board.TEAM_RED);
        units[Board.A][Board.P] = new Scholar(Board.A, Board.P, Board.TEAM_RED);
        units[Board.A][Board.S] = new Car(Board.A, Board.S, Board.TEAM_RED);
        units[Board.B][Board.O] = new King(Board.B, Board.O, Board.TEAM_RED);
        units[Board.C][Board.L] = new Cannon(Board.C, Board.L, Board.TEAM_RED);
        units[Board.C][Board.R] = new Cannon(Board.C, Board.R, Board.TEAM_RED);
        units[Board.D][Board.K] = new Soldier(Board.D, Board.K, Board.TEAM_RED);
        units[Board.D][Board.M] = new Soldier(Board.D, Board.M, Board.TEAM_RED);
        units[Board.D][Board.O] = new Soldier(Board.D, Board.O, Board.TEAM_RED);
        units[Board.D][Board.Q] = new Soldier(Board.D, Board.Q, Board.TEAM_RED);
        units[Board.D][Board.S] = new Soldier(Board.D, Board.S, Board.TEAM_RED);

        units[Board.J][Board.K] = new Car(Board.J, Board.K, Board.TEAM_GREEN);
        units[Board.J][Board.N] = new Scholar(Board.J, Board.N, Board.TEAM_GREEN);
        units[Board.J][Board.P] = new Scholar(Board.J, Board.P, Board.TEAM_GREEN);
        units[Board.J][Board.S] = new Car(Board.J, Board.S, Board.TEAM_GREEN);
        units[Board.I][Board.O] = new King(Board.I, Board.O, Board.TEAM_GREEN);
        units[Board.H][Board.L] = new Cannon(Board.H, Board.L, Board.TEAM_GREEN);
        units[Board.H][Board.R] = new Cannon(Board.H, Board.R, Board.TEAM_GREEN);
        units[Board.G][Board.K] = new Soldier(Board.G, Board.K, Board.TEAM_GREEN);
        units[Board.G][Board.M] = new Soldier(Board.G, Board.M, Board.TEAM_GREEN);
        units[Board.G][Board.O] = new Soldier(Board.G, Board.O, Board.TEAM_GREEN);
        units[Board.G][Board.Q] = new Soldier(Board.G, Board.Q, Board.TEAM_GREEN);
        units[Board.G][Board.S] = new Soldier(Board.G, Board.S, Board.TEAM_GREEN);
    }

    private void makeGreenFormation(Formation formation) {
        //마상마상, 상마상마, 마상상마, 상마마상
        switch (formation) {
            case FIRST -> makeGreenFirstFormation();
            case SECOND -> makeGreenSecondFormation();
            case THIRD -> makeGreenThirdFormation();
            case FOURTH -> makeGreenFourthFormation();
        }
    }

    private void makeGreenFirstFormation() {
        units[Board.J][Board.L] = new Horse(Board.J, Board.L, Board.TEAM_GREEN);
        units[Board.J][Board.M] = new Elephant(Board.J, Board.M, Board.TEAM_GREEN);
        units[Board.J][Board.Q] = new Horse(Board.J, Board.Q, Board.TEAM_GREEN);
        units[Board.J][Board.R] = new Elephant(Board.J, Board.R, Board.TEAM_GREEN);
    }

    private void makeGreenSecondFormation() {
        units[Board.J][Board.L] = new Elephant(Board.J, Board.L, Board.TEAM_GREEN);
        units[Board.J][Board.M] = new Horse(Board.J, Board.M, Board.TEAM_GREEN);
        units[Board.J][Board.Q] = new Elephant(Board.J, Board.Q, Board.TEAM_GREEN);
        units[Board.J][Board.R] = new Horse(Board.J, Board.R, Board.TEAM_GREEN);
    }

    private void makeGreenThirdFormation() {
        units[Board.J][Board.L] = new Horse(Board.J, Board.L, Board.TEAM_GREEN);
        units[Board.J][Board.M] = new Elephant(Board.J, Board.M, Board.TEAM_GREEN);
        units[Board.J][Board.Q] = new Elephant(Board.J, Board.Q, Board.TEAM_GREEN);
        units[Board.J][Board.R] = new Horse(Board.J, Board.R, Board.TEAM_GREEN);
    }

    private void makeGreenFourthFormation() {
        units[Board.J][Board.L] = new Elephant(Board.J, Board.L, Board.TEAM_GREEN);
        units[Board.J][Board.M] = new Horse(Board.J, Board.M, Board.TEAM_GREEN);
        units[Board.J][Board.Q] = new Horse(Board.J, Board.Q, Board.TEAM_GREEN);
        units[Board.J][Board.R] = new Elephant(Board.J, Board.R, Board.TEAM_GREEN);
    }

    private void makeRedFormation(Formation formation) {
        switch (formation) {
            case FIRST -> makeRedFirstFormation();
            case SECOND -> makeRedSecondFormation();
            case THIRD -> makeRedThirdFormation();
            case FOURTH -> makeRedFourthFormation();
        }
    }

    private void makeRedFirstFormation() {
        units[Board.A][Board.L] = new Elephant(Board.A, Board.L, Board.TEAM_RED);
        units[Board.A][Board.M] = new Horse(Board.A, Board.M, Board.TEAM_RED);
        units[Board.A][Board.Q] = new Elephant(Board.A, Board.Q, Board.TEAM_RED);
        units[Board.A][Board.R] = new Horse(Board.A, Board.R, Board.TEAM_RED);
    }

    private void makeRedSecondFormation() {
        units[Board.A][Board.L] = new Horse(Board.A, Board.L, Board.TEAM_RED);
        units[Board.A][Board.M] = new Elephant(Board.A, Board.M, Board.TEAM_RED);
        units[Board.A][Board.Q] = new Horse(Board.A, Board.Q, Board.TEAM_RED);
        units[Board.A][Board.R] = new Elephant(Board.A, Board.R, Board.TEAM_RED);
    }

    private void makeRedThirdFormation() {
        units[Board.A][Board.L] = new Horse(Board.A, Board.L, Board.TEAM_RED);
        units[Board.A][Board.M] = new Elephant(Board.A, Board.M, Board.TEAM_RED);
        units[Board.A][Board.Q] = new Elephant(Board.A, Board.Q, Board.TEAM_RED);
        units[Board.A][Board.R] = new Horse(Board.A, Board.R, Board.TEAM_RED);
    }

    private void makeRedFourthFormation() {
        units[Board.A][Board.L] = new Elephant(Board.A, Board.L, Board.TEAM_RED);
        units[Board.A][Board.M] = new Horse(Board.A, Board.M, Board.TEAM_RED);
        units[Board.A][Board.Q] = new Horse(Board.A, Board.Q, Board.TEAM_RED);
        units[Board.A][Board.R] = new Elephant(Board.A, Board.R, Board.TEAM_RED);
    }
}
