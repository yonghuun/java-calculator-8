package calculator.model;

import java.util.regex.Pattern;

public class StringCalculator {

    public int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        // 기본값 설정
        String delimiterRegex = "[,:]";
        String numberText = text;

        // 1. 파싱 로직을 String API로 간결하게
        if (text.startsWith("//")) {
            int delimiterEndIndex = text.indexOf("\\n");

            // 커스텀 구분자 추출
            String customDelimiter = text.substring(2, delimiterEndIndex);
            delimiterRegex = Pattern.quote(customDelimiter);

            // 숫자 부분 추출
            numberText = text.substring(delimiterEndIndex + 2);
        }

        String[] numbers = numberText.split(delimiterRegex);

        // 2. 덧셈 로직을 'sum' 메소드로 통합
        return sum(numbers);
    }

    // 덧셈, 검증 로직 통합 (DRY 원칙)
    private int sum(String[] numbers) {
        int sum = 0;
        for (String numberStr : numbers) {
            // 3. parseToInt 1회 호출로 최적화
            int number = parseToInt(numberStr);

            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += number;
        }
        return sum;
    }

    private int parseToInt(String number) {
        try {
            return Integer.parseInt(number.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 문자열에 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}