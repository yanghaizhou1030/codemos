import java.net.*;
import java.io.*;

/**
 * Created by nickyang on 2017/5/7.
 */
public class HelloServer {
    private ServerSocket serverSocket;

    public HelloServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run()
    {
        while (true)
        {
            try{
                System.out.println("Waiting for client on port: " + serverSocket.getLocalPort());
                Socket socket = serverSocket.accept();
                System.out.println("Got connection to: " + socket.getRemoteSocketAddress());
                DataInputStream inStream = new DataInputStream(socket.getInputStream());
                System.out.println("Data received: " + inStream.readUTF());
                DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
                outStream.writeUTF("Thank you for connecting to: " + socket.getLocalSocketAddress());
                outStream.close();
                inStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        int port = 8088;
        try{
            HelloServer server = new HelloServer(port);
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
