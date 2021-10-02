package logic;

import entity.Delimiter;
import entity.DelimiterPosition;
import exception.MathExpressionException;

import java.util.*;

public class CalculationUtils {

   public static String calculate(DelimiterPosition delimiterPosition, String input) throws MathExpressionException {

        if (delimiterPosition==null){
            return input;
        }
       System.out.println(delimiterPosition);
       int delimiterPoint = delimiterPosition.getPosition();

       char start = input.charAt(delimiterPoint-1);
       char end = input.charAt(delimiterPoint+1);
       int startPoint = delimiterPoint;
       int endPoint = delimiterPoint;
       while((start>='0' && start <= '9') || start=='.'){
           start = input.charAt(--startPoint);
           if ((start>='0' && start <= '9') || start=='.'){}
           else {startPoint++;}
           if (startPoint==0){
               break;
           }
       }
       while((end>='0' && end <= '9') || end=='.'){
           end = input.charAt(++endPoint);

           if (endPoint==input.length()-1 && (end>='0' && end <= '9')){
               endPoint=input.length();
               break;
           }
       }
       Double firstNumber = Double.parseDouble(input.substring(startPoint,delimiterPoint));
       Double secondNumber = Double.parseDouble(input.substring(delimiterPoint+1, endPoint));
       Double operationResult;

       char delimiter = input.charAt(delimiterPoint);
       if (delimiter =='+'){
           operationResult = firstNumber + secondNumber;
       } else if (delimiter == '-'){
           operationResult = firstNumber - secondNumber;
       } else if (delimiter == '*'){
           operationResult = firstNumber * secondNumber;
       } else if (delimiter == ':' || delimiter == '/'){
           operationResult = firstNumber / secondNumber;
       } else {
           throw new MathExpressionException("Unsupported operation exception");
       }

       return input.substring(0,startPoint) + operationResult + input.substring(endPoint);
   }



}
