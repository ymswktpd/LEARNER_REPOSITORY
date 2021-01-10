package xj;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

class ThreadHolder implements Runnable{

    private String locka;
    private String lockb;

    public ThreadHolder(String locka,String lockb){
            this.locka = locka;
            this.lockb = lockb;

    }

    @Override
    public void run() {
        synchronized (locka){
            System.out.println(Thread.currentThread().getName()+"持有locka锁，想要获得lockb");
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockb){
                System.out.println(Thread.currentThread().getName()+"持有lockb锁，想要获得locka");
            }
        }
    }
}
/**
 * @author xijie
 * @version V1.0
 * Date 2021/1/10 15:55
 * @Description:
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String locka = "locka";
        String lockb = "lockb";
        new Thread(new ThreadHolder(locka,lockb),"AAA").start();
        new Thread(new ThreadHolder(lockb,locka),"BBB").start();

    }
}
