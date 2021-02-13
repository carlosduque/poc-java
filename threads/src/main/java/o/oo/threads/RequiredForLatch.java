package o.oo.threads;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class RequiredForLatch implements Callable<String> {
    private final CountDownLatch latch;

    public RequiredForLatch(final CountDownLatch latch) {
        this.latch = latch;
    }

    public String call() throws Exception {
        String uuid = UUID.randomUUID().toString();
        String prefix = String.format("[!]%s::%s:", Thread.currentThread().getName(), uuid);
        latch.countDown();
        return uuid;
    }
}