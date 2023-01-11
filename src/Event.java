/**
 * @author ios
 * @version 1.0
 * @ClassName Event
 * @Description: TODO
 * @date 2023/1/11 上午8:57
 */
public class Event {
    private InputSource source;
    private EventType type;

    public InputSource getSource() {
        return source;
    }

    public void setSource(InputSource source) {
        this.source = source;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
