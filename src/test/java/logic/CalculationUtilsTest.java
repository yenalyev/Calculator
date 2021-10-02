package logic;

import entity.Delimiter;
import entity.DelimiterPosition;
import exception.MathExpressionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationUtilsTest {

    @Test
    void calculate() throws MathExpressionException {
        String input = "10+(22.055/5.465464647-155151)";
        DelimiterPosition delimiterPosition = new DelimiterPosition(10, Delimiter.DIVIDE);
        System.out.println(CalculationUtils.calculate(delimiterPosition,input));
    }

    @Test
    void calculateMinus() throws MathExpressionException {
        String input = "1-2";
        DelimiterPosition delimiterPosition = new DelimiterPosition(1, Delimiter.MINUS);
        System.out.println(CalculationUtils.calculate(delimiterPosition,input));
    }
}