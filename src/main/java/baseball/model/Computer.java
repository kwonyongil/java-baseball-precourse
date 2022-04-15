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
}
