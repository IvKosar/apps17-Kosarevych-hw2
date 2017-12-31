package skipass;

import org.junit.Test;
import skiPassTypeEnums.WorkDayForDay;
import skipass.rideCounters.DayRideCounter;

import static org.junit.Assert.*;

public class SkiPassTest {
    @Test
    public void use() throws Exception {
        SkiPass skiPass = new SkiPass(DayRideCounter.class, true, WorkDayForDay.FIVE, 24);
        assertTrue(skiPass.use());
    }

    @Test
    public void getHourUpperBound() throws Exception {
        SkiPass skiPass = new SkiPass(DayRideCounter.class, true, WorkDayForDay.FIVE, 17);
        assertEquals(17, skiPass.getHourUpperBound());
    }

    @Test
    public void isForWorkDay() throws Exception {
        SkiPass skiPass = new SkiPass(DayRideCounter.class, true, WorkDayForDay.FIVE, 24);
        assertTrue(skiPass.isForWorkDay());
    }

    @Test
    public void getType() throws Exception {
        SkiPass skiPass = new SkiPass(DayRideCounter.class, true, WorkDayForDay.FIVE, 24);
        assertEquals(5, skiPass.getType());
    }

    @Test
    public void isBlockedTest() throws Exception{
        SkiPass skiPass = new SkiPass(DayRideCounter.class, true, WorkDayForDay.FIVE, 24);
        assertFalse(skiPass.isBlocked());
    }

}