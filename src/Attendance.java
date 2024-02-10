import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Attendance extends JFrame {

    public Attendance(){

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        JPanel classMangagentPanel = new JPanel();

        HashMap<String, Boolean> studentsMap = new HashMap<>();


        int width = (int)(screen.getWidth() * 0.9);
        int height = (int)(screen.getHeight() * 0.9);

        this.add(classMangagentPanel);
        classMangagentPanel.setBounds(0,0, height,width);

        setTitle("Class Master");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        this.setLayout(null);

        JButton exit = new JButton("Exit");
        exit.setBounds((int)(width*0.02),(int)(0.02*height), (int)(width*0.05), (int)(0.02*height));
        classMangagentPanel.add(exit);
        exit.setVisible(true);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                setVisible(false);
                dispose();
            }
        });

        JButton ClassOne = new JButton("Class 1");
        classMangagentPanel.add(ClassOne);
        ClassOne.setBounds((int) (width * 0.2), (int) (0.3 * height), (int) (width * 0.15), (int) (0.1 * height));
        ClassOne.setVisible(true);

        JButton ClassTwo = new JButton("Class 2");
        classMangagentPanel.add(ClassTwo);
        ClassTwo.setBounds((int) (width * 0.4), (int) (0.3 * height), (int) (width * 0.15), (int) (0.1 * height));
        ClassTwo.setVisible(true);

        JButton ClassThree = new JButton("Class 3");
        classMangagentPanel.add(ClassThree);
        ClassThree.setBounds((int) (width * 0.6), (int) (0.3 * height), (int) (width * 0.15), (int) (0.1 * height));
        ClassThree.setVisible(true);

        JButton ClassFour = new JButton("Class 4");
        classMangagentPanel.add(ClassFour);
        ClassFour.setBounds((int) (width * 0.3), (int) (0.5 * height), (int) (width * 0.15), (int) (0.1 * height));
        ClassFour.setVisible(true);

        JButton ClassFive = new JButton("Class 5");
        classMangagentPanel.add(ClassFive);
        ClassFive.setBounds((int) (width * 0.5), (int) (0.5 * height), (int) (width * 0.15), (int) (0.1 * height));
        ClassFive.setVisible(true);

        ClassOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                setVisible(false);
                dispose();



                JFrame classOneFrame = new JFrame();
                classOneFrame.setTitle("Class Master");
                classOneFrame.setSize(width, height);
                classOneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                classOneFrame.setLocationRelativeTo(null);
                classOneFrame.setVisible(true);
                classOneFrame.setLayout(null);

                JPanel classOnePanel = new JPanel();
                classOneFrame.add(classOnePanel);
                classOnePanel.setBounds(0, 0, width, height);
                classOnePanel.setVisible(true);
                classOnePanel.setLayout(null);



                JButton exit2 = new JButton("Exit");
                classOnePanel.add(exit2);
                exit2.setVisible(true);
                exit2.setBounds((int) (width * 0.9), (int) (0.9 * height), (int) (width * 0.05), (int) (0.02 * height));

                String [][] studentsAndClasses = new String[5][15];



                try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("classStudents.dat"))) {
                    studentsAndClasses = (String[][]) fileReader.readObject();
                    

                } catch (IOException ioe2){
                    ioe2.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                JComboBox<String> studentsList = new JComboBox();
                JScrollPane studentsScroll = new JScrollPane(studentsList);
                studentsScroll.setBounds((int) (width * 0.25), (int) (0.3 * height), (int) (width * 0.5), (int) (0.2 * height));
                classOnePanel.add(studentsScroll);



                for (int i = 0; i < 15; i++) {
                    studentsList.addItem(studentsAndClasses[0][i]);
                }
                studentsList.repaint();

                studentsList.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    int option = JOptionPane.showConfirmDialog(classOneFrame, "is the student present?");
                    }
                });

                MouseListener mouseListener = new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {


                            //String selectedItem = (String) studentsList.getSelectedItem();
                            String UserInput = JOptionPane.showInputDialog(null,"Enter the current date in DD.MM.YYYY format");



                        }
                    }
                };

                exit2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Home();
                        classOneFrame.setVisible(false);
                    }
                });



            }
            });






    }

   public static void main(String[] args) {
        new Attendance();
    }
}



