import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ThirdTry extends JFrame {

    public ThirdTry() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        JPanel classMangagentPanel = new JPanel();

        String [][] studentsAndClasses = new String[5][15];

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

                try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("classStudents.dat"))) {
                    String [][] studentsAndClassesTemp = (String[][]) fileReader.readObject();

                } catch (IOException ioe2){
                    ioe2.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

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

                JButton updateFrame = new JButton("Update Window");
                updateFrame.setVisible(true);
                updateFrame.setBounds((int) (width * 0.1), (int) (0.1 * height), (int) (width * 0.1), (int) (0.05 * height));
                classOnePanel.add(updateFrame);

                JButton exit2 = new JButton("Exit");
                classOnePanel.add(exit2);
                exit2.setVisible(true);
                exit2.setBounds((int) (width * 0.9), (int) (0.9 * height), (int) (width * 0.05), (int) (0.02 * height));

                JButton sava = new JButton("Save Changes");
                classOnePanel.add(sava);
                sava.setVisible(true);
                sava.setBounds((int) (width * 0.1), (int) (0.2 * height), (int) (width * 0.1), (int) (0.05 * height));

                JList studentsList = new JList();
                JScrollPane studentsScroll = new JScrollPane(studentsList);
                studentsScroll.setBounds((int) (width * 0.25), (int) (0.3 * height), (int) (width * 0.5), (int) (0.5 * height));
                classOnePanel.add(studentsScroll);


                addStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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

                    }
                });

                removeStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int studentRemover = Integer.parseInt((JOptionPane.showInputDialog("Enter the Number of Student")) ) - 1;
                        if (studentsAndClasses != null) {
                            studentsAndClasses[0][studentRemover] = null;
                        }
                    }
                });

                sava.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        File classStudentsFile = new File("classStudents.dat");

                        try {
                            classStudentsFile.createNewFile();
                        } catch (IOException noie){
                            noie.printStackTrace();
                        }

                        //Stores addedClasses to File
                        try (ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream("classStudents.dat"))) {
                            fileWriter.writeObject(studentsAndClasses);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                });

                updateFrame.addActionListener(e1 -> {



                    try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("classStudents.dat"))) {
                        String [][] studentsAndClassesTemp = (String[][]) fileReader.readObject();
                        studentsList.setListData(studentsAndClassesTemp[0]);

                    } catch (IOException ioe2){
                        ioe2.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
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

        ClassTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

                JButton updateFrame = new JButton("Update Window");
                updateFrame.setVisible(true);
                updateFrame.setBounds((int) (width * 0.1), (int) (0.1 * height), (int) (width * 0.1), (int) (0.05 * height));
                classOnePanel.add(updateFrame);

                JButton exit2 = new JButton("Exit");
                classOnePanel.add(exit2);
                exit2.setVisible(true);
                exit2.setBounds((int) (width * 0.9), (int) (0.9 * height), (int) (width * 0.05), (int) (0.02 * height));

                JButton sava = new JButton("Save Changes");
                classOnePanel.add(sava);
                sava.setVisible(true);
                sava.setBounds((int) (width * 0.1), (int) (0.2 * height), (int) (width * 0.1), (int) (0.05 * height));

                JList studentsList = new JList();
                JScrollPane studentsScroll = new JScrollPane(studentsList);
                studentsScroll.setBounds((int) (width * 0.25), (int) (0.3 * height), (int) (width * 0.5), (int) (0.5 * height));
                classOnePanel.add(studentsScroll);


                addStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String UsetInput = JOptionPane.showInputDialog(null,"Enter the Name of The Student");
                        for (int i = 0; i < 15; i++) {
                            if (studentsAndClasses[1][i] != null){
                                continue;
                            }
                            else {
                                studentsAndClasses[1][i] = UsetInput;
                                for (int j = 0; j < 15; j++) {
                                    System.out.println(studentsAndClasses [1][j]);
                                }
                                break;

                            }
                        }

                    }
                });

                removeStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int studentRemover = Integer.parseInt((JOptionPane.showInputDialog("Enter the Number of Student")) ) - 1;
                        if (studentsAndClasses != null) {
                            studentsAndClasses[1][studentRemover] = null;
                        }
                    }
                });

                sava.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        File classStudentsFile = new File("classStudents.dat");

                        try {
                            classStudentsFile.createNewFile();
                        } catch (IOException noie){
                            noie.printStackTrace();
                        }

                        //Stores addedClasses to File
                        try (ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream("classStudents.dat"))) {
                            fileWriter.writeObject(studentsAndClasses);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                });

                updateFrame.addActionListener(e1 -> {



                    try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("classStudents.dat"))) {
                        String [][] studentsAndClassesTemp = (String[][]) fileReader.readObject();
                        studentsList.setListData(studentsAndClassesTemp[1]);

                    } catch (IOException ioe2){
                        ioe2.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
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

        ClassThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

                JButton updateFrame = new JButton("Update Window");
                updateFrame.setVisible(true);
                updateFrame.setBounds((int) (width * 0.1), (int) (0.1 * height), (int) (width * 0.1), (int) (0.05 * height));
                classOnePanel.add(updateFrame);

                JButton exit2 = new JButton("Exit");
                classOnePanel.add(exit2);
                exit2.setVisible(true);
                exit2.setBounds((int) (width * 0.9), (int) (0.9 * height), (int) (width * 0.05), (int) (0.02 * height));

                JButton sava = new JButton("Save Changes");
                classOnePanel.add(sava);
                sava.setVisible(true);
                sava.setBounds((int) (width * 0.1), (int) (0.2 * height), (int) (width * 0.1), (int) (0.05 * height));

                JList studentsList = new JList();
                JScrollPane studentsScroll = new JScrollPane(studentsList);
                studentsScroll.setBounds((int) (width * 0.25), (int) (0.3 * height), (int) (width * 0.5), (int) (0.5 * height));
                classOnePanel.add(studentsScroll);


                addStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String UsetInput = JOptionPane.showInputDialog(null,"Enter the Name of The Student");
                        for (int i = 0; i < 15; i++) {
                            if (studentsAndClasses[2][i] != null){
                                continue;
                            }
                            else {
                                studentsAndClasses[2][i] = UsetInput;
                                for (int j = 0; j < 15; j++) {
                                    System.out.println(studentsAndClasses [2][j]);
                                }
                                break;

                            }
                        }

                    }
                });

                removeStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int studentRemover = Integer.parseInt((JOptionPane.showInputDialog("Enter the Number of Student")) ) - 1;
                        studentsAndClasses[2][studentRemover] = null;
                    }
                });

                sava.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        File classStudentsFile = new File("classStudents.dat");

                        try {
                            classStudentsFile.createNewFile();
                        } catch (IOException noie){
                            noie.printStackTrace();
                        }

                        //Stores addedClasses to File
                        try (ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream("classStudents.dat"))) {
                            fileWriter.writeObject(studentsAndClasses);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                });

                updateFrame.addActionListener(e1 -> {



                    try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("classStudents.dat"))) {
                        String [][] studentsAndClassesTemp = (String[][]) fileReader.readObject();
                        studentsList.setListData(studentsAndClassesTemp[2]);

                    } catch (IOException ioe2){
                        ioe2.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
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

        ClassFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

                JButton updateFrame = new JButton("Update Window");
                updateFrame.setVisible(true);
                updateFrame.setBounds((int) (width * 0.1), (int) (0.1 * height), (int) (width * 0.1), (int) (0.05 * height));
                classOnePanel.add(updateFrame);

                JButton exit2 = new JButton("Exit");
                classOnePanel.add(exit2);
                exit2.setVisible(true);
                exit2.setBounds((int) (width * 0.9), (int) (0.9 * height), (int) (width * 0.05), (int) (0.02 * height));

                JButton sava = new JButton("Save Changes");
                classOnePanel.add(sava);
                sava.setVisible(true);
                sava.setBounds((int) (width * 0.1), (int) (0.2 * height), (int) (width * 0.1), (int) (0.05 * height));

                JList studentsList = new JList();
                JScrollPane studentsScroll = new JScrollPane(studentsList);
                studentsScroll.setBounds((int) (width * 0.25), (int) (0.3 * height), (int) (width * 0.5), (int) (0.5 * height));
                classOnePanel.add(studentsScroll);


                addStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String UsetInput = JOptionPane.showInputDialog(null,"Enter the Name of The Student");
                        for (int i = 0; i < 15; i++) {
                            if (studentsAndClasses[3][i] != null){
                                continue;
                            }
                            else {
                                studentsAndClasses[3][i] = UsetInput;
                                for (int j = 0; j < 15; j++) {
                                    System.out.println(studentsAndClasses [3][j]);
                                }
                                break;

                            }
                        }

                    }
                });

                removeStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int studentRemover = Integer.parseInt((JOptionPane.showInputDialog("Enter the Number of Student")) ) - 1;
                        studentsAndClasses[3][studentRemover] = null;
                    }
                });

                sava.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        File classStudentsFile = new File("classStudents.dat");

                        try {
                            classStudentsFile.createNewFile();
                        } catch (IOException noie){
                            noie.printStackTrace();
                        }

                        //Stores addedClasses to File
                        try (ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream("classStudents.dat"))) {
                            fileWriter.writeObject(studentsAndClasses);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                });

                updateFrame.addActionListener(e1 -> {



                    try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("classStudents.dat"))) {
                        String [][] studentsAndClassesTemp = (String[][]) fileReader.readObject();
                        studentsList.setListData(studentsAndClassesTemp[3]);

                    } catch (IOException ioe2){
                        ioe2.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
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

        ClassFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

                JButton updateFrame = new JButton("Update Window");
                updateFrame.setVisible(true);
                updateFrame.setBounds((int) (width * 0.1), (int) (0.1 * height), (int) (width * 0.1), (int) (0.05 * height));
                classOnePanel.add(updateFrame);

                JButton exit2 = new JButton("Exit");
                classOnePanel.add(exit2);
                exit2.setVisible(true);
                exit2.setBounds((int) (width * 0.9), (int) (0.9 * height), (int) (width * 0.05), (int) (0.02 * height));

                JButton sava = new JButton("Save Changes");
                classOnePanel.add(sava);
                sava.setVisible(true);
                sava.setBounds((int) (width * 0.1), (int) (0.2 * height), (int) (width * 0.1), (int) (0.05 * height));

                JList studentsList = new JList();
                JScrollPane studentsScroll = new JScrollPane(studentsList);
                studentsScroll.setBounds((int) (width * 0.25), (int) (0.3 * height), (int) (width * 0.5), (int) (0.5 * height));
                classOnePanel.add(studentsScroll);


                addStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String UsetInput = JOptionPane.showInputDialog(null,"Enter the Name of The Student");
                        for (int i = 0; i < 15; i++) {
                            if (studentsAndClasses[4][i] != null){
                                continue;
                            }
                            else {
                                studentsAndClasses[4][i] = UsetInput;
                                for (int j = 0; j < 15; j++) {
                                    System.out.println(studentsAndClasses [4][j]);
                                }
                                break;

                            }
                        }

                    }
                });

                removeStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int studentRemover = Integer.parseInt((JOptionPane.showInputDialog("Enter the Number of Student")) ) - 1;
                        studentsAndClasses[4][studentRemover] = null;
                    }
                });

                sava.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        File classStudentsFile = new File("classStudents.dat");

                        try {
                            classStudentsFile.createNewFile();
                        } catch (IOException noie){
                            noie.printStackTrace();
                        }

                        //Stores addedClasses to File
                        try (ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream("classStudents.dat"))) {
                            fileWriter.writeObject(studentsAndClasses);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                });

                updateFrame.addActionListener(e1 -> {



                    try (ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream("classStudents.dat"))) {
                        String [][] studentsAndClassesTemp = (String[][]) fileReader.readObject();
                        studentsList.setListData(studentsAndClassesTemp[4]);

                    } catch (IOException ioe2){
                        ioe2.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
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
