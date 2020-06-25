package o.oo.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MainSemaphore {
    public static void main(final String[] args) throws Exception {
        final ExecutorService executor = Executors.newFixedThreadPool(5);
        final Semaphore semaphore = new Semaphore(3);
        final List<Future> fs = new ArrayList<Future>();

        for (int i = 0; i < 20; i++) {
            fs.add(executor.submit(new WorkerForSemaphore(semaphore)));
        }

        for (final Future f : fs)
            System.out.println(f.get());
        
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}