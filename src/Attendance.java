import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Attendance extends JFrame {
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


        String arr[] = {"adfs","sfsdf","ffsdf","gfsd","sdfdfh"};

        JComboBox dates = new JComboBox(arr);
        dates.setBounds((int)((width * 0.5) - (width * 0.25)), (int) (height * 0.05), (int)(width * 0.5), (int)(height * 0.05));
        this.add(dates);
        dates.setVisible(true);
    }
   public static void main(String[] args) {
        new Attendance();
    }
}
