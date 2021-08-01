package customExceptions;

public class WrongInputCustomException extends  RuntimeException{
    public WrongInputCustomException(String message) {
        super(message);
    }
}
