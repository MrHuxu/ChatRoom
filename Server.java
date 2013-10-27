import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static List<Socket> list = new ArrayList<Socket>();
    private ServerSocket server;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try {
            server = new ServerSocket(9876);
            System.out.println("Server is start!");

            Socket client = null;
            while (true) {
                client = server.accept();
                list.add(client);
                new ChatTask(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ChatTask extends Thread {
        private Socket socket;
        private BufferedReader br;
        private PrintWriter pw;
        private String msg;

        public ChatTask(Socket socket) throws IOException {
            this.socket = socket;
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sendMessage();
        }

        public void run() {
            try {
                while ((msg = br.readLine()) != null) {
                    sendMessage();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendMessage() throws IOException {
            System.out.println(msg);
            for (Socket client : list) {
                pw = new PrintWriter(client.getOutputStream(), true);
                pw.println(msg);
            }
        }
    }
}
