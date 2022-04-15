package baseball.model;

import java.util.Map;
import java.util.Objects;

public class BaseBallMatch {
    private final Computer computer;
    private final Player player;

    public BaseBallMatch(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public BaseBallGameResult getResult() {
        int matchCnt = this.getAllMatchResult(computer, player);
        int strike = this.getStrikeResult(computer, player);
        return new BaseBallGameResult(strike, matchCnt - strike);
    }

    private int getAllMatchResult(Computer computer, Player player) {
        Map<Integer, Integer> computerNumbers = computer.getNumbers();
        Map<Integer, Integer> playerNumbers = player.getNumbers();
        int total = 0;
        for (int key : playerNumbers.keySet()) {
            total = countIfContainKey(computerNumbers, total, key);
        }
        return total;
    }

    private int getStrikeResult(Computer computer, Player player) {
        Map<Integer, Integer> computerNumbers = computer.getNumbers();
        Map<Integer, Integer> playerNumbers = player.getNumbers();
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : playerNumbers.entrySet()) {
            total = countIfMatchKeyValue(computerNumbers, total, entry);
        }
        return total;
    }

    private int countIfMatchKeyValue(Map<Integer, Integer> computerNumbers, int total,
                                     Map.Entry<Integer, Integer> entry) {
        if (computerNumbers.containsKey(entry.getKey())) {
            return countIfMatchValue(computerNumbers, total, entry);
        }
        return total;
    }

    private int countIfMatchValue(Map<Integer, Integer> computerNumbers, int total, Map.Entry<Integer, Integer> entry) {
        if (Objects.equals(computerNumbers.get(entry.getKey()), entry.getValue())) {
            return total + 1;
        }
        return total;
    }

    private int countIfContainKey(Map<Integer, Integer> computerNumbers, int total, int key) {
        if (computerNumbers.containsKey(key)) {
            return total + 1;
        }
        return total;
    }
}
