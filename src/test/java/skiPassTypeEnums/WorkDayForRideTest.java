package skiPassTypeEnums;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorkDayForRideTest {
    @Test
    public void toIntTestTen() throws Exception {
        assertEquals(10, WorkDayForRide.TEN.toInt());
    }

    @Test
    public void toIntTestTwenty() throws Exception {
        assertEquals(20, WorkDayForRide.TWENTY.toInt());
    }

    @Test
    public void toIntTestFifty() throws Exception {
        assertEquals(50, WorkDayForRide.FIFTY.toInt());
    }

    @Test
    public void toIntTestHundred() throws Exception {
        assertEquals(100, WorkDayForRide.HUNDRED.toInt());
    }
}
