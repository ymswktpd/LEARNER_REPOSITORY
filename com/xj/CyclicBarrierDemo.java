package xj;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author xijie
 * @version V1.0
 * Date 2021/1/9 12:42
 * @Description:
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(7,()-> {System.out.println("******结束！");});
        for(int i=1;i<=7;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }

}
