package info.exac.utils;

import org.springframework.util.Assert;

public class Argument {


    public static final String NOT_NULL_OR_EMPTY = "Argument must not be null or empty!";
    public static final String ONE_LINE_ONLY = "Argument must contain one line only!";


    private Argument() { }


    public static void notEmpty(String argumentValue) {
        notEmpty(argumentValue, NOT_NULL_OR_EMPTY);
    }

    public static void notEmpty(String argumentValue, String message) {
        if (argumentValue == null || argumentValue.length() == 0) {
            throw new IllegalArgumentException(message);
        }
    }


    public static void oneLineOnly(String argumentValue) {
        oneLineOnly(argumentValue, ONE_LINE_ONLY);
    }

    public static void oneLineOnly(String argumentValue, String message) {
        notEmpty(argumentValue);

       if (argumentValue.contains("\n")) {
           throw new IllegalArgumentException(message);
       }
    }

}
