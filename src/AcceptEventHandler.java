/**
 * @author ios
 * @version 1.0
 * @ClassName AcceptEventHandler
 * @Description: TODO
 * @date 2023/1/11 上午11:04
 */
public class AcceptEventHandler extends EventHandler{
    private Selector selector;

    public AcceptEventHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        //处理Accept的event事件
        if (event.getType() == EventType.ACCEPT) {

            //TODO 处理ACCEPT状态的事件
            System.out.println("accept事件处理函数执行");
            //将事件状态改为下一个READ状态，并放入selector的缓冲队列中
            Event readEvent = new Event();
            readEvent.setSource(event.getSource());
            readEvent.setType(EventType.READ);
            System.out.println("注册读事件到selector");
            selector.addEvent(readEvent);
        }
    }
}
