package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnection extends Thread{

    private Socket socket;

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public ClientConnection(Socket socket) throws IOException {
        this.socket = socket;
        objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
        System.out.println(this.socket.toString());
        start();
    }

    public void run() {
        try {
            while (true) {
                System.out.print("Client: ");
                String clientMessage = (String) objectInputStream.readObject();
                System.out.println(clientMessage);
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void send(String message) {
        try {
            System.out.println("Send to: " + this.socket.toString());
            System.out.println(message);
            objectOutputStream.writeObject(message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}