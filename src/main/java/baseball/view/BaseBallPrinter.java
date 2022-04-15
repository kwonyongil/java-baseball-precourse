package baseball.view;

public class BaseBallPrinter {

    private static final String QUESTION = "숫자를 입력해주세요 : ";
    private static final String ANSWER_BALL = "%d볼";
    private static final String ANSWER_STRIKE = "%d스트라이크";
    private static final String ANSWER_BALL_STRIKE = "%d볼 %d스트라이크";
    private static final String ANSWER_NOTHING = "낫싱";
    private static final String CLOSING_MENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MENT = "게임을 새로 시작 하려면 1, 종료하려면 2를 입력하세요.";

    public static void printQuestion() {
        System.out.print(QUESTION);
    }

    public static void printAnswerBallAndStrike(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(ANSWER_NOTHING);
            return;
        }
        if (ball > 0 && strike > 0) {
            System.out.printf((ANSWER_BALL_STRIKE) + "%n", ball, strike);
            return;
        }
        printAnswerBallOrStrike(ball, strike);
    }

    private static void printAnswerBallOrStrike(int ball, int strike) {
        if (strike > 0) {
            System.out.printf((ANSWER_STRIKE) + "%n", strike);
            return;
        }
        System.out.printf((ANSWER_BALL) + "%n", ball);
    }

    public static void printSuccessMent() {
        System.out.println(CLOSING_MENT);
        System.out.println(RESTART_MENT);
    }
}
