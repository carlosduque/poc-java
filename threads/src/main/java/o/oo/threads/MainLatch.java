package o.oo.threads;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.CountDownLatch;

public class MainLatch {
    public static void main(final String[] args) throws Exception {
        final ExecutorService executor = Executors.newFixedThreadPool(2);
        final CountDownLatch latch = new CountDownLatch(2);
        final List<Future> fs = new ArrayList<Future>();

        fs.add(executor.submit(new RequiredForLatch(latch)));
        for (int i = 0; i < 9; i++) {
            fs.add(executor.submit(new NormalForLatch(latch)));
        }
        System.out.println("sending last required task");
        latch.countDown();

        for (final Future f : fs)
            System.out.println(f.get());
    }

}