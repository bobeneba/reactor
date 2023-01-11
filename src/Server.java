
/**
 * @author ios
 * @version 1.0
 * @ClassName Server
 * @Description: TODO
 * @date 2023/1/11 下午1:45
 */
public class Server {
    Selector selector = new Selector();
    Dispatcher eventLooper = new Dispatcher(selector);
    Acceptor acceptor;

    Server(int port) {
        acceptor = new Acceptor(selector, port);
    }

    public void start() {
        eventLooper.registEventHandler(EventType.ACCEPT, new AcceptEventHandler(selector));
        eventLooper.registEventHandler(EventType.READ,new ReadEventHandler(selector));
        new Thread(acceptor, "Acceptor-" + acceptor.getPort()).start();
        try {
            eventLooper.handleEvents();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

     public static void main(String[] args) {
         Server server = new Server(8080);
         server.acceptor.addNewConnection(new InputSource("connect",1));
         server.start();
     }
}
