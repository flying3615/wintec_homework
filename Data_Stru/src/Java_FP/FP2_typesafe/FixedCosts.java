package Java_FP.FP2_typesafe;

import Java_FP.FP.FunctionOverTime;
import Java_FP.OOD.QuantityOfInterest;

/**
 * Created by liuyufei on 18/10/16.
 */
public class FixedCosts implements QuantityOfInterest {

    private final FunctionOverTime valueFunction;

    public FixedCosts(FunctionOverTime valueFunction) {
        this.valueFunction = valueFunction;
    }

    @Override
    public String getName() {
        return "Fixed Costs";
    }

    @Override
    public double valueAt(int time) {
        return valueFunction.valueAt(time);
    }
}
