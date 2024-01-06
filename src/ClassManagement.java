import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

public class ClassManagement extends JFrame {
    public ClassManagement() {

        //list of Classes
        Vector<String> addedClasses = new Vector<>();

        //Stores addedClasses to File
        try (ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream("addedClasses.dat"))){
            fileWriter.writeObject(addedClasses);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reads from addedClasses File
        Vector<String> storedClasses = new Vector<>();
        try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("addedClasses.dat"))){
            storedClasses = (Vector<String>) fileReader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //24 - 44 sets layout and adds buttons to GUI
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int) (screen.getWidth() * 0.9);
        int height = (int) (screen.getHeight() * 0.9);

        setTitle("Class Master");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.setLayout(null);

        JButton addClass = new JButton("add Class");
        addClass.setBounds((int) (width * 0.85), (int) (0.02 * height), (int) (width * 0.075), (int) (0.05 * height));
        this.add(addClass);
        addClass.setVisible(true);

        JButton exit = new JButton("Exit");
        exit.setBounds((int) (width * 0.02), (int) (0.02 * height), (int) (width * 0.05), (int) (0.02 * height));
        this.add(exit);
        exit.setVisible(true);

        JComboBox classesDisplay = new JComboBox<>(storedClasses);
        classesDisplay.setBounds((int) (width * 0.1), (int) (0.02 * height), (int) (width * 0.7), (int) (0.05 * height));
        this.add(classesDisplay);

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
                String className = JOptionPane.showInputDialog("Enter the name of the school class:");
                // Add the input to the vector
                if (className != null && !className.isEmpty()) {
                    addedClasses.add(className);
                    // Update the JComboBox with the new items
                    classesDisplay.setModel(new DefaultComboBoxModel<>(addedClasses));
                }
            }
        });
    }
    public static void main(String[] args){
        new ClassManagement();
    }
}
