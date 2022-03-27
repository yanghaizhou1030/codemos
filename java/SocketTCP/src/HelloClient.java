import java.net.*;
import java.io.*;

/**
 * Created by nickyang on 2017/5/7.
 */
public class HelloClient {
    public static void main(String[] args)
    {
        String serverName = "localhost";
        int port = 8088;
        try
        {
            System.out.println("Connecting to: " + serverName + " on port " + port);
            Socket socket = new Socket(serverName, port);
            System.out.println("Connected!");
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            outStream.writeUTF("Hello from: " + socket.getLocalSocketAddress());
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            System.out.println("Servers says: " + inStream.readUTF());
            outStream.close();
            inStream.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
