package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterPositionTest {

    @Test
    void compareTo() {
        DelimiterPosition d1 = new DelimiterPosition(1, Delimiter.BRACKET_OPEN);
        DelimiterPosition d2 = new DelimiterPosition(2, Delimiter.BRACKET_CLOSE);

        System.out.println(d1.compareTo(d2));

    }
}