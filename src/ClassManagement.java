/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Objects;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

//public class ClassManagement extends JFrame {
    private Map<String, String> classStudents = new HashMap<>();
    public static JComboBox<String> classesDisplay;

    public Vector<String> storedClasses;

    Vector<String> addedClasses = new Vector<>();
    Vector<String> Students = new Vector<>();


    public ClassManagement() {



        File classStudentsFile = new File("classStudents.dat");

        try {
            classStudentsFile.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }

        //Stores addedClasses to File
        try (ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream("addedClasses.dat"))) {
            fileWriter.writeObject(addedClasses);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reads from addedClasses File
        storedClasses = new Vector<>();
        try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("addedClasses.dat"))) {
            storedClasses = (Vector<String>) fileReader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("classStudents.dat"))) {
            classStudents = (HashMap<String, String>) fileReader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            classStudents = new HashMap<String, String>();
            e.printStackTrace();
        }

        //24 - 44 sets layout and adds buttons to GUI
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int) (screen.getWidth() * 0.9);
        int height = (int) (screen.getHeight() * 0.9);

        //JPanel ClassManagementPanel = new JPanel();
        //ClassManagementPanel.setBounds(0,0,(int)width,(int)height);
        //ClassManagementPanel.setVisible(true);

        setTitle("Class Master");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.setLayout(null);

        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setBounds((int) (width * 0), (int) (0), (int) (width * 1), (int) (0.2 * height));
        this.add(comboBoxPanel);

        JButton addClass = new JButton("add Class");
        addClass.setBounds((int) (width * 0.85), (int) (0.02 * height), (int) (width * 0.075), (int) (0.05 * height));
        this.add(addClass);
        addClass.setVisible(true);

        JButton exit = new JButton("Exit");
        exit.setBounds((int) (width * 0.02), (int) (0.02 * height), (int) (width * 0.05), (int) (0.02 * height));
        this.add(exit);
        exit.setVisible(true);

        JButton addStudent = new JButton();
        addStudent.setBounds((int) (width * 0.02), (int) (0.85 * height), (int) (width * 0.1), (int) (0.05 * height));
        this.add(addStudent);
        addStudent.setVisible(true);

        JComboBox classesDisplay = new JComboBox<>(storedClasses);
        classesDisplay.setBounds((int) (width * 0.1), (int) (0.02 * height), (int) (width * 0.7), (int) (0.05 * height));
        this.add(classesDisplay);

        classesDisplay = new JComboBox(classStudents.keySet().toArray(new String[0]));
        classesDisplay.setBounds((int) (width * 0.1), (int) (0.02 * height), (int) (width * 0.7), (int) (0.05 * height));
        this.add(classesDisplay);

        exit.addActionListener(e -> {
            new Home();
            setVisible(false);
            dispose();
        });

        comboBoxPanel.add(classesDisplay);

        JComboBox finalClassesDisplay2 = classesDisplay;
        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = JOptionPane.showInputDialog("write the name of the student");
                Students.add(userInput);
                classStudents.put(userInput, Objects.requireNonNull(ClassManagement.classesDisplay.getSelectedItem()).toString());
                try (ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream("classStudents.dat"))) {
                    fileWriter.writeObject(userInput);
                } catch (IOException k) {
                    k.printStackTrace();
                }

            }
        });

        Vector<String> finalStoredClasses = storedClasses;
        addClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String className = JOptionPane.showInputDialog("Enter the name of the school class:");
                // Add the input to the vector
                if (className != null && !className.isEmpty()) {
                    addedClasses.add(className);
                    // Update the JComboBox with the new items

                }
                updateClassComboBox();
            }
        });


        JComboBox finalClassesDisplay = classesDisplay;
        classesDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClass = (String) finalClassesDisplay.getSelectedItem();
                displayStudentsInTable(selectedClass);
            }
        });
    }

    private void displayStudentsInTable(String className) {

        Object[][] data;
        data = new Object[1][Students.size()];
        String[] columnNames = {"Students"};
        int counter = -1;
        for (String student : Students) {
            counter += 1;
            data[0][counter] = student;
        }
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("Student Information");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setVisible(true);

    }

    public void updateClassComboBox()
    {
        classesDisplay.removeAllItems();

        for (String i : storedClasses)
        {
            classesDisplay.addItem(i);
        }
    }

}
class ClassMangementMain
{
    public static void main(String[] args)
    {
        new ClassManagement();
    }
}



 */
