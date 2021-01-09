package xj;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author xijie
 * @version V1.0
 * Date 2021/1/9 13:53
 * @Description:
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        new Thread(()->{
            try {
                System.out.println("put 1");
                synchronousQueue.put("1");
                System.out.println("put 2");
                synchronousQueue.put("2");
                System.out.println("put 3");
                synchronousQueue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("take 1");
                synchronousQueue.take();
                TimeUnit.SECONDS.sleep(3);
                System.out.println("take 2");
                synchronousQueue.take();
                TimeUnit.SECONDS.sleep(3);
                System.out.println("take 3");
                synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

    }
}
