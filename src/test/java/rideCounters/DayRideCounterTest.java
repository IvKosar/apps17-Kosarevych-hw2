package rideCounters;

import org.junit.Test;
import skipass.rideCounters.DayRideCounter;

import java.lang.reflect.Method;
import java.util.Date;

import static org.junit.Assert.*;

public class DayRideCounterTest {
    @Test
    public void makeRideAllowedFirstRideOnDay() throws Exception {
        DayRideCounter dayRideCounter = new DayRideCounter(5);
        Method method = DayRideCounter.class.getDeclaredMethod("setLastRideDate", Date.class);
        method.setAccessible(true);
        Date dateBefore = new Date();
        dateBefore.setDate(-1);
        method.invoke(dayRideCounter, dateBefore);
        assertTrue(dayRideCounter.makeRide());
        assertEquals(new Date().getDate(), dayRideCounter.getLastRideDate().getDate());
    }

    @Test
    public void makeRideAllowedNotFirstRideOnDay() throws Exception {
        DayRideCounter dayRideCounter = new DayRideCounter(5);
        Method method = DayRideCounter.class.getDeclaredMethod("setLastRideDate", Date.class);
        method.setAccessible(true);
        method.invoke(dayRideCounter, new Date());
        assertTrue(dayRideCounter.makeRide());
        assertEquals(new Integer(5), dayRideCounter.getRidesLeft());
    }

    @Test
    public void makeRideNotAllowedNoRidesLeft() throws Exception {
        DayRideCounter dayRideCounter = new DayRideCounter(-1);
        assertFalse(dayRideCounter.makeRide());
    }

    @Test
    public void getLastRideDate() throws Exception {
        DayRideCounter dayRideCounter = new DayRideCounter(5);
        assertTrue(dayRideCounter.getLastRideDate().before(new Date()));
    }

    @Test
    public void setLastRideDate() throws Exception {
        DayRideCounter dayRideCounter = new DayRideCounter(5);
        Method method = DayRideCounter.class.getDeclaredMethod("setLastRideDate", Date.class);
        method.setAccessible(true);
        Date currentDate = new Date();
        method.invoke(dayRideCounter, currentDate);
        assertEquals(currentDate, dayRideCounter.getLastRideDate());
    }

    @Test
    public void getRidesLeft() throws Exception {
        DayRideCounter dayRideCounter = new DayRideCounter(5);
        assertEquals(new Integer(5), dayRideCounter.getRidesLeft());
    }

    @Test
    public void setRidesLeft() throws Exception {
        DayRideCounter dayRideCounter = new DayRideCounter(5);
        Method method = DayRideCounter.class.getDeclaredMethod("setRidesLeft", int.class);
        method.setAccessible(true);
        method.invoke(dayRideCounter, 4);
        assertEquals(new Integer(4), dayRideCounter.getRidesLeft());
    }
}