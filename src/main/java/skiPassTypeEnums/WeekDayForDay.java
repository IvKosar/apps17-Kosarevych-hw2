package skiPassTypeEnums;

public enum WeekDayForDay implements ISkiPassType {
    ONE(1), TWO(2);

    private int number;
    WeekDayForDay(int n){
        this.number = n;
    }

    public int toInt(){
        return number;
    }
}
