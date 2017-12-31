package skipass;

import skiPassTypeEnums.*;
import skipass.rideCounters.DayRideCounter;
import skipass.rideCounters.EachRideCounter;
import skipass.rideCounters.IRideCounter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class SkiPassSystem {
    private static final Map<String, Class> counters;
    static {
        counters = new HashMap<>();
        counters.put("byDay", DayRideCounter.class);
        counters.put("byRide", EachRideCounter.class);
    }
    private static final Map<String, Map<Boolean, Class>> types;
    static {
        types = new HashMap<>();

        HashMap<Boolean, Class> byDay = new HashMap<>();
        byDay.put(true, WorkDayForDay.class);
        byDay.put(false, WeekDayForDay.class);
        types.put("byDay", byDay);

        HashMap<Boolean, Class> byRide = new HashMap<>();
        byRide.put(true, WorkDayForRide.class);
        byRide.put(false, WeekDayForRide.class);
        types.put("byRide", byRide);
    }

    public List<SkiPass> produceSkiPasses(HashMap<String, String>... skiPassesParamsList) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        List<SkiPass> skiPasses = new ArrayList<>();
        for (HashMap<String, String> oneSPParams : skiPassesParamsList){
            Class counter = counters.get(oneSPParams.get("counterType"));

            Boolean isForWorkDay = Boolean.parseBoolean(oneSPParams.get("forWorkDay"));
            Class typesClass = types.get(oneSPParams.get("counterType")).get(isForWorkDay);
            ISkiPassType type = (ISkiPassType) Enum.valueOf(typesClass, oneSPParams.get("ridesNumber"));

            Integer maxHour = Integer.parseInt(oneSPParams.get("hourBound"));

            SkiPass skiPass = new SkiPass(counter, isForWorkDay, type, maxHour);
            skiPasses.add(skiPass);
        }
        return skiPasses;
    }

    public void blockSkiPass(SkiPass skiPass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = SkiPass.class.getDeclaredMethod("setBlocked");
        method.setAccessible(true);
        method.invoke(skiPass);
    }
}
