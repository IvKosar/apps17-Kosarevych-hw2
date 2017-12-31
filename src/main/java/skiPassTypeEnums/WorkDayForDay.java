package skiPassTypeEnums;

public enum WorkDayForDay implements ISkiPassType{
    ONE(1), TWO(2), FIVE(5);

    private int number;
    WorkDayForDay(int n){
        this.number = n;
    }

    public int toInt(){
        return number;
    }
}
