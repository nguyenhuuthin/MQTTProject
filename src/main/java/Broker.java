import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Broker {
    private static ServerSocket serverSocket;
    public static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException ioException) {
            System.out.println("\nUnable to set up port!\n");
            System.exit(1);
        }

        do {
            System.out.println("Wait for client...\n");
            Socket client = serverSocket.accept();
            System.out.println("New client accepted.\n");
            ClientHandler handler = new ClientHandler(client);
            handler.start();
        } while (true);
    }
}
