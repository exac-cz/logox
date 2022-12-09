package info.exac.logox.compiler;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompilerTest {

    private Compiler compiler = new Compiler();

    @Test
    public void tokenizeTest() throws CompilerException {
        List<String> result = compiler.tokenize("   forward 10    ");

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("forward", result.get(0));
        assertEquals("10", result.get(1));
    }

}