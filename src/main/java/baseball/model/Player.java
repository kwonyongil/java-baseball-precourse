package baseball.model;

import java.util.Map;

public class Player {
    private final Map<Integer, Integer> numbers;

    public Player(NumbersGenerator generator) {
        this.numbers = generator.generateNumbers();
    }

    public Map<Integer, Integer> getNumbers() {
        return numbers;
    }
}
