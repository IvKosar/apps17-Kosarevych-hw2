package skipass.verification.Exceptions;

public class TooLateTooRideException extends RuntimeException {
    public TooLateTooRideException(){super("Riding in this hour is not permitted!");}
}
