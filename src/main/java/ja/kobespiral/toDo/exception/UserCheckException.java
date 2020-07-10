package ja.kobespiral.toDo.exception;

public class UserCheckException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public static final int FORM_VALIDATION_FAILED=11;
    public static final int USER_ALREADY_EXISTS=12;
    public static final int NO_SUCH_USER=13;
    private int code;
    public int getCode(){
        return code;
    }

    public UserCheckException(int code, String message) {
        super(message);
        this.code = code;
    }

    public UserCheckException(int code, String message, Exception cause) {
        super(message, cause);
        this.code = code;
    }
}