package Java_FP.FP;

/**
 * Created by liuyufei on 18/10/16.
 */

@FunctionalInterface
public interface FunctionOverTime {

    double valueAt(int time);

    static FunctionOverTime monthByMonth(double[] values) {
        return time -> values[time - 1];
    }

    static FunctionOverTime constant(final double value) {
        return polynomial(new double[]{value});
    }

    static FunctionOverTime line(final double intercept, final double slop) {
        return polynomial(new double[]{intercept, slop});
    }

    static FunctionOverTime polynomial(final double[] coefficients) {
        return time -> {
            double value = 0.0;
            for (int i = 0; i < coefficients.length; i++) {
                value += coefficients[i] * Math.pow(time, i);
            }
            return value;
        };
    }

    @FunctionalInterface
    interface FunctionOf3 {
        double apply(double a, double b, double c);
    }

    //reduce!!!
    static FunctionOverTime combinationOf3(FunctionOverTime a,
                                          FunctionOverTime b,
                                          FunctionOverTime c,
                                          FunctionOf3 f) {
        return time -> f.apply(a.valueAt(time),
                b.valueAt(time),
                c.valueAt(time));
    }

}
