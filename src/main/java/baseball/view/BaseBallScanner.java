package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallScanner {
    public static String scanAnswer() {
        String answer = readLine();
        if (answer.length() != 3) {
            throw new IllegalArgumentException("잘못된 답변 길이");
        }
        return answer;
    }

    public static String scanOption() {
        String option = readLine();
        if (option.length() != 1) {
            throw new IllegalArgumentException("잘못된 옵션 길이");
        }
        return option;
    }
}
