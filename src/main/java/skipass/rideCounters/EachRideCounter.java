package skipass.rideCounters;

import skipass.verification.Verificator;
import skipass.verification.Exceptions.NoRidesLeftException;

public class EachRideCounter implements IRideCounter{
    private Integer ridesLeftNumber;

    public EachRideCounter(Integer maxRidesNumber){
        this.ridesLeftNumber = maxRidesNumber;
    }

    public boolean makeRide(){
        try {
            Verificator.areRidesLeft(ridesLeftNumber);
            setRidesLeft(getRidesLeft() - 1);
        }catch (NoRidesLeftException e){
            return false;
        }
        return true;
    }

    public Integer getRidesLeft(){
        return ridesLeftNumber;
    }

    private void setRidesLeft(int ridesLeft){
        this.ridesLeftNumber = ridesLeft;
    }
}
