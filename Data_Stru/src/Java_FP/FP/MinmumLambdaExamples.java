package Java_FP.FP;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * Created by liuyufei on 18/10/16.
 */
public class MinmumLambdaExamples {

    public static void main(String[] args) {
        IntToDoubleFunction incrementalCosts = time -> 5.1 + 0.15*time;

        Function<String,Integer> wordCount = s -> s.split(" ").length;

        BiFunction<String,Integer,Boolean> exceedsMaxLength = (s,maxLength)-> {
            int actualLength = s.length();
            return actualLength > maxLength;
        };
    }
}
