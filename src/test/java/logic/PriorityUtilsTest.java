package logic;

import entity.Delimiter;
import entity.DelimiterPosition;
import entity.PriorityRange;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PriorityUtilsTest {

    @Test
    void getPriorityRangesTest() {
        List<DelimiterPosition> testData = new ArrayList<>();

        testData.add(new DelimiterPosition(0, Delimiter.BRACKET_OPEN));
        testData.add(new DelimiterPosition(1,Delimiter.BRACKET_OPEN));
        testData.add(new DelimiterPosition(7,Delimiter.BRACKET_CLOSE));
        testData.add(new DelimiterPosition(11,Delimiter.BRACKET_CLOSE));
        testData.add(new DelimiterPosition(15,Delimiter.BRACKET_OPEN));
        testData.add(new DelimiterPosition(25,Delimiter.BRACKET_CLOSE));

        System.out.println(testData);
        System.out.println(PriorityUtils.getPriorityRanges(testData, 30));
    }


    @Test
    void getMostPriorityOperationInRangeTest(){
        List<DelimiterPosition> testData = new ArrayList<>();
        testData.add(new DelimiterPosition(1,Delimiter.PLUS));
        testData.add(new DelimiterPosition(7,Delimiter.DIVIDE));
        testData.add(new DelimiterPosition(9,Delimiter.MULTIPLY));
        PriorityRange range = new PriorityRange(1,10,1);
        Assert.assertEquals(new DelimiterPosition(7,Delimiter.DIVIDE), PriorityUtils.getMostPriorityOperationInRange(testData, range));
    }

    @Test
    void getPriorityRangesWithoutOperation() {
        List<DelimiterPosition> testData = new ArrayList<>();

        testData.add(new DelimiterPosition(0, Delimiter.BRACKET_OPEN));
        testData.add(new DelimiterPosition(2,Delimiter.BRACKET_CLOSE));

        System.out.println(testData);
        System.out.println(PriorityUtils.getPriorityRanges(testData, 2));
    }
}