package logic;

import entity.Delimiter;
import entity.DelimiterPosition;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterUtilsTest {

    @Test
    void getUnnecessaryBracketsTest() {
        List<DelimiterPosition> unnecessaryBrackets = DelimiterUtils.getUnnecessaryBrackets("(10)+(15-2)*15");
        List<DelimiterPosition> expected =
                Arrays.asList(new DelimiterPosition(0, Delimiter.BRACKET_OPEN), new DelimiterPosition(3, Delimiter.BRACKET_CLOSE));
        Assert.assertEquals(unnecessaryBrackets,expected);
    }

    @Test
    void getUnnecessaryBracketsEmptyTest() {
        List<DelimiterPosition> unnecessaryBrackets = DelimiterUtils.getUnnecessaryBrackets("(10-2)+(15-2)*15");
        Assert.assertTrue(unnecessaryBrackets.isEmpty());
    }

    @Test
    void removeUnnecessaryBracketsTest(){
        String actual = DelimiterUtils.removeUnnecessaryBrackets("(15)+20");
        Assert.assertEquals(actual, "15+20");
    }
}