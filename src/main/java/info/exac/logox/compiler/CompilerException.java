package info.exac.logox.compiler;

public class CompilerException extends Exception {

    private String message;

    public CompilerException(String message, String line, int position) {
        super();
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append(String.format("%s   at position %d", message, position));
        messageBuilder.append("\n\n");
        messageBuilder.append(line);
        messageBuilder.append("\n");
        for (int i = 0; i < position; i++) {
            messageBuilder.append(" ");
        }
        messageBuilder.append("^");

        this.message = messageBuilder.toString();
    }



    @Override
    public String getMessage() {
        return message;
    }

}
