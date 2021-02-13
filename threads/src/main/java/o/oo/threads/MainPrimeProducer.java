package o.oo.threads;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainPrimeProducer extends Thread {
    public static void main(String[] args) throws Exception {
        BlockingQueue<BigInteger> queue = new LinkedBlockingQueue<BigInteger>();
        PrimeProducer primeProducer = new PrimeProducer(queue);
        System.out.println(Thread.currentThread().getName() + "::starting primeProducer thread");
        primeProducer.start();
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + "::queue size: " + queue.size());
        System.out.println(Thread.currentThread().getName() + "::calling interrupt() in primeProducer thread");
        primeProducer.cancel();
    }
}