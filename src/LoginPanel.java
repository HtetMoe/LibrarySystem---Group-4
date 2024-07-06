import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private LibraryManagementUI mainFrame;

    public LoginPanel(LibraryManagementUI mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(Box.createVerticalStrut(20), BorderLayout.NORTH); // Add space above the title

        JLabel titleLabel = new JLabel("Library Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        titlePanel.add(Box.createVerticalStrut(20), BorderLayout.SOUTH); // Add space below the title
        add(titlePanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(25); // Increased width for the username field

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(25); // Adjusted width to match the username field

        JButton loginButton = new JButton("LOGIN");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleLogin(); // handle login function
            }
        });

        JButton cancelButton = new JButton("CLEAR");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //clear
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        centerPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);
        centerPanel.add(buttonPanel, gbc);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void handleLogin() {
        //user input
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        //process login
        Person person = Person.login(username, password);
        System.out.println(STR."Login Success -> \{person}");

        if (person != null) {
            int response = JOptionPane.showConfirmDialog(null,
                    STR."Successfully Login. Role : \{person.getRole().getClass().getSimpleName()}",
                    "Login Success",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);

            // Check if OK button was clicked
            if (response == JOptionPane.OK_OPTION) {

                //clear
//                usernameField.setText("");
//                passwordField.setText("");

                Role role = person.getRole();
                if (role instanceof Administrator)
                    mainFrame.showAdminPanel();
                else if (role instanceof Librarian)
                    mainFrame.showLibrarianPanel();
                else if (role instanceof Member)
                    mainFrame.showMemberPanel();
            }
        } else // show alert
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password.",
                    "Invalid Credentials!", JOptionPane.INFORMATION_MESSAGE);
    }
}
