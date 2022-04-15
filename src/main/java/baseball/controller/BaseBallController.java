package baseball.controller;

import static baseball.model.Option.END;
import static baseball.model.Option.RESTART;

import baseball.model.BaseBallGameResult;
import baseball.model.BaseBallMatch;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.RandomNumbersGenerator;
import baseball.model.ScanNumberGenerator;
import baseball.view.BaseBallPrinter;
import baseball.view.BaseBallScanner;

public class BaseBallController {
    public void start() {
        boolean exit = false;
        String option;
        while (!exit) {
            Computer computer = new Computer(new RandomNumbersGenerator());
            playGame(computer);
            BaseBallPrinter.printSuccessMent();
            option = BaseBallScanner.scanOption();
            exit = isEndGame(option);
        }
    }

    private boolean isEndGame(String option) {
        if (RESTART.getOption().equals(option)) {
            return false;
        }
        if (END.getOption().equals(option)) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 옵션 값");

    }

    private void playGame(Computer computer) {
        boolean success = false;
        String message;
        while (!success) {
            BaseBallPrinter.printQuestion();
            message = BaseBallScanner.scanAnswer();
            Player player = new Player(new ScanNumberGenerator(message));
            BaseBallGameResult baseBallGameResult = getResult(computer, player);
            success = judgeResult(baseBallGameResult);
        }
    }

    private boolean judgeResult(BaseBallGameResult baseBallGameResult) {
        BaseBallPrinter.printAnswerBallAndStrike(baseBallGameResult.getBall(), baseBallGameResult.getStrike());
        return baseBallGameResult.isThreeStrike();
    }

    private BaseBallGameResult getResult(Computer computer, Player player) {
        BaseBallMatch match = new BaseBallMatch(computer, player);
        return match.getResult();
    }
}
