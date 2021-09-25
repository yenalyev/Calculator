package entity;

public class DelimiterPosition implements Comparable<DelimiterPosition> {
    private int position;
    private Delimiter delimiter;

    public DelimiterPosition() {
    }

    public DelimiterPosition(int position, Delimiter delimiter) {
        this.position = position;
        this.delimiter = delimiter;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Delimiter getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String toString() {
        return "DelimiterPosition{" +
                "position=" + position +
                ", delimiter=" + delimiter +
                '}';
    }

    @Override
    public int compareTo(DelimiterPosition o) {
        if (this.getPosition()>o.getPosition()){
            return 1;
        } else if (this.getPosition()<o.getPosition()){
            return -1;
        } else return 0;
    }
}
