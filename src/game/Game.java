package game;

import board.Board;
import rule.Formation;
import rule.InitFormationSetting;
import rule.Rule;
import rule.Score;
import unit.Unit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

    Unit[][] board = Board.getInstance().boardArray;
    Rule rule = new Rule();
    Map<Character, Integer> pointMap = new HashMap<>();

    public static int greenScore = Score.GREEN_TEAM_SCORE;
    public static double redScore = Score.RED_TEAM_SCORE;
    public static boolean gameOver = false;

    public void start() {
        InitFormationSetting setting = new InitFormationSetting();
        View view = new View();
        Scanner sc = new Scanner(System.in);
        Formation[] formationArray = {Formation.FIRST, Formation.SECOND, Formation.THIRD, Formation.FOURTH};
        initPointMap();

        int greenFormationNumber = getGreenFormationNumber(sc);
        int redFormationNumber = getRedFormationNumber(sc);

        setting.makeFormation(formationArray[greenFormationNumber - 1], formationArray[redFormationNumber - 1]);

        while (!gameOver) {
            view.drawScore(greenScore, redScore);
            view.drawBoard(board);

            greenTurn(sc);
            if (gameOver) {
                break;
            }

            redTurn(sc);
        }
        view.drawScore(greenScore, redScore);
        view.drawBoard(board);

        System.out.println("게임 종료");
    }

    private void initPointMap() {
        char start = 'a';
        for (int i = 0; i < 10; i++) {
            pointMap.put(start, i);

            start++;
            if (start == 'k') {
                i = 0;
            } else if (start == 't') {
                break;
            }
        }
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

    private void greenTurn(Scanner sc) {
        System.out.println("차례: 초나라");
        System.out.print("말을 선택하십시오: ");
        Unit unit = selectUnit(sc);

        System.out.print("이동할 지점을 선택하십시오: ");
        moveUnit(sc, unit);
    }

    private Unit selectUnit(Scanner sc) {
        String selectPoint = selectPoint(sc);
        int unitX = pointMap.get(selectPoint.charAt(0));
        int unitY = pointMap.get(selectPoint.charAt(1));

        return board[unitX][unitY];
    }

    private String selectPoint(Scanner sc) {
        String selectPoint;
        do {
            selectPoint = sc.nextLine().trim().toLowerCase();
        } while (!rule.isRightInput(selectPoint));

        return selectPoint;
    }

    private void moveUnit(Scanner sc, Unit unit) {
        int moveToX;
        int moveToY;

        do {
            String selectPoint = selectPoint(sc);
            moveToX = pointMap.get(selectPoint.charAt(0));
            moveToY = pointMap.get(selectPoint.charAt(1));
        } while (!unit.move(moveToX, moveToY));
    }

    private void redTurn(Scanner sc) {
        System.out.println("차례: 한나라");
        System.out.print("말을 선택하십시오: ");
        Unit unit = selectUnit(sc);

        System.out.print("이동할 지점을 선택하십시오: ");
        moveUnit(sc, unit);
    }
}
