package Java_FP.OOD;

/**
 * Created by liuyufei on 18/10/16.
 */
abstract class PolynomialQuantity implements QuantityOfInterest{

    private final double[] coefficient;

    protected PolynomialQuantity(final double[] coefficient){
        this.coefficient = coefficient;
    }

    @Override
    public double valueAt(int time) {
        double value = 0.0;
        for(int i=0; i<coefficient.length;i++){
            value += coefficient[i] * Math.pow(time,i);
        }
        return value;
    }
}
