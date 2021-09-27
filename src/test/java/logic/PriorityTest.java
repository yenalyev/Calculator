package logic;

import entity.Delimiter;
import entity.DelimiterPosition;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriorityTest {

    @Test
    void getPriorityRanges() {
        List<DelimiterPosition> testData = new ArrayList<>();

        testData.add(new DelimiterPosition(0, Delimiter.BRACKET_OPEN));
        testData.add(new DelimiterPosition(1,Delimiter.BRACKET_OPEN));
        testData.add(new DelimiterPosition(7,Delimiter.BRACKET_CLOSE));
        testData.add(new DelimiterPosition(11,Delimiter.BRACKET_CLOSE));
        testData.add(new DelimiterPosition(15,Delimiter.BRACKET_OPEN));
        testData.add(new DelimiterPosition(25,Delimiter.BRACKET_CLOSE));

        System.out.println(testData);
        System.out.println(Priority.getPriorityRanges(testData, 30));
    }
}