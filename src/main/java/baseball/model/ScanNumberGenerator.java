package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class ScanNumberGenerator implements NumbersGenerator {
    private static final int NUMBER_SIZE = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private final Map<Integer, Integer> numbers = new HashMap<>();
    private String text;

    public ScanNumberGenerator(String text) {
        checkText(text);
        this.text = text;
    }

    @Override
    public Map<Integer, Integer> generateNumbers() {
        int key;
        String scanNum;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            scanNum = text.substring(i, i + 1);
            key = stringToInt(scanNum);
            numbers.put(key, i);
        }
        return numbers;
    }

    private void checkText(String text) {
        checkLength(text);
        String uniqueText = "";
        for (char c : text.toCharArray()) {
            checkRange(c);
            uniqueText += getOnlyUniqueChar(uniqueText, c);
        }
        checkLength(uniqueText);
    }

    private void checkLength(String text) {
        if (text == null || text.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 인자 혹은 잘못된 길이입니다.");
        }
    }

    private void checkRange(char c) {
        if (START_NUMBER + 48 > c || END_NUMBER + 48 < c) {
            throw new IllegalArgumentException("1부터 9까지 올 수 있습니다.");
        }
    }

    private String getOnlyUniqueChar(String uniqueText, char c) {
        if (!uniqueText.contains(String.valueOf(c))) {
            return String.valueOf(c);
        }
        return "";
    }

    private int stringToInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 인자값입니다.");
        }
    }
}
