package entity;

public class PriorityRange implements Comparable<PriorityRange>{
    private int startRange;
    public int endRange;
    public int priority;

    public PriorityRange(){};

    public PriorityRange(int startRange, int endRange, int priority) {
        this.startRange = startRange;
        this.endRange = endRange;
        this.priority = priority;
    }

    @Override
    public int compareTo(PriorityRange o) {
        if (this.getPriority()>o.getPriority()){
            return -1;
        } else if (this.getPriority()<o.getPriority()){
            return 1;
        } else {
            if (this.getStartRange()>o.getStartRange()){
                return 1;
            } else if (this.getStartRange()<o.getStartRange()){
                return -1;
            } else {return 0;}
        }
    }

    @Override
    public String toString() {
        return "BraketRange{" +
                "startRange=" + startRange +
                ", endRange=" + endRange +
                ", priority=" + priority +
                '}';
    }

    public int getStartRange() {
        return startRange;
    }

    public void setStartRange(int startRange) {
        this.startRange = startRange;
    }

    public int getEndRange() {
        return endRange;
    }

    public void setEndRange(int endRange) {
        this.endRange = endRange;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
