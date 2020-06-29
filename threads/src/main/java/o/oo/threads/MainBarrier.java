package o.oo.threads;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;

public class MainBarrier {
    public static void main(final String[] args) throws Exception {
        final ExecutorService executor = Executors.newFixedThreadPool(3);
        final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable(){
            public void run() {
                System.out.println(Thread.currentThread().getName() + "::all abord, go!");
            }
        });

        for (int i = 0; i < 3; i++) {
            executor.submit(new WorkerBarrier(barrier));
        }
        
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

}