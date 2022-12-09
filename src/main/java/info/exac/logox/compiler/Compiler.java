package info.exac.logox.compiler;

import info.exac.utils.Argument;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Compiler {

    public enum TokenizerMode {
        BEGINNING_OF_LINE,
        WHITESPACE_SEQUENCE,
        WORD,
        NUMBER,
    }


    public Command compile(String command) throws CompilerException {
        List<String> tokens = tokenize(command);
        return null;
    }

    public List<String> tokenize(String line) throws CompilerException {
        Argument.oneLineOnly(line);

        List<String> result = new ArrayList<>();
        TokenizerMode mode = TokenizerMode.BEGINNING_OF_LINE;
        StringBuilder currentToken = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {

            char c = line.charAt(i);

            if (Character.isWhitespace(c)) {
                if (mode == TokenizerMode.BEGINNING_OF_LINE) {
                    continue;
                }
                else if (mode == TokenizerMode.WHITESPACE_SEQUENCE) {
                    continue;
                }
                else {
                    result.add(currentToken.toString());
                    currentToken.setLength(0);
                    mode = TokenizerMode.WHITESPACE_SEQUENCE;
                }
            }
            else if (Character.isAlphabetic(c)) {
                if (mode == TokenizerMode.BEGINNING_OF_LINE || mode == TokenizerMode.WHITESPACE_SEQUENCE) {
                    mode = TokenizerMode.WORD;
                    currentToken.append(c);
                }
                else if (mode == TokenizerMode.WORD) {
                    currentToken.append(c);
                }
                else {
                    throw new CompilerException("Unexpected character!", line ,i);
                }
            } else if (Character.isDigit(c)) {
                if (mode == TokenizerMode.BEGINNING_OF_LINE || mode == TokenizerMode.WHITESPACE_SEQUENCE) {
                    mode = TokenizerMode.NUMBER;
                    currentToken.append(c);
                }
                else if (mode == TokenizerMode.NUMBER) {
                    currentToken.append(c);
                }
            } else {
                throw new CompilerException("Unknown character!", line, i);
            }

        }

        if (currentToken.length() > 0) {
            result.add(currentToken.toString());
            currentToken.setLength(0);
        }

        return result;
    }

}
