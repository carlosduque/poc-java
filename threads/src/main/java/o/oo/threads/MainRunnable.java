package o.oo.threads;

import java.util.UUID;
import java.util.concurrent.ExecutorService;

public class MainRunnable {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
          System.out.println("launching T#" + i);
          new Thread(new Runnable(){
              @Override
              public void run() {
                  System.out.println(Thread.currentThread().getName() + "::" + UUID.randomUUID());
              }
          }).start();
        }
    }   
}