import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.sleep;

/**
 * @author ios
 * @version 1.0
 * @ClassName Dispatcher
 * @Description: 分发器，获取事件，根据事件绑定的事件处理器进行分发处理
 * @date 2023/1/11 下午1:30
 */
public class Dispatcher {
    Map<EventType, EventHandler> eventHandlerMap = new ConcurrentHashMap<EventType, EventHandler>();
    Selector selector;

    Dispatcher(Selector selector) {
        this.selector = selector;
    }

    public void registEventHandler(EventType eventType, EventHandler eventHandler) {
        eventHandlerMap.put(eventType, eventHandler);
        System.out.println("注册事件处理器："+eventType.toString()+eventHandler.toString());

    }

    public void removeEventHandler(EventType eventType) {
        eventHandlerMap.remove(eventType);
    }

    public void handleEvents() throws InterruptedException {
        dispatch();
    }

    private void dispatch() throws InterruptedException {
        while (true) {
            List<Event> events = selector.select();
            System.out.println("获取selector 事件列表");


            for (Event event : events) {
                EventHandler eventHandler = eventHandlerMap.get(event.getType());
                if(eventHandler!=null){
                    eventHandler.handle(event);
                    System.out.println("获取事件处理函数，进行事件方法处理");
                }else {
                    System.out.println("事件处理函数未注册，要开发注册函数功能"+event.getType());
                }


            }
        }
    }


}
