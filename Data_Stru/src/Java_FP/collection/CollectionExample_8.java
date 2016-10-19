package Java_FP.collection;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by liuyufei on 19/10/16.
 */
public class CollectionExample_8 {

    final static String[] food = new String[]{
            "Crunchy carrots",
            "Golden-hued bananas",
            "",
            "Bright orange pumpkins",
            "Little trees of broccoli",
            "meat"
    };


    public static final Predicate<String> NON_EMPTY = s -> !s.isEmpty();

    //just return the last element, ignore the previous ones
    private static BinaryOperator<String> chooseLast = (allSoFar,nextElement)-> nextElement;

    private static Function<String,String> lastWord =
            phrase -> Arrays.asList(phrase.split(" ")).stream().reduce(chooseLast).orElse("");

    private static BinaryOperator<String> joinOn(String connector) {
        return (allSoFar, nextElement) -> allSoFar + connector + nextElement;
    }

    private static String summarize(final String[] description) {
        return Arrays.asList(description).stream()
                .filter(NON_EMPTY)
                .map(lastWord)
                .reduce(joinOn(" & "))
                .orElse("");
        //avoid null pointer exception, if allTogetherNow is empty, "" will be returned
    }


    public static void main(String[] args) {
        final String summary = summarize(food);
        final String desiredSummary =
                "carrots & bananas & pumpkins & broccoli & meat";
        System.out.println(summary);
        if (summary.equals(desiredSummary)) System.out.println("yay!");
    }

}
