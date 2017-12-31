package skipass.rideCounters;

import skipass.verification.Verificator;
import skipass.verification.Exceptions.NewDayException;
import skipass.verification.Exceptions.NoRidesLeftException;

import java.util.Date;

public class DayRideCounter implements IRideCounter {
    private Integer ridesLeft;
    private Date lastRideDate;

    public DayRideCounter(Integer maxDaysNumber) {
        this.ridesLeft = maxDaysNumber;
        this.lastRideDate = new Date();
        lastRideDate.setDate(-1);
    }

    public boolean makeRide() {
        try {
            Verificator.areRidesLeft(getRidesLeft() + 1);
            Verificator.isSameDay(getLastRideDate());
        }
        catch (NoRidesLeftException e){
            return false;
        }
        catch (NewDayException e){
            setLastRideDate(new Date());
            setRidesLeft(getRidesLeft() - 1);
        }
        return true;
    }

    public Date getLastRideDate() {
        return lastRideDate;
    }

    private void setLastRideDate(Date date){
        this.lastRideDate = date;
    }

    public Integer getRidesLeft() {
        return ridesLeft;
    }

    private void setRidesLeft(int ridesLeft) {
        this.ridesLeft = ridesLeft;
    }

}
