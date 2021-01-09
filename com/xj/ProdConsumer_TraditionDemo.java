package xj;


import lombok.Getter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{ //资源类
    @Getter public int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() throws Exception{
        lock.lock();
        try {
            while(number!=0){
                //等待，不能生产
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
    public void decrement() throws Exception{
        lock.lock();
        try {
            while(number==0){
                //等待，不能生产
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
}
/**
 * @author xijie
 * @version V1.0
 * Date 2021/1/9 14:11
 * @Description:
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        // 1 判断
        ShareData shareData = new ShareData();

        new Thread(()->{
            for (int i=0;i<5;i++){
                try {
                    shareData.decrement();
//                    System.out.println(shareData.getNumber());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i=0;i<5;i++){
                try {
                    shareData.increment();
//                    System.out.println(shareData.getNumber());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}
