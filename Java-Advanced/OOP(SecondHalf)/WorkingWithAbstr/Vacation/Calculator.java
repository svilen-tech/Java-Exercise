package WorkingWithAbstraction.StudentSystem;

public class Calculator {
    private double pricePerDay;
    private int numberOfDays;
    private Discount discount;
    private Seasons seasons;
    public Calculator(double pricePerDay, int numberOfDays,Seasons seasons,Discount discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.discount = discount;
        this.seasons=seasons;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }
    public double makeTheBill(){
        return pricePerDay*numberOfDays * seasons.getValue()
                *(1-(discount.getValue()/100.0));
    }
}
