package o.oo.threads;

import java.util.UUID;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;

public class WorkerBarrier implements Runnable {
      private CyclicBarrier barrier;
      private Random rand;

      public WorkerBarrier(CyclicBarrier newBarrier) {
        this.barrier = newBarrier;
        this.rand = new Random();
      }

      public void run() {
          int number = rand.nextInt(20);
          StringBuffer buffer = new StringBuffer(Thread.currentThread().getName() + "::");
          for (int i = 0; i < number; i++) {
              buffer.append(i % 2 == 0 ? "+" : "-");
          }
          System.out.println(Thread.currentThread().getName() + "::finished 1st count: " + number);
          try {
              buffer.append("|");
              barrier.await();
              buffer.append(">");
          } catch (InterruptedException e) {
            return;
          } catch (BrokenBarrierException e) {
              return;
          }
          for (int i = 0; i < number; i++)
              buffer.append(i % 2 == 0 ? "-" : "+");
          System.out.println(buffer.toString());
      }
}