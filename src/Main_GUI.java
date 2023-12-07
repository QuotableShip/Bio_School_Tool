import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_GUI extends JFrame {
    public Main_GUI(){
        setTitle("Class Master");
        add(new JLabel("Enter Password", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JButton exit = new JButton("Exit");
        exit.setBounds(10,10, 60, 25);
        this.add(exit);
        exit.setVisible(true);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
        });


        this.setLayout(null);

        JPasswordField Pw = new JPasswordField();

        this.add(Pw, SwingConstants.CENTER);
        this.setLayout(null);
        JButton Enter = new JButton("Enter");
        this.add(Enter);
        Enter.setBounds(150, 200, 100, 50);
        Pw.setBounds(125,25,150,20);

        Enter.setVisible(true);
        Pw.setVisible(true);
        Enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = Pw.getText();
                if (pass.equals("notJesus")) {
                    new Home();
                    setVisible(false);
                    dispose();
                }

            }
        });

    }
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  // Windows Look and feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new Main_GUI();
    }
}

