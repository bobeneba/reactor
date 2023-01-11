/**
 * @author ios
 * @version 1.0
 * @ClassName EventHandler
 * @Description: TODO
 * @date 2023/1/11 上午11:03
 */
public abstract class EventHandler {
    private InputSource source;
    public abstract void handle(Event event);

    public InputSource getSource() {
        return source;
    }

    public void setSource(InputSource source) {
        this.source = source;
    }
}
