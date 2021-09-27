package utilities;

import entity.PriorityRange;

import java.util.List;

public class CalculatorUtilities {
    public static PriorityRange getMaxPriorityRange (List<PriorityRange> list){
        PriorityRange temp = new PriorityRange(0,0,-1);
        for (PriorityRange p: list) {
            if (p.getPriority()>temp.getPriority()){
                temp.setStartRange(p.getStartRange());
                temp.setEndRange(p.getEndRange());
                temp.setPriority(p.getPriority());
            }
        }
        return temp;
    }
}
