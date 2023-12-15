import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class Attendance extends JFrame {
    public Vector<TheClass> classes = new Vector<TheClass>();

    public JComboBox<String> classesDropDown;
    public Attendance(){

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int)(screen.getWidth() * 0.9);
        int height = (int)(screen.getHeight() * 0.9);

        setTitle("Class Master");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.setLayout(null);

        JButton exit = new JButton("Exit");
        exit.setBounds((int)(width*0.02),(int)(0.02*height), (int)(width*0.05), (int)(0.02*height));
        this.add(exit);
        exit.setVisible(true);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                setVisible(false);
                dispose();
            }
        });



        classesDropDown = new JComboBox<>();
        classesDropDown.setBounds((int)((width * 0.5) - (width * 0.25)), (int) (height * 0.05), (int)(width * 0.5), (int)(height * 0.05));
        this.add(classesDropDown);
        classesDropDown.setForeground(Color.BLUE);
        classesDropDown.setFont(new Font("Arial", Font.BOLD, 14));
        classesDropDown.setVisible(true);

        classesDropDown.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                classesDropDown.removeAllItems();
                for (int i=0; i<classes.size(); i++) {
                    classesDropDown.addItem(classes.get(i).ClassName);
                }
                classesDropDown.setModel(new DefaultComboBoxModel(classes));
                //classesDropDown.setModel(new DefaultComboBoxModel(ClassManagement.classes));
                }
        });
    }
   public static void main(String[] args) {
        new Attendance();
    }
}
