/**
 * @author ios
 * @version 1.0
 * @ClassName ReadEventHandler
 * @Description: TODO
 * @date 2023/1/11 下午2:13
 */
public class ReadEventHandler extends EventHandler{
    private Selector selector;

    public ReadEventHandler(Selector selector) {
        this.selector = selector;
    }

    public void handle(Event event) {
        //处理Accept的event事件
        if (event.getType() == EventType.READ) {

            //TODO 处理ACCEPT状态的事件
            System.out.println("read事件处理函数执行");
            //将事件状态改为下一个READ状态，并放入selector的缓冲队列中
            Event waitEvent = new Event();
            waitEvent.setSource(event.getSource());
            waitEvent.setType(EventType.WRITE);
            System.out.println("注册wait事件到selector");
            selector.addEvent(waitEvent);
        }
    }
}
