package Java_FP.Timing;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import  static Java_FP.Timing.Timing.timed;
/**
 * Created by liuyufei on 19/10/16.
 */
public class Example {

    static final Logger logger = Logger.getLogger(Example.class.getName());

    public static void main(String[] args) {


        //wrap up the time calculation in a function,GREAT!!!!!
        //default I print in out into a stdout
        final double costs = timed("Cost calculation",Example::calculateCosts);
        final double revenue = timed("Revenue calculation",Example::calculateRevenue);
        //even I can write it into a logger!!!
        final double profit = timed("Profit calculation",logger::info,()->calculateProfit(costs,revenue));

        System.out.println("Profit = $"+profit);
    }

    private static double calculateProfit(double costs, double revenue) {
        pretendToWorkHard();
        return 432.2;
    }

    private static double calculateRevenue() {
        pretendToWorkHard();
        return 23413.2;
    }

    private static double calculateCosts() {
        pretendToWorkHard();
        return 4567.3;
    }

    private static void pretendToWorkHard() {
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
