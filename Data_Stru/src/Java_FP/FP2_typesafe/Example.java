package Java_FP.FP2_typesafe;

import Java_FP.FP.FunctionOverTime;

/**
 * Created by liuyufei on 18/10/16.
 */
public class Example {

    final static double[] EXPECTED_SALES_JAN_TO_DEC =
            new double[]{42.0, 45.6, 43.6, 50.2, 55.6, 54.7,
                    58.0, 57.3, 62.0, 60.3, 71.2, 88.8
            };


    public static void main(String[] args) {

        final Sales sales = new Sales(FunctionOverTime.monthByMonth(EXPECTED_SALES_JAN_TO_DEC));

        final FixedCosts fixedCost = new FixedCosts(FunctionOverTime.constant(15.0));

        final IncrementalCosts incrementalCosts = new IncrementalCosts(FunctionOverTime.line(5.1,0.15));

        final Profit profit = new Profit(sales,incrementalCosts,fixedCost);


        double total = 0.0;
        for (int i = 1; i <= 12; i++) {
            total += profit.valueAt(i);
        }

        System.out.println("Total profits for the year: " + total);
    }
}
