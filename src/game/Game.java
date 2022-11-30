package game;

import board.Board;
import rule.Formation;
import rule.InitFormationSetting;
import rule.Score;
import unit.Unit;

import java.util.Scanner;

public class Game {

    Unit[][] board = Board.getInstance().boardArray;
    int greenScore = Score.GREEN_TEAM_SCORE;
    double redScore = Score.RED_TEAM_SCORE;

    public void start() {
        InitFormationSetting setting = new InitFormationSetting();
        View view = new View();
        Scanner sc = new Scanner(System.in);
        Formation[] formationArray = {Formation.FIRST, Formation.SECOND, Formation.THIRD, Formation.FOURTH};

        int greenFormationNumber = getGreenFormationNumber(sc);
        int redFormationNumber = getRedFormationNumber(sc);

        setting.makeFormation(formationArray[greenFormationNumber - 1], formationArray[redFormationNumber - 1]);
        view.drawScore(greenScore, redScore);
        view.drawBoard(board);
    }

    private int getGreenFormationNumber(Scanner sc) {
        System.out.println("초나라의 포진을 선택하십시오.");
        System.out.println("1. 마상마상\n2. 상마상마\n3. 마상상마\n4. 상마마상");
        return sc.nextInt();
    }

    private int getRedFormationNumber(Scanner sc) {
        System.out.println("한나라의 포진을 선택하십시오.");
        System.out.println("1. 마상마상\n2. 상마상마\n3. 마상상마\n4. 상마마상");
        return sc.nextInt();
    }
}
