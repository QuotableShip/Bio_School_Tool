import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClassManagement extends JFrame {
    public List<Class> classes = new ArrayList<>();
    public ClassManagement() {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int) (screen.getWidth() * 0.9);
        int height = (int) (screen.getHeight() * 0.9);

        setTitle("Class Master");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.setLayout(null);

        JButton exit = new JButton("Exit");
        exit.setBounds((int) (width * 0.02), (int) (0.02 * height), (int) (width * 0.05), (int) (0.02 * height));
        this.add(exit);
        exit.setVisible(true);

        JButton addStudent = new JButton("Add Student");
        addStudent.setBounds((int) (width * 0.9), (int) (0.02 * height), (int) (width * 0.09), (int) (0.05 * height));
        this.add(addStudent);
        exit.setVisible(true);

        JButton addClass = new JButton("Add Class");
        addClass.setBounds((int) (width * 0.8), (int) (0.02 * height), (int) (width * 0.09), (int) (0.05 * height));
        this.add(addClass);
        exit.setVisible(true);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                setVisible(false);
                dispose();
            }
        });

        addClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ClassName = JOptionPane.showInputDialog("Enter the Class");
                classes.add(new Class(ClassName));
                for(int i = 0; i < classes.size(); i ++){
                    System.out.println(classes.get(i).ClassName);
                }
            }
        });
        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("a");
            }
        });
    }
    public static void main(String[] args){
        new ClassManagement();
    }
}
