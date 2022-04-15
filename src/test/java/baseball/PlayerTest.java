package baseball;

import baseball.model.Player;
import baseball.model.ScanNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {
    @DisplayName("플레이어가 입력받은 볼 숫자 유효성 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "23", "dtd", "113", "302"})
    void PlayerRandomInitRangeTest(String text) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(new ScanNumberGenerator(text)));
    }
}
