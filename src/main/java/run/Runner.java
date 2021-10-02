package run;

import entity.DelimiterPosition;
import entity.PriorityRange;
import exception.MathExpressionException;
import logic.CalculationUtils;
import logic.DelimiterUtils;
import logic.PriorityUtils;

import java.util.ArrayList;
import java.util.List;

public class Runner {
public static String runMostPriorityOperation(String input) throws MathExpressionException {
    // get all delimiters
    List<DelimiterPosition> delimiters = DelimiterUtils.findDelimiterList(input);
    //get most priority range for calculation
    List<PriorityRange> priorityRanges = PriorityUtils.getPriorityRanges(delimiters, input.length());
    //get the most priority range
    PriorityRange range = priorityRanges.get(0);
    //get the most priority operation position in range
    DelimiterPosition position = PriorityUtils.getMostPriorityOperationInRange(delimiters,range);
    //calculate the most priority operation in range
    String calculation = CalculationUtils.calculate(position,input);
    return DelimiterUtils.removeUnnecessaryBrackets(calculation);
}

public static String run(String input){
    String result = input;
    List<DelimiterPosition> delimiters = new ArrayList<>();
    do {
        try {
            result = runMostPriorityOperation(result);
        } catch (MathExpressionException e) {
            e.printStackTrace();
        }
        delimiters = DelimiterUtils.findDelimiterList(result);
    } while (!delimiters.isEmpty());

    return result;
}

}
