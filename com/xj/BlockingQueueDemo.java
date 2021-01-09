package xj;

import java.util.concurrent.*;

/**
 * ArrayBlockingQueue : 基于数组，有界阻塞，FIFO(先进先出)
 * LinkedBlockingQueue: 基于链表，FIFO(先进先出)
 * SynchronousQueue   : 一个不存储元素的阻塞队列，每个插入必须等另一个线程调用移除操作，否则插入操作一直处于阻塞状态 ，吞吐量通常高
 * @author xijie
 * @version V1.0
 * Date 2021/1/9 13:07
 * @Description:阻塞队列
 * 1、阻塞有没有好的一面
 * 2、不得不阻塞如何，如果管理
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception{
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.offer("c"));
//        java.lang.IllegalStateException: Queue full
//        System.out.println(blockingQueue.add("c"));
//        the head of this queue
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remainingCapacity());
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.poll());

//        java.util.NoSuchElementException
//        System.out.println(blockingQueue.remove());
        BlockingQueue blockingQueuePutake = new ArrayBlockingQueue(3);
        blockingQueuePutake.put("a");
        blockingQueuePutake.put("b");
        blockingQueuePutake.put("c");
//      一直等
//        blockingQueuePutake.put("d");
        blockingQueuePutake.take();
        blockingQueuePutake.take();
        blockingQueuePutake.take();
        System.out.println("============================================");
//        一直等
//        blockingQueuePutake.take();
        BlockingQueue blockingQueueOffer = new ArrayBlockingQueue(3);
        System.out.println(blockingQueueOffer.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueueOffer.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueueOffer.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueueOffer.offer("a",2L, TimeUnit.SECONDS));
    }

}
