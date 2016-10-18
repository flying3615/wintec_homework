package Java_FP.OOD;

/**
 * Created by liuyufei on 18/10/16.
 */
abstract class MonthByMonthQuantity implements QuantityOfInterest {


    private final double[] values;

    protected  MonthByMonthQuantity(final double[] values){
        this.values = values;
    }


    @Override
    public double valueAt(int time) {
        return values[time-1];
    }
}
