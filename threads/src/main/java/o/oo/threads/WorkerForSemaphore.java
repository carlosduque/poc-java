package o.oo.threads;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

public class WorkerForSemaphore implements Callable<String> {
    private final Semaphore token;

    public WorkerForSemaphore(final Semaphore token) {
        this.token = token;
    }

    public String call() throws Exception {
        token.acquire();
        String uuid = UUID.randomUUID().toString();
        String prefix = String.format("::%s::%s", Thread.currentThread().getName(), uuid);
        Random rand = new Random();
        int top = rand.nextInt(100);
        Thread.sleep(rand.nextInt(3200));
        System.out.println(prefix + "|" + top + "|");
        token.release();
        return uuid + " <-|" + top + "|";
    }
}