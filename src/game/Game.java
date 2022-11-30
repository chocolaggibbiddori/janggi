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
    Scanner sc = new Scanner(System.in);

    public static int greenScore = Score.GREEN_TEAM_SCORE;
    public static double redScore = Score.RED_TEAM_SCORE;
    public static boolean gameOver = false;
    private final boolean isGreen = true;

    public void start() {
        InitFormationSetting setting = new InitFormationSetting();
        View view = new View();
        Formation[] formationArray = {Formation.FIRST, Formation.SECOND, Formation.THIRD, Formation.FOURTH};
        initPointMap();

        int greenFormationNumber = getGreenFormationNumber();
        int redFormationNumber = getRedFormationNumber();

        setting.makeFormation(formationArray[greenFormationNumber - 1], formationArray[redFormationNumber - 1]);

        while (!gameOver) {
            view.drawScore(greenScore, redScore);
            view.drawBoard(board);

            turn(isGreen);
            if (gameOver) {
                break;
            }
            view.drawScore(greenScore, redScore);
            view.drawBoard(board);

            turn(!isGreen);
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
                i = -1;
            } else if (start == 't') {
                break;
            }
        }
    }

    private int getGreenFormationNumber() {
        System.out.println("초나라의 포진을 선택하십시오.");
        System.out.println("1. 마상마상\n2. 상마상마\n3. 마상상마\n4. 상마마상");
        return sc.nextInt();
    }

    private int getRedFormationNumber() {
        System.out.println("한나라의 포진을 선택하십시오.");
        System.out.println("1. 마상마상\n2. 상마상마\n3. 마상상마\n4. 상마마상");
        return sc.nextInt();
    }

    private void turn(boolean isGreen) {
        if (isGreen) {
            System.out.println("차례: 초나라");
        } else {
            System.out.println("차례: 한나라");
        }
        System.out.print("말을 선택하십시오: ");
        Unit unit = selectUnit(isGreen);
        moveUnit(unit);
    }

    private Unit selectUnit(boolean isGreen) {
        String selectPoint;
        Unit unit;
        int unitX, unitY;

        do {
            selectPoint = selectPoint();
            unitX = pointMap.get(selectPoint.charAt(0));
            unitY = pointMap.get(selectPoint.charAt(1));
            unit = board[unitX][unitY];
        } while (!isOurTeam(unit, isGreen));

        System.out.println("선택된 유닛: " + unit);
        return unit;
    }

    private String selectPoint() {
        String point;
        sc = new Scanner(System.in);
        do {
            point = sc.nextLine().trim().toLowerCase();
        } while (!rule.isRightInput(point));

        return point;
    }

    private boolean isOurTeam(Unit unit, boolean isGreen) {
        return isGreen
                ? unit.getTeamName().equals(Board.TEAM_GREEN)
                : unit.getTeamName().equals(Board.TEAM_RED);
    }

    private void moveUnit(Unit unit) {
        int moveToX;
        int moveToY;

        do {
            System.out.print("이동할 지점을 선택하십시오: ");
            String selectPoint = selectPoint();
            moveToX = pointMap.get(selectPoint.charAt(0));
            moveToY = pointMap.get(selectPoint.charAt(1));
        } while (!unit.move(moveToX, moveToY));
    }
}
