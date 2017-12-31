package skiPassTypeEnums;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeekDayForDayTest {
    @Test
    public void toIntTestOne() throws Exception {
        assertEquals(1, WeekDayForDay.ONE.toInt());
    }

    @Test
    public void toIntTestTwo() throws Exception {
        assertEquals(2, WeekDayForDay.TWO.toInt());
    }
}
