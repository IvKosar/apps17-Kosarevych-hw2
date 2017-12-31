package skipass.verification;

import skipass.verification.Exceptions.NewDayException;
import skipass.verification.Exceptions.NoRidesLeftException;
import skipass.verification.Exceptions.TooLateTooRideException;

import java.util.Date;

public class Verificator {
    public static boolean areRidesLeft(int numberOfRides){
        if (numberOfRides <= 0) {
            throw new NoRidesLeftException();
        }
        return true;
    }

    public static boolean isSameDay(Date date){
        Date currentDate = new Date();
        if (currentDate.getDate() != date.getDate() || currentDate.getMonth() != date.getMonth() ||
                currentDate.getYear() != date.getYear()){
            throw new NewDayException();
        }
        return true;
    }

    public static boolean isHourValid(int hourBound){
        Date date = new Date();
        if (date.getHours() >= hourBound && date.getMinutes() > 0 && date.getSeconds() > 0){
            throw new TooLateTooRideException();
        }
        return true;
    }
}
