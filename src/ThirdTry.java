import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
//checking changes
public class ThirdTry extends JFrame {

    public ThirdTry() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        JPanel classMangagentPanel = new JPanel();

        String[][] studentsAndClasses = new String[5][15];

        File classStudentsFile = new File("classStudents.dat");

        try {
            classStudentsFile.createNewFile();
        } catch (IOException noie){
            noie.printStackTrace();
        }

        int width = (int) (screen.getWidth() * 0.9);
        int height = (int) (screen.getHeight() * 0.9);

        this.add(classMangagentPanel);
        classMangagentPanel.setBounds(0,0, height,width);


        setTitle("Class Master");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        classMangagentPanel.setLayout(null);


        JButton addClass = new JButton("add Class");
        addClass.setBounds((int) (width * 0.85), (int) (0.02 * height), (int) (width * 0.075), (int) (0.05 * height));
        addClass.setVisible(false);

        JButton exit = new JButton("Exit");
        exit.setBounds((int) (width * 0.02), (int) (0.02 * height), (int) (width * 0.05), (int) (0.02 * height));
        classMangagentPanel.add(exit);
        exit.setVisible(true);

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
                classOnePanel.setBounds(0,0, width,height);
                classOnePanel.setVisible(true);
                classOnePanel.setLayout(null);

                JButton addStudent = new JButton("Add Student");
                addStudent.setBounds((int) (width * 0.8), (int) (0.1 * height), (int) (width * 0.1), (int) (0.05 * height));
                addStudent.setVisible(true);
                classOnePanel.add(addStudent);

                JButton removeStudent = new JButton("Remove Student");
                removeStudent.setBounds((int) (width * 0.8), (int) (0.2 * height), (int) (width * 0.1), (int) (0.05 * height));
                removeStudent.setVisible(true);
                classOnePanel.add(removeStudent);

                JButton exit2 = new JButton("Exit");
                classOnePanel.add(exit2);
                exit2.setVisible(true);
                exit2.setBounds((int) (width * 0.9), (int) (0.9 * height), (int) (width * 0.05), (int) (0.02 * height));

                JList studentsList = new JList();
                JScrollPane studentsScroll = new JScrollPane(studentsList);
                studentsScroll.setBounds((int) (width * 0.25), (int) (0.3 * height), (int) (width * 0.5), (int) (0.5 * height));
                classOnePanel.add(studentsScroll);

                try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("classStudents.dat"))) {
                    String [][] studentsAndClasses = (String[][]) fileReader.readObject();
                    studentsList.setListData(studentsAndClasses[0]);


                } catch (IOException ioe2){
                    ioe2.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }





                addStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("classStudents.dat"))) {
                            String [][] studentsAndClasses = (String[][]) fileReader.readObject();

                            String UsetInput = JOptionPane.showInputDialog(null,"Enter the Name of The Student");
                            for (int i = 0; i < 15; i++) {
                                if (studentsAndClasses[0][i] != null){
                                    continue;
                                }
                                else {
                                    studentsAndClasses[0][i] = UsetInput;
                                    for (int j = 0; j < 15; j++) {
                                        System.out.println(studentsAndClasses [0][j]);
                                    }
                                    break;

                                }
                            }
                            studentsList.setListData(studentsAndClasses[0]);

                            try (ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream("classStudents.dat"))) {
                                fileWriter.writeObject(studentsAndClasses);
                            } catch (IOException ioe) {
                                ioe.printStackTrace();
                            }

                        } catch (IOException ioe2){
                            ioe2.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }



                    }
                });

                removeStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("classStudents.dat"))) {
                            String [][] studentsAndClasses = (String[][]) fileReader.readObject();

                            int studentRemover = Integer.parseInt((JOptionPane.showInputDialog("Enter the Number of Student")) ) - 1;
                            if (studentsAndClasses[0][studentRemover] != null) {
                                studentsAndClasses[0][studentRemover] = null;
                            } else {
                                JOptionPane.showMessageDialog(classOnePanel, "invalid student number, please enter the number you assigned to the student");
                            }
                            studentsList.setListData(studentsAndClasses[0]);

                            try (ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream("classStudents.dat"))) {
                                fileWriter.writeObject(studentsAndClasses);
                            } catch (IOException ioe) {
                                ioe.printStackTrace();
                            }

                        } catch (IOException ioe2){
                            ioe2.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }


                    }
                });




                exit2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new ThirdTry();
                        classOneFrame.setVisible(false);
                    }
                });

            }


        });




        exit.addActionListener(e -> {
            new Home();
            setVisible(false);
        });
    }
}
