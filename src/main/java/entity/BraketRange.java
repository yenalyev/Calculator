package entity;

public class BraketRange {
    private int startRange;
    public int endRange;
    public int priority;

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
