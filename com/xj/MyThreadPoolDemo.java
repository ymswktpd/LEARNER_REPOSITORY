package xj;

import java.util.concurrent.*;

/**
 * @author xijie
 * @version V1.0
 * Date 2021/1/9 15:54
 * @Description:第四种获得使用java多线程的方式
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
//        获取处理器核数
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        获取定长线程池，5个线程
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newCachedThreadPool();
        //实际要手动实现
//        ExecutorService executorService = new ThreadPoolExecutor(2,5,2L,TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
//        ExecutorService executorService = new ThreadPoolExecutor(2,5,2L,TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());
        ExecutorService executorService = new ThreadPoolExecutor(2,5,2L,TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());
//        ExecutorService executorService = new ThreadPoolExecutor(2,5,2L,TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
        //模拟10个任务

        try {
            for(int i=1;i<=20;i++){
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理业务");
                });
//                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }
}
