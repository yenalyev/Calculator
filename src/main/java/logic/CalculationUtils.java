package logic;

import entity.Delimiter;

import java.util.*;

public class CalculationUtils {
   public static Map<Integer, Delimiter> findDelimiter(String input){
       Map<Integer, Delimiter> map = new HashMap<>();
       char[] charArr = input.toCharArray();
       for (int i = 0; i < charArr.length; i++) {
           switch (charArr[i]){
               case '+': map.put(i, Delimiter.ADD);
               break;
               case '-': map.put(i, Delimiter.MINUS);
               break;
               case '*': map.put(i, Delimiter.MULTIPLY);
               break;
               case ':': map.put(i, Delimiter.DIVIDE);
               break;
               case '=': map.put(i, Delimiter.RESULT);
               break;
               case  '(':
               case '[': map.put(i, Delimiter.BRACKET_OPEN);
               break;
               case  ')':
               case ']': map.put(i, Delimiter.BRACKET_CLOSE);
               break;
               default:
           }
       }
       return map;
   }

    /**
     *
     * @param wholeRange
     * @param start not included
     * @param end not included
     * @return
     */
   public static Map<Integer, Delimiter> getDelimitersInSubRange(Map<Integer, Delimiter> wholeRange, int start, int end){
       List<Integer> keys = new ArrayList(wholeRange.keySet());
       Map<Integer, Delimiter> subRange = new HashMap<>();
       for (int i = 0; i < keys.size(); i++) {
           if (keys.get(i)>start && keys.get(i)<end){
               Integer key = keys.get(i);
               subRange.put(key, wholeRange.get(key));
           }
       }
       return subRange;
   }

   public static Map<Integer, Double> getNumbersFromRange(Map<Integer, Delimiter> rangeDelimiters, int start, int end){
       List<Integer> keys = new ArrayList<>(rangeDelimiters.keySet());
       Collections.sort(keys);
       for (int i = start; i <= end; i++) {

       }
       return null;
   }



}
