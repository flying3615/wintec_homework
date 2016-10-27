package Java_FP.OOD;

/**
 * Created by liuyufei on 18/10/16.
 */
public class IncrementalCosts extends PolynomialQuantity{

    public IncrementalCosts(double intercept,double slope) {
        super(new double[]{intercept,slope});
    }


    @Override
    public String getName() {
        return "Incremental Costs";
    }
}
