package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // Scanner.next() 대신 Console.readLine() 사용
        return input;
    }

}