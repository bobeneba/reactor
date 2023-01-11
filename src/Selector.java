import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ios
 * @version 1.0
 * @ClassName Select
 * @Description: TODO
 * @date 2023/1/11 上午11:09
 */
public class Selector {
    private BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>();
    private Object lock = new Object();

    List<Event> select() {
        return select(0);
    }

    List<Event> select(long timeout) {

            if (eventQueue.isEmpty()) {
                synchronized (lock) {
                    if (eventQueue.isEmpty()) {
                        try {
                            if(timeout>0){
                                lock.wait(timeout);
                            }else {
                                lock.wait();
                            }

                        } catch (InterruptedException e) {
                        }
                    }
                }

            }

        List<Event> events = new ArrayList<Event>();
        eventQueue.drainTo(events);
        return events;
    }

    public void addEvent(Event e) {
        //将event事件加入队列
        boolean success = eventQueue.offer(e);
        if (success) {
            synchronized (lock) {
                //如果有新增事件则对lock对象解锁
                lock.notify();
            }

        }
    }
}
