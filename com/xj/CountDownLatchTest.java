package xj;

import java.util.concurrent.CountDownLatch;

/**
 * @author xijie
 * @version V1.0
 * Date 2021/1/9 10:53
 * @Description:
 */
public class CountDownLatchTest {
    /**
     * 计数器，调用一次减一，到0执行await方法后的
     * 其他执行完毕main线程再执行
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        CountDownLatch cdl = new CountDownLatch(6);
        for(int i=0;i<6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"国，被灭！");
                cdl.countDown();
            },CountryEnum.getEnum(i+1).getValue()).start();
        }
        cdl.await();
        System.out.println(Thread.currentThread().getName()+"秦国");
        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.ONE.getKey());
        System.out.println(CountryEnum.ONE.getValue());
    }
}
