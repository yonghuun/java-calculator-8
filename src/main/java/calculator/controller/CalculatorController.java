package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    StringCalculator stringCalculator = new StringCalculator();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        String text = inputView.getInput();
        int result = stringCalculator.calculate(text);
        outputView.printResult(result);

    }
}
