package info.exac.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentTest {

    @Test
    void oneLineOnly() {
        Argument.oneLineOnly("forward 10");

        Throwable e = null;

        e = assertThrows(IllegalArgumentException.class, () -> {
            Argument.oneLineOnly(null);
        });
        assertEquals(Argument.NOT_NULL_OR_EMPTY, e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> {
            Argument.oneLineOnly("");
        });
        assertEquals(Argument.NOT_NULL_OR_EMPTY, e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> {
            Argument.oneLineOnly("forward 10\nforward 10");
        });
        assertEquals(Argument.ONE_LINE_ONLY, e.getMessage());
    }


}