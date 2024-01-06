import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

public class ClassManagement extends JFrame {
    private Map<String, Vector<Student>> classStudents = new HashMap<>();
    private JComboBox<String> classesDisplay;

    public ClassManagement() {


        //list of Classes
        Vector<String> addedClasses = new Vector<>();

        //Stores addedClasses to File
        try (ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream("addedClasses.dat"))) {
            fileWriter.writeObject(addedClasses);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reads from addedClasses File
        Vector<String> storedClasses = new Vector<>();
        try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("addedClasses.dat"))) {
            storedClasses = (Vector<String>) fileReader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("classStudents.dat"))) {
            classStudents = (Map<String, Vector<Student>>) fileReader.readObject();
        } catch (IOException | ClassNotFoundException e) {
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

        classesDisplay = new JComboBox(classStudents.keySet().toArray(new String[0]));
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

        JComboBox finalClassesDisplay1 = classesDisplay;
        Vector<String> finalStoredClasses = storedClasses;
        addClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String className = JOptionPane.showInputDialog("Enter the name of the school class:");
                // Add the input to the vector
                if (className != null && !className.isEmpty()) {
                    addedClasses.add(className);
                    // Update the JComboBox with the new items
                    finalClassesDisplay1.setModel(new DefaultComboBoxModel<>(finalStoredClasses));
                }
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
        Vector<Student> students = classStudents.get(className);
        if (students != null) {
            String[] columnNames = {"Name", "Age", "DOB", "Surname"};
            Object[][] data = new Object[students.size()][4];
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                data[i][0] = student.getName();
                data[i][1] = student.getAge();
                data[i][2] = student.getDateOfBirth();
                data[i][3] = student.getSurname();
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
            // Display the table in your GUI as per your layout

        }

    }
    public static void main (String[] args){
        new ClassManagement();
    }
}
class Student implements Serializable {
    private String name;
    private int age;
    private String dateOfBirth;
    private String surname;

    public Student(String name, int age, String dateOfBirth, String surname) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.surname = surname;
    }

    // Getters and Setters for the attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
