package run;

import exception.MathExpressionException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class RunnerTest {

    @Test
    void runMostPriorityOperationTest() throws MathExpressionException {
        String input = "2+2+(2/4+5)";
        String result = Runner.runMostPriorityOperation(input);
        Assert.assertEquals(result,"2+2+(0.5+5)");
    }

    @Test
    void runTest(){
        String input = "2+2+(2/4+5)";
        String result = Runner.run(input);
        Assert.assertEquals(result,"9.05");
    }

    @Test
    void runTest2(){
        String input = "1";
        String result = Runner.run(input);
        Assert.assertEquals(result,"1");
    }
}