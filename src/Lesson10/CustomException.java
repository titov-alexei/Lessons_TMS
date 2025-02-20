package Lesson10;

public class CustomException extends Exception {
    private int detail;

    CustomException(int detail, String message) {
        super(message);
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "CustomException {\n Число " + detail + ", message: " + getMessage() + "\n}";
    }
}
