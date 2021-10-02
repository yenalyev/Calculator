package logic;

import entity.Delimiter;
import entity.DelimiterPosition;
import entity.PriorityRange;

import java.util.ArrayList;
import java.util.List;

public class DelimiterUtils {

    public static List<DelimiterPosition> findDelimiterList(String input){
        List<DelimiterPosition> list = new ArrayList<>();
        char[] charArr = input.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            switch (charArr[i]){
                case '+': list.add(new DelimiterPosition(i, Delimiter.PLUS));
                    break;
                case '-': list.add(new DelimiterPosition(i, Delimiter.MINUS));
                    break;
                case '*': list.add(new DelimiterPosition(i, Delimiter.MULTIPLY));
                    break;
                case '/':
                case ':': list.add(new DelimiterPosition(i, Delimiter.DIVIDE));
                    break;
                case '=': list.add(new DelimiterPosition(i, Delimiter.RESULT));
                    break;
                case  '(':
                case '[': list.add(new DelimiterPosition(i, Delimiter.BRACKET_OPEN));
                    break;
                case  ')':
                case ']': list.add(new DelimiterPosition(i, Delimiter.BRACKET_CLOSE));
                    break;
                default:
            }
        }
        return list;
    }

    /**
     *
     * @param list
     * @param range
     * @return
     */
    public static List<DelimiterPosition> getSublist(List<DelimiterPosition> list, PriorityRange range){
        List<DelimiterPosition> sublist = new ArrayList<>();
        for (DelimiterPosition d: list){
            if (d.getPosition()>=range.getStartRange() && d.getPosition()<= range.getEndRange()){
                sublist.add(d);
            }
        }
        return sublist;
    }

    public static String removeUnnecessaryBrackets(String input){
        // get all delimiters
        List<DelimiterPosition> delimiters = getUnnecessaryBrackets(input);
        if (!delimiters.isEmpty()){
            return input.substring(0,delimiters.get(0).getPosition())
                    + input.substring(delimiters.get(0).getPosition()+1, delimiters.get(1).getPosition())
                    + input.substring(delimiters.get(1).getPosition()+1, input.length());

        }
        return input;
    }

    public static List<DelimiterPosition> getUnnecessaryBrackets(String input){
        // get all delimiters
        List<DelimiterPosition> delimiters = DelimiterUtils.findDelimiterList(input);
        DelimiterPosition openBracket = null;
        DelimiterPosition closeBracket;
        List<DelimiterPosition> unnecessaryBrackets = new ArrayList<>();

        for (DelimiterPosition d: delimiters){
            if (d.getDelimiter().equals(Delimiter.BRACKET_OPEN)){
                openBracket = d;
            } else if (d.getDelimiter().equals(Delimiter.BRACKET_CLOSE) && openBracket!=null){
                closeBracket = d;
                unnecessaryBrackets.add(openBracket);
                unnecessaryBrackets.add(closeBracket);
            } else {
                openBracket = null;
            }
        }
        return unnecessaryBrackets;
    }
}
