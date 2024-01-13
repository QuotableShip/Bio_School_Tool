import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import java.util.*;

public class ClassManagementNoFileHandling extends JFrame {
    private Map<String, ArrayList<String>> classStudents = new HashMap<>();
    public static JComboBox<String> classesDisplay;

    JTable studentsTable;
    public ArrayList<String> storedClasses;

    ArrayList<String> addedClasses = new ArrayList<>();
    ArrayList<String> Students = new ArrayList<>();



    public ClassManagementNoFileHandling() {Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Students.add("123");
        Students.add("124");
        Students.add("125");
        int width = (int) (screen.getWidth() * 0.9);
        int height = (int) (screen.getHeight() * 0.9);

        this.setLayout(new BorderLayout());


        JPanel ClassManagementPanel = new JPanel();
        ClassManagementPanel.setVisible(true);
        this.add(ClassManagementPanel, BorderLayout.SOUTH);

        setTitle("Class Master");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel addClassPanel = new JPanel();
        this.add(addClassPanel, BorderLayout.EAST);


        JButton addClass = new JButton("add Class");
        //addClass.setBounds((int) (width * 0.85), (int) (0.02 * height), (int) (width * 0.075), (int) (0.05 * height));
        addClassPanel.add(addClass);
        addClass.setVisible(true);

        JButton exit = new JButton("Exit");
        //exit.setBounds((int) (width * 0.02), (int) (0.02 * height), (int) (width * 0.05), (int) (0.02 * height));
        this.add(exit);
        exit.setVisible(true);

        JPanel addStudentPanel = new JPanel();
        this.add(addStudentPanel, BorderLayout.WEST);
        JButton addStudent = new JButton("Add Student");
        //addStudent.setBounds((int) (width * 0.02), (int) (0.85 * height), (int) (width * 0.1), (int) (0.05 * height));
        addStudentPanel.add(addStudent);
        addStudent.setVisible(true);

        ClassManagementPanel.add(exit);

        classesDisplay = new JComboBox<>();
        JPanel comboBoxPanel = new JPanel();
        //comboBoxPanel.setBounds((int) (width * 0), (int) (0), (int) (width * 1), (int) (0.2 * height));
        this.add(comboBoxPanel, BorderLayout.NORTH);
        comboBoxPanel.add(classesDisplay);

        exit.addActionListener(e -> {
            new Home();
            setVisible(false);
            dispose();
        });

        //comboBoxPanel.add(classesDisplay);




        addClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String className = JOptionPane.showInputDialog("Enter the name of the school class:");
                // Add the input to the vector
                if (className != null && !className.isEmpty()){
                    addedClasses.add(className);
                }
                updateClassComboBox();
            }
        });
        classesDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClass = (String) classesDisplay.getSelectedItem();
                displayStudentsInTable(selectedClass);
                //updateClassComboBox();
            }
        });
        JPanel centrePanel = new JPanel();
        centrePanel.add(new JLabel("infinwginin"));
        JScrollPane studentsTableScroll = new JScrollPane();
        this.add(studentsTableScroll, BorderLayout.CENTER);
        studentsTableScroll.setViewportView(centrePanel);
        for (String student : Students) {
            JPanel newPanel = new JPanel();
            JLabel studentLbl = new JLabel();
            studentLbl.setText(student);
            newPanel.add(studentLbl);
            centrePanel.add(newPanel);
        }

        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = JOptionPane.showInputDialog("write the name of the student");
                Students.add(userInput);
                classStudents.get(classesDisplay.getSelectedItem().toString()).add(userInput);
                JPanel newPanel = new JPanel();
                JLabel studentLbl = new JLabel();
                studentLbl.setText(userInput);
                newPanel.add(studentLbl);
                centrePanel.add(newPanel);
                studentsTableScroll.repaint();
            }
        });


    }

    private void displayStudentsInTable(String className) {


        Object[][] studentsData;
        studentsData = new Object[1][Students.size()];
        String[] columnStudents = {"Students"};
        int counter = -1;
        for (String student : Students){
            counter += 1;
            studentsData[0][counter] = student;
        }
        System.out.println(studentsData);
        JPanel studentTablePanel = new JPanel();
        //studentsTableScroll = new JScrollPane(studentsTable);
        studentsTable = new JTable(studentsData, columnStudents);
        DefaultTableModel studentsTableModel = new DefaultTableModel();
        studentsTableModel.addColumn(Students);
        studentTablePanel.setLayout(new BorderLayout());
        //studentTablePanel.add(studentsTableScroll, BorderLayout.CENTER);
        //this.add(studentTablePanel, BorderLayout.CENTER);
    }



    public void updateClassComboBox()
    {
        classesDisplay.removeAllItems();
        for (String i : addedClasses){
            classesDisplay.addItem(i);
        }
    }
}

class ClassManagementNoFileHandlingMain
{
    public static void main(String[] args)
    {
        new ClassManagementNoFileHandling();
    }
}



