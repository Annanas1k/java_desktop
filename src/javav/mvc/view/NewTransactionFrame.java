package javav.mvc.view;

import javax.swing.*;
//1
public class NewTransactionFrame extends JPanel {
    public NewTransactionFrame() {

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Sarcina 1:");
        panel.add(label);

        add(panel);
        setVisible(true);
    }
}
