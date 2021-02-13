package o.oo.threads;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class NormalForLatch implements Callable<String> {
    private final CountDownLatch latch;

    public NormalForLatch(final CountDownLatch latch) {
        this.latch = latch;
    }

    public String call() throws Exception {
        String uuid = UUID.randomUUID().toString();
        String prefix = String.format("[ ]::%s::%s", Thread.currentThread().getName(), uuid);
        latch.await();
        System.out.println(prefix + " >>>");

        return uuid;
    }
}