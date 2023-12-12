import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame{
    public Home(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        double widthd = screen.getWidth() * 0.9;
        double heightd = screen.getHeight() * 0.9;

        int width = (int)widthd;
        int height = (int)heightd;

        setTitle("Class Master");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel HS = new JPanel();
        HS.setBounds(0,0,(int)widthd,(int)heightd);
        this.add(HS);

        JButton attendance = new JButton("Attendance");
        JButton LogOut = new JButton("Log Out");
        JButton Grades = new JButton("Grades");
        JButton CA = new JButton("Class \nActivity");
        JButton CM = new JButton("Class Management");

        attendance.setBounds((int)(0.15 * widthd), (int)(0.1 * heightd), (int)( 0.2* widthd), (int)(0.2 * heightd));
        Grades.setBounds((int)(0.40 * widthd), (int)(0.1 * heightd), (int)( 0.2* widthd), (int)(0.2 * heightd));
        LogOut.setBounds((int)(0.05 * widthd), (int)(0.9 * heightd), (int)(0.9 * widthd), (int)(0.05 * heightd));
        CA.setBounds((int)(0.65 * widthd), (int)(0.1 * heightd), (int)( 0.2* widthd), (int)(0.2 * heightd));
        CM.setBounds((int)(0.2 * widthd), (int)(0.35 * heightd), (int)(0.6 * width),(int) (0.1 * heightd));

        attendance.setVisible(true);
        LogOut.setVisible(true);
        Grades.setVisible(true);
        CA.setVisible(true);
        CM.setVisible(true);


        this.add(attendance);
        this.add(LogOut);
        this.add(Grades);
        this.add(CA);
        this.add(CM);

        this.setLayout(null);

        attendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Attendance();
                setVisible(false);
                dispose();

            }
        });

        Grades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new cgrades();
                setVisible(false);
                dispose();
            }
        });

        CA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClassActivity();
                setVisible(false);
                dispose();
            }
        });

        CM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClassManagement();
                setVisible(false);
                dispose();
            }
        });

        LogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Log_in();
                setVisible(false);
                dispose();
            }
        });


    }
    public static void main(String[] args) {
        new Home();
    }
}
