package entity;

public enum Delimiter {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    RESULT,
    BRACKET_OPEN,
    BRACKET_CLOSE;

    public static int getDelimiterPriority(Delimiter delimiter){
        switch (delimiter){
            case PLUS:
            case MINUS: return 1;
            case MULTIPLY:
            case DIVIDE: return 2;
            default: return 0;
        }

    }
}
