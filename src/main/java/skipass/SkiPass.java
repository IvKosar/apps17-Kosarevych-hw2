package skipass;

import skiPassTypeEnums.ISkiPassType;
import skipass.verification.Exceptions.TooLateTooRideException;
import skipass.rideCounters.IRideCounter;
import skipass.verification.Verificator;

import java.lang.reflect.InvocationTargetException;

public class SkiPass {
    private IRideCounter counter;
    private boolean isForWorkDay;
    // Number of days or rides initially
    private ISkiPassType type;
    private int hourUpperBound;
    private boolean isBlocked;

    SkiPass(Class counterType, boolean isForWorkDay, ISkiPassType type, int hourUpperBound) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        this.counter = (IRideCounter) counterType.getConstructor(Integer.class).newInstance(type.toInt());
        this.isForWorkDay = isForWorkDay;
        this.type = type;
        this.hourUpperBound = hourUpperBound;
        this.isBlocked = false;
    }

    public boolean use(){
        try {
            Verificator.isHourValid(getHourUpperBound());
            return counter.makeRide();
        }catch (TooLateTooRideException e){
            return false;
        }
    }

    public int getHourUpperBound() {
        return hourUpperBound;
    }

    public boolean isForWorkDay() {
        return isForWorkDay;
    }

    public int getType() {
        // Number of days or rides initially
        return type.toInt();
    }

    public boolean isBlocked(){
        return isBlocked;
    }

    private void setBlocked(){
        this.isBlocked = true;
    }
}
