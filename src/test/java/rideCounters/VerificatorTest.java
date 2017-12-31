package rideCounters;

import org.junit.Test;
import skipass.verification.Exceptions.NewDayException;
import skipass.verification.Exceptions.NoRidesLeftException;
import skipass.verification.Exceptions.TooLateTooRideException;
import skipass.verification.Verificator;

import java.util.Date;

import static org.junit.Assert.*;

public class VerificatorTest {
    @Test
    public void areRidesLeftTestThereAre() throws Exception {
        assertTrue(Verificator.areRidesLeft(4));
    }

    @Test(expected = NoRidesLeftException.class)
    public void areRidesLeftTestThereAreNt() throws Exception {
        Verificator.areRidesLeft(0);
    }

    @Test
    public void isSameDayTrue() throws Exception {
        Date date = new Date();
        assertTrue(Verificator.isSameDay(date));
    }

    @Test(expected = NewDayException.class)
    public void isNewDay(){
        Date date = new Date();
        date.setDate(1);
        date.setMonth(1);
        date.setYear(2017);
        Verificator.isSameDay(date);
    }

    @Test
    public void isHourValid() throws Exception {
        assertTrue(Verificator.isHourValid(23));
    }

    @Test(expected = TooLateTooRideException.class)
    public void hourIsNotValid(){
        Verificator.isHourValid(0);
    }
}