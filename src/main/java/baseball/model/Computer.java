package baseball.model;

import java.util.Map;

public class Computer {

    private final Map<Integer, Integer> numbers;

    public Computer(NumbersGenerator generator) {
        this.numbers = generator.generateNumbers();
    }

    public Map<Integer, Integer> getNumbers() {
        return numbers;
    }

    // TODO : 1, 2 Enum 처리
    public boolean isEndGame(String option) {
        if ("1".equals(option)) {
            return false;
        }
        if ("2".equals(option)) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 옵션 값");
    }
}
