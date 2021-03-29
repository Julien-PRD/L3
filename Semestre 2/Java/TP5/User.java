import java.net.Socket;

public class User {
    
    private String name;
    private String ip;
    private Socket socket;
    private int port;

    public User(String name, String ip, int port){
        this.name = name;
        this.ip = ip;
        this.port = port;
    }

    public User(String name, Socket socket, int port){
        this.name = name;
        this.socket = socket;
        this.port = port;
    }

    String getName(){
        return name;
    }

    String getIP(){
        return ip;
    }

    int getPort(){
        return port;
    }

}
