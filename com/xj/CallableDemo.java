package xj;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//class MyThread implements Runnable{
//
//    @Override
//    public void run() {
//
//    }
//}
class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("come in");
        return 1024;
    }
}
/**
 * callable使用方式，一个对应一个futuretask
 * @author xijie
 * @version V1.0
 * Date 2021/1/9 15:05
 * @Description:
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        FutureTask<Integer> futureTask1 = new FutureTask<>(new MyThread2());
        Thread t1 = new Thread(futureTask,"A");
        Thread t2 = new Thread(futureTask1,"B");
        t1.start();
        t2.start();
//        System.out.println(futureTask.get());
        int result =100;
//        while(!futureTask.isDone()){
//
//        }
        int result1 =futureTask.get();
        System.out.println(result1+result);
    }




}
