/**
 * Created with IntelliJ IDEA.
 * User: huxu
 * Date: 13-10-27
 * Time: 上午12:35
 * To change this template use File | Settings | File Templates.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class Client {
    InputName inputName = new InputName();

    public static void main(String[] args) throws Exception {
        new Client();
    }

    public Client() {
        inputName.show();
        inputName.confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputName.inputName.dispose();
                try {
                    String name = inputName.name.getText().toString();
                    Socket socket = new Socket(InetAddress.getLocalHost(), 9876);
                    new Sender(socket, name).start();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    static class Sender extends Thread {
        private Socket socket;
        private String name;

        public Sender(Socket socket, String name) {
            this.socket = socket;
            this.name = name;
        }

        public void run() {
            final ChatWindow chatWindow = new ChatWindow();
            chatWindow.show();
            chatWindow.sendMessage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String msg = chatWindow.inputMessage.getText();
                        System.out.println(msg);
                        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                        pw.println(name + " said: " + msg);
                        chatWindow.inputMessage.setText("");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });

            try {
                while (true) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String msg = br.readLine();
                    if (!msg.equals("null")) {
                        System.out.println(msg);
                        chatWindow.showMessages.append(msg + "\n");
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }

        }
    }
}
