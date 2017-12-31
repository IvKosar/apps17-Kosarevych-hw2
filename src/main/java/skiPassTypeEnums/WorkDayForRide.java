package skiPassTypeEnums;

public enum WorkDayForRide implements ISkiPassType{
    TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    private int number;
    WorkDayForRide(int n){
        this.number = n;
    }

    public int toInt(){
        return number;
    }
}
