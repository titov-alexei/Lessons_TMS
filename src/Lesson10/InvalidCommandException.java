package Lesson10;

public class InvalidCommandException extends RuntimeException {

    InvalidCommandException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "InvalidCommandException: Неправильная комманда " + getMessage() + "\nВведите ADD, REMOVE или EXIT";
    }
}
