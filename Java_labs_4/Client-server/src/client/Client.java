package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private InetAddress address;
    private int port;



    public Client (int port){
        try {
            address = InetAddress.getByName("localhost");
            this.port = port;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
    public void Connection() {
        try{
            socket = new Socket(address,port);

            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream.writeObject("Hello, " + this.toString());

            while(true) {
                String serverMessage = (String) objectInputStream.readObject();
                System.out.println(serverMessage);
                objectOutputStream.writeObject("OK : " + socket.toString());

            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
