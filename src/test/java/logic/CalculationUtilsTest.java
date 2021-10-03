package logic;

import entity.Delimiter;
import entity.DelimiterPosition;
import exception.MathExpressionException;
import org.junit.Assert;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;


@RunWith(Parameterized.class)
class CalculationUtilsTest {

    static Stream<TestData> testDataProvider() {
        return Stream.of(
                new TestData("10+(22.055/5.465464647-155151)", new DelimiterPosition(10, Delimiter.DIVIDE),"10+(4.035338516388724-155151)"),
                new TestData("1-2", new DelimiterPosition(1, Delimiter.MINUS),"-1.0"),
                new TestData("(1-2)", new DelimiterPosition(2, Delimiter.MINUS),"-1.0"),
                new TestData("-1*-2", new DelimiterPosition(2, Delimiter.MULTIPLY),"2.0")
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void calculate(TestData testData) throws MathExpressionException {
        Assert.assertEquals(testData.outputExpression, CalculationUtils.calculate(testData.delimiter, testData.inputExpression));
    }

    static class TestData {
        private String inputExpression;
        private DelimiterPosition delimiter;
        private String outputExpression;


        public TestData(String inputExpression, DelimiterPosition delimiter, String outputExpression) {
            this.inputExpression = inputExpression;
            this.delimiter = delimiter;
            this.outputExpression = outputExpression;
        }
    }
}