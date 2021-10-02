package logic;

import entity.PriorityRange;
import entity.Delimiter;
import entity.DelimiterPosition;

import java.util.*;

public class PriorityUtils {
    public static List<PriorityRange> getPriorityRanges(List<DelimiterPosition> input, int expressionLength){
        List<PriorityRange> bracketRanges = getBracketRange(input);
        Collections.sort(bracketRanges);
        List<PriorityRange> list = new ArrayList<>();
        List<PriorityRange> allRanges = new ArrayList<>();
        PriorityRange initRange = new PriorityRange(0, expressionLength-1, 0);
        int count = 0;
        list.add(initRange);
        for (PriorityRange r:bracketRanges) {
            if (r.getPriority()==1){
                PriorityRange temp = list.get(count);
                temp.setPriority(0);
                temp.setEndRange(r.getStartRange()-1);
                list.add(new PriorityRange(r.getEndRange()+1, expressionLength-1,0));
                count++;
            }
        }
        for (PriorityRange r: list) {
            if (r.getEndRange()> r.getStartRange()){
                allRanges.add(r);
            }
        }
        allRanges.addAll(bracketRanges);
        Collections.sort(allRanges);

        if (allRanges.isEmpty()){
            allRanges.add(new PriorityRange(0,expressionLength,0));
        }
        return allRanges;
    }

    public static List<PriorityRange> getBracketRange(List<DelimiterPosition> input){
        int countOpen=0;
        Collections.sort(input);
        List<PriorityRange> temp = new ArrayList<>();
        List<PriorityRange> ranges = new ArrayList<>();
        for (DelimiterPosition delimiterPosition : input) {
            if (delimiterPosition.getDelimiter().equals(Delimiter.BRACKET_OPEN)){
                countOpen++;
                //create range with start point
                PriorityRange range = new PriorityRange();
                range.setStartRange(delimiterPosition.getPosition());
                temp.add(range);
            }
            if (delimiterPosition.getDelimiter().equals(Delimiter.BRACKET_CLOSE)){
                //countClose++;
                PriorityRange range = temp.get(temp.size()-1);
                range.setEndRange(delimiterPosition.getPosition());
                ranges.add(range);
                temp.remove(range);
                range.setPriority(countOpen);
                countOpen--;
            }
        }
        Collections.sort(ranges);
        return ranges;
    }

    public static DelimiterPosition getMostPriorityOperationInRange(List<DelimiterPosition> delimiters, PriorityRange range){
        List<DelimiterPosition> suitableDelimiters = DelimiterUtils.getSublist(delimiters,range);
        DelimiterPosition delimiter = null;
        if (!suitableDelimiters.isEmpty()){
            for (DelimiterPosition d: suitableDelimiters){
                if (delimiter==null || Delimiter.getDelimiterPriority(d.getDelimiter()) > Delimiter.getDelimiterPriority(delimiter.getDelimiter())){
                    delimiter = d;
                }
            }
        }
        return delimiter;
    }
}
