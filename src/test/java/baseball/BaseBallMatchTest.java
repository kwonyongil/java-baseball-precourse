package baseball;

import baseball.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallMatchTest {
    @DisplayName("BaseBall 매치 볼 카운트 체크")
    @ParameterizedTest
    @CsvSource(value = {"123:0", "468:0", "213:2", "256:1"}, delimiter = ':')
    void BaseBallMatchBallCountTest(String text, int count) {
        Computer computer = new Computer(new ScanNumberGenerator("123"));
        Player player = new Player(new ScanNumberGenerator(text));
        BaseBallMatch match = new BaseBallMatch(computer, player);
        BaseBallGameResult baseBallGameResult = match.getResult();
        assertThat(baseBallGameResult.getBall()).isEqualTo(count);
    }

    @DisplayName("BaseBall 매치 스트라이크 카운트 체크")
    @ParameterizedTest
    @CsvSource(value = {"123:3", "468:0", "124:2", "321:1"}, delimiter = ':')
    void BaseBallMatchStrikeCountTest(String text, int count) {
        Computer computer = new Computer(new ScanNumberGenerator("123"));
        Player player = new Player(new ScanNumberGenerator(text));
        BaseBallMatch match = new BaseBallMatch(computer, player);
        BaseBallGameResult baseBallGameResult = match.getResult();
        assertThat(baseBallGameResult.getStrike()).isEqualTo(count);
    }
}
