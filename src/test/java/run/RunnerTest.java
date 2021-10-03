package run;

import exception.MathExpressionException;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RunnerTest {

    static Stream<RunnerTest.TestData> testDataProvider() {
        return Stream.of(
                new RunnerTest.TestData("2+2+(2/4+5)", "9.5"),
                new RunnerTest.TestData("3", "3"),
                new RunnerTest.TestData("-1*-2+1", "3.0"),
                new RunnerTest.TestData("2+2*(2-1)", "4.0"),
                new RunnerTest.TestData("-1", "-1"),
                new RunnerTest.TestData("(1)", "1.0")
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void calculate(TestData testData) throws MathExpressionException {
        Assert.assertEquals(testData.outputExpression, Runner.run(testData.inputExpression));
    }

    static class TestData {
        private String inputExpression;
        private String outputExpression;


        public TestData(String inputExpression, String outputExpression) {
            this.inputExpression = inputExpression;
            this.outputExpression = outputExpression;
        }
    }
}