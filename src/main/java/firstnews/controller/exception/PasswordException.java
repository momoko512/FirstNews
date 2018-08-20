package firstnews.controller.exception;

public class PasswordException extends Exception {
    private String message;

    public PasswordException() {
        super();
    }

    public PasswordException(String message) {
        super(message);
        this.message=message;
    }

    public PasswordException(String message, Throwable throwable) {
        super(message, throwable);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
