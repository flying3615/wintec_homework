package multicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastChat {

    private static final int PORT = 40202;
    private static final String IP = "239.0.202.1";

    //run with JVM -Djava.net.preferIPv4Stack=true if your pc listening on IPv6 address
    //https://github.com/bluestreak01/questdb/issues/23

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress group = InetAddress.getByName(IP);
        MulticastSocket socket = new MulticastSocket(PORT);
        socket.joinGroup(group);

        // get their responses!
        Thread receiveThread = new Thread(()->{
            while (true){
                byte[] buf = new byte[20];
                DatagramPacket recv = new DatagramPacket(buf, buf.length);
                try {
                    socket.receive(recv);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String received = new String(recv.getData());
                System.out.println(recv.getAddress()+": " + received);
            }
        });

        Thread sendThread = new Thread(()->{
            while (true){
                System.out.println("type in what you wanna say...");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String input = null;
                try {
                    input = bufferedReader.readLine();
                    DatagramPacket receiveData = new DatagramPacket(input.getBytes(), input.length(), group, PORT);
                    socket.send(receiveData);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        receiveThread.start();
        sendThread.start();

        receiveThread.join();
        sendThread.join();

        socket.leaveGroup(group);
        socket.close();

    }
}
