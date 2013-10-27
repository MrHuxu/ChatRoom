import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: huxu
 * Date: 13-10-27
 * Time: 下午1:35
 * To change this template use File | Settings | File Templates.
 */
public class ChatWindow {
    final JFrame mainInterface = new JFrame();
    final JTextArea showMessages = new JTextArea();
    final JTextField inputMessage = new JTextField();
    final JButton sendMessage = new JButton();
    final JScrollPane scrollPane = new JScrollPane();
    final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    final int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    public ChatWindow() {
    }

    public void show() {
        mainInterface.setLayout(null);
        showMessages.setEditable(false);
        showMessages.setBounds(15, 15, 300, 200);
        inputMessage.setBounds(12, 225, 208, 23);
        sendMessage.setBounds(232, 222, 83, 32);
        sendMessage.setText("Send >>");
        scrollPane.setViewportView(showMessages);
        mainInterface.add(showMessages);
        mainInterface.add(inputMessage);
        mainInterface.add(sendMessage);
        mainInterface.setResizable(false);
        mainInterface.setSize(330, 285);
        mainInterface.getRootPane().setDefaultButton(sendMessage);
        mainInterface.setLocation((screenWidth - 330) / 2, (screenHeight - 430) / 2);
        mainInterface.setVisible(true);
    }
}
