package felixgu.start.exception;

public class MyException extends Exception{

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(String value, String message) {

    }

    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MyException(int value, String message) {
    }
}
