package baseball.controller;

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
            exit = computer.isEndGame(option);
        }
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
