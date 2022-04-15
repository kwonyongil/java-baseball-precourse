package baseball.model;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumbersGenerator implements NumbersGenerator {
    private static final int NUMBER_SIZE = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private Map<Integer, Integer> numbers = new HashMap<>();

    @Override
    public Map<Integer, Integer> generateNumbers() {
        while (numbers.size() < NUMBER_SIZE) {
            int number = pickNumberInRange(START_NUMBER, END_NUMBER);
            numbers.putIfAbsent(number, numbers.size());
        }
        return numbers;
    }
}
