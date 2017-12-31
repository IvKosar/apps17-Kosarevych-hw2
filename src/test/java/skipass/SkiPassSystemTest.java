package skipass;

import org.junit.Test;
import skiPassTypeEnums.WeekDayForDay;
import skiPassTypeEnums.WeekDayForRide;
import skipass.rideCounters.DayRideCounter;
import skipass.rideCounters.EachRideCounter;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class SkiPassSystemTest {
    @Test
    public void produceOneSkiPass() throws Exception {
        SkiPassSystem factory = new SkiPassSystem();

        HashMap<String, String> params = new HashMap<>();
        params.put("counterType", "byDay");
        params.put("forWorkDay", "true");
        params.put("ridesNumber", "FIVE");
        params.put("hourBound", "24");

        List<SkiPass> result = factory.produceSkiPasses(params);
        assertEquals(1, result.size());
        SkiPass skiPass = result.get(0);
        assertEquals(24, skiPass.getHourUpperBound());
        assertTrue(skiPass.isForWorkDay());
        assertEquals(5, skiPass.getType());
    }

    @Test
    public void blockSkiPass() throws Exception {
        SkiPassSystem factory = new SkiPassSystem();
        SkiPass skiPass = new SkiPass(EachRideCounter.class, false, WeekDayForDay.ONE, 24);
        factory.blockSkiPass(skiPass);
        assertTrue(skiPass.isBlocked());
    }

}