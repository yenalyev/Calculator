package logic;

import entity.BraketRange;
import entity.Delimiter;
import entity.DelimiterPosition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Bracket {
    public static List<BraketRange> getBracketRange(List<DelimiterPosition> input){
        int countOpen=0;
        int countClose=0;
        Collections.sort(input);
        List<BraketRange> list = new ArrayList<>();
        for (DelimiterPosition delimiterPosition : input) {
            if (delimiterPosition.getDelimiter().equals(Delimiter.BRACKET_OPEN)){
                countOpen++;
                //create range with start point
                BraketRange range = new BraketRange();
                range.setStartRange(delimiterPosition.getPosition());
                list.add(range);
            }
            if (delimiterPosition.getDelimiter().equals(Delimiter.BRACKET_CLOSE)){
                countClose++;
                BraketRange range = list.get(list.size()-countClose);
                range.setEndRange(delimiterPosition.getPosition());
                countOpen--;
                range.setPriority(countOpen);
            }
        }
        return list;
    }
}
