package Java_FP.OOD;

/**
 * Created by liuyufei on 18/10/16.
 */
public class FixedCosts extends PolynomialQuantity {


    public FixedCosts(double coefficient) {
        super(new double[]{coefficient});
    }

    @Override
    public String getName() {
        return "Fixed Costs";
    }
}
