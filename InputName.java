import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: huxu
 * Date: 13-10-27
 * Time: 下午1:23
 * To change this template use File | Settings | File Templates.
 */
public class InputName {
    final JFrame inputName = new JFrame();
    JLabel namelb = new JLabel();
    final JTextField name = new JTextField();
    JButton confirm = new JButton();
    final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    final int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    public InputName() {
    }

    public void show(){
        inputName.setLayout(null);
        namelb.setText("Set your name:");
        namelb.setBounds(10, 12, 120, 20);
        name.setBounds(10, 44, 100, 20);
        confirm.setBounds(15, 78, 90, 20);
        confirm.setText("Enter >>");
        inputName.add(namelb);
        inputName.add(name);
        inputName.add(confirm);
        inputName.setSize(120, 130);
        inputName.setResizable(false);
        inputName.getRootPane().setDefaultButton(confirm);
        inputName.setLocation((screenWidth - 120) / 2, (screenHeight - 300) / 2);
        inputName.setVisible(true);
    }
}
