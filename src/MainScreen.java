import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainScreen extends JFrame {
    private JPanel mainPanel;
    private JButton logOutButton;
    private JButton addStudentButton;
    private JButton showAllStudentsButton;
    private JLabel icon;
    private JButton showAllStudentsGradesButton;
    private JButton publishGradesButton;
    private JButton showYourAccountDetailsButton;
    private JButton showYourGradesButton;

    MainScreen() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add Students Button onclick listener
        addStudentButton.addActionListener(e -> {
            new AddEditStudentDetails();
        });

        showAllStudentsButton.addActionListener(e -> {
            new ShowAllStudents();
        });

        // Log Out Button onclick listener
        logOutButton.addActionListener(e -> {
            // Get User Credential file
            File userDetails = new File("user.txt");
            // if File Exits delete it and logout else just logout
            if (userDetails.exists()) {
                if (userDetails.delete()) {
                    dispose();
                    new LoginScreen();
                }
            } else {
                dispose();
                new LoginScreen();
            }
        });

        // Set IIITK Logo
        try {
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("assets/logo.png").getImage().getScaledInstance(130, 150, Image.SCALE_SMOOTH));
            icon.setIcon(imageIcon);
            icon.setMaximumSize(new Dimension(1, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setTitle("SDMS");
        setIconImage(new ImageIcon("assets/logo.png").getImage());
        setVisible(true);
    }
}
