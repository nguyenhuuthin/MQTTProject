import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * Get Message From Broker.
     * @param socket connect to Broker throw socket.
     * @return string received from Broker.
     */
    public String getMessageFromServer(Socket socket) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }

    /**
     * Send Message to Broker.
     * @param socket connect to Broker throw socket.
     * @param message string sending to Broker.
     */
    public void sendMessageToServer(Socket socket, String message) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(message);
        printWriter.flush();
    }

    public static void main(String [] args) throws IOException {
        Client client = new Client();
        Socket socket = new Socket("localhost", 666666);

        client.sendMessageToServer(socket, "hello broker");
        String receivedMessage = client.getMessageFromServer(socket);

        if (!receivedMessage.equals("200 hello client")) {
            client.sendMessageToServer(socket, "sub/location/sensorA");
            receivedMessage = client.getMessageFromServer(socket);
            if (receivedMessage.equals("210 ok")) {
                int i = 0;
                while (true) {
                    client.sendMessageToServer(socket, "temperature " + i + ": " + Math.random() * (40 - 30 + 1) + 30);
                    KeyEvent e = null;
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        break;
                    }
                }
            }
        }
    }
}
