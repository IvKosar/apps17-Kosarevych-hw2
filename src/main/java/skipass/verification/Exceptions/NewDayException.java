package skipass.verification.Exceptions;

public class NewDayException extends RuntimeException {
    public NewDayException(){super();}
    public NewDayException(String message){super("It's a new day!");}
}
