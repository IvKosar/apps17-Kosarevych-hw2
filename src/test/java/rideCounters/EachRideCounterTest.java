package rideCounters;

import org.junit.Test;
import skipass.rideCounters.EachRideCounter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class EachRideCounterTest {
    @Test
    public void makeRideWhenYouCan() throws Exception {
        EachRideCounter eachRideCounter = new EachRideCounter(5);
        assertTrue(eachRideCounter.makeRide());
        assertEquals(new Integer(4), eachRideCounter.getRidesLeft());
    }

    @Test
    public void makeRideWhenYouCant() throws Exception{
        EachRideCounter eachRideCounter = new EachRideCounter(0);
        assertFalse(eachRideCounter.makeRide());
    }

    @Test
    public void getRidesLeft() throws Exception {
        EachRideCounter eachRideCounter = new EachRideCounter(5);
        assertEquals(new Integer(5), eachRideCounter.getRidesLeft());
    }

    @Test
    public void setRidesLeft() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        EachRideCounter eachRideCounter = new EachRideCounter(5);
        Method method = EachRideCounter.class.getDeclaredMethod("setRidesLeft", int.class);
        method.setAccessible(true);
        method.invoke(eachRideCounter, 4);
        assertEquals(new Integer(4), eachRideCounter.getRidesLeft());
    }
}