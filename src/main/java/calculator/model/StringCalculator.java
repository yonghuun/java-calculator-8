package calculator.model;

public class StringCalculator {

    public int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        // 기본값 설정
        String delimiterRegex = "[,:]";
        String numberText = text;

        String[] numbers = numberText.split(delimiterRegex);

        // 덧셈 로직을 'sum' 메소드로
        return sum(numbers);
    }

    // 덧셈, 검증 로직
    private int sum(String[] numbers) {
        int sum = 0;
        for (String numberStr : numbers) {
            
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