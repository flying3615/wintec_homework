package Java_FP.FP2_typesafe;

import Java_FP.FP.FunctionOverTime;
import Java_FP.OOD.QuantityOfInterest;

/**
 * Created by liuyufei on 18/10/16.
 */
public class IncrementalCosts implements QuantityOfInterest {

    private final FunctionOverTime valueFunction;

    public IncrementalCosts(FunctionOverTime valueFunction) {
        this.valueFunction = valueFunction;
    }

    @Override
    public String getName() {
        return "IncrementalCosts";
    }

    @Override
    public double valueAt(int time) {
        return valueFunction.valueAt(time);
    }
}
