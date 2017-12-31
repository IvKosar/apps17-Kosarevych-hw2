package skiPassTypeEnums;

public enum WeekDayForRide implements ISkiPassType {
    TEN(10), TWENTY(20), FIFTY(50), HUNDERED(100);

    private int number;
    WeekDayForRide(int n){
        this.number = n;
    }

    public int toInt(){
        return number;
    }
}
