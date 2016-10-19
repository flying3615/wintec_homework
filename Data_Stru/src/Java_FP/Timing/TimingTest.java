package Java_FP.Timing;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by liuyufei on 19/10/16.
 */
public class TimingTest {

    @org.junit.Test
    public void testTimed() throws Exception {
        final String description = "Supply carrot";
        AtomicReference<String> output = new AtomicReference<>();
        Timing.timed(description,output::set,()->"carrot");
        assert(output.get().contains(description));
    }

}