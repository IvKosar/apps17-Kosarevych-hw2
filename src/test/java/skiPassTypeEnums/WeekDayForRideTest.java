package skiPassTypeEnums;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeekDayForRideTest {
    @Test
    public void toIntTestTen() throws Exception {
        assertEquals(10, WeekDayForRide.TEN.toInt());
    }

    @Test
    public void toIntTestTwenty() throws Exception {
        assertEquals(20, WeekDayForRide.TWENTY.toInt());
    }

    @Test
    public void toIntTestFifty() throws Exception {
        assertEquals(50, WeekDayForRide.FIFTY.toInt());
    }

    @Test
    public void toIntTestHundred() throws Exception {
        assertEquals(100, WeekDayForRide.HUNDERED.toInt());
    }
}
