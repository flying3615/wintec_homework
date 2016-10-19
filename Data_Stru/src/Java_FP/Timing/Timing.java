package Java_FP.Timing;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by liuyufei on 19/10/16.
 */
public class Timing {

    //Data in, data out, have no knowledge of the outside world


    //default means of print out
    public static <T> T timed(String description, Supplier<T> code){
        Consumer<String> defaultOutput = System.out::println;
        return timed(description,defaultOutput,code);
    }


    //return generic type
    public static <T> T timed(String description, Consumer<String> output, Supplier<T> code){
        final Date before = new Date();
        //Supplier get() to execute input code block!!!
        T result = code.get();
        final Long duration = new Date().getTime()-before.getTime();
        output.accept(description+" took "+duration+" milliseconds");
        return result;
    }
}
