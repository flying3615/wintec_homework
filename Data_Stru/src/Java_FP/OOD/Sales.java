package Java_FP.OOD;

/**
 * Created by liuyufei on 18/10/16.
 */
public class Sales extends MonthByMonthQuantity {

    public Sales(final double[] values){
        super(values);
    }

    @Override
    public String getName() {
        return "Expected Sales";
    }
}
