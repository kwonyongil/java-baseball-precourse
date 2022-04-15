package baseball;

import baseball.model.Computer;
import baseball.model.RandomNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("컴퓨터가 초기화한 볼 숫자의 자리수가 3개인지 확인")
    void ComputerRandomInitSizeTest() {
        Computer computer = new Computer(new RandomNumbersGenerator());
        Map<Integer, Integer> numbers = computer.getNumbers();
        assertThat(numbers.size()).isEqualTo(3);
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("컴퓨터가 초기화한 볼 숫자가 1 ~ 9 인지 확인")
    void ComputerRandomInitRangeTest() {
        Computer computer = new Computer(new RandomNumbersGenerator());
        Map<Integer, Integer> numbers = computer.getNumbers();
        for (Integer key : numbers.keySet()) {
            assertThat(key > 0 && key < 10).isTrue();
        }
    }
}
