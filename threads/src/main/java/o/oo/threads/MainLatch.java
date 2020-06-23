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
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);
        List<Future> fs = new ArrayList<Future>();
        for (int i = 0; i < 9; i++) {
            fs.add(executor.submit(new Normal(latch)));
            if (7 == i) fs.add(executor.submit(new Required(latch)));
        }
        System.out.println("sending last required task");
        fs.add(executor.submit(new Required(latch)));
        fs.add(executor.submit(new Required(latch)));
        fs.add(executor.submit(new Required(latch)));
        for (Future f : fs)
            System.out.println(f.get());
    }

    public static class Required implements Callable<String> {
        private CountDownLatch latch;
        public Required(CountDownLatch latch) {
            this.latch = latch;
        }
        public String call() throws Exception {
            String str = Thread.currentThread().getName() + "::" + System.currentTimeMillis() + "::Required:" + UUID.randomUUID();
            System.out.println(str);
            latch.countDown();
            return str + ":count#" + latch.getCount();
        }
    }

    public static class Normal implements Callable<String> {
        private CountDownLatch latch;
        public Normal(CountDownLatch latch) {
            this.latch = latch;
        }
        public String call() throws Exception {
            String str = Thread.currentThread().getName() + "::" + System.currentTimeMillis() + "::Normal:";
            System.out.println(str + "awaiting... #" + latch.getCount());
            latch.await();
            return str + UUID.randomUUID();
        }
    }
}