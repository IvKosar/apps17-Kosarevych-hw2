package skiPassTypeEnums;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorkDayForDayTest {
    @Test
    public void toIntTestOne() throws Exception {
        assertEquals(1, WorkDayForDay.ONE.toInt());
    }

    @Test
    public void toIntTestTwo() throws Exception {
        assertEquals(2, WorkDayForDay.TWO.toInt());
    }

    @Test
    public void toIntTestFive() throws Exception {
        assertEquals(5, WorkDayForDay.FIVE.toInt());
    }

}