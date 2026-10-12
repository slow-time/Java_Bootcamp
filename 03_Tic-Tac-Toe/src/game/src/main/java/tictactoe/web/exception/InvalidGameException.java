package tictactoe.web.exception;

public class InvalidGameException extends RuntimeException {
    public InvalidGameException(String message) {
        super(message);
    }
}