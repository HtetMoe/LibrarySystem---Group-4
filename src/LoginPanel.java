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

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                Person person = Person.login(username,password);
                if(person == null){
                    JOptionPane.showMessageDialog(null, "Please enter  id and password correctly",
                            "INFOR", JOptionPane.INFORMATION_MESSAGE);

                }else{
                    Role role = person.getRole();
                    System.out.println(role);
                    if (role instanceof Administrator){
                        mainFrame.showAdminPanel();
                    }else if (role instanceof Librarian){
                        mainFrame.showLibrarianPanel();
                    }else if(role instanceof Member){
                        mainFrame.showMemberPanel();
                    }
                }
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add action for cancel button if needed
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

//    private void handleLogin() {
//        String username = usernameField.getText();
//        String password = new String(passwordField.getPassword());
//
//        Person.login(username,password);
//        if (username.equals("admin")) {
//            mainFrame.showAdminPanel();
//        } else if (username.equals("librarian")) {
//            mainFrame.showLibrarianPanel();
//        } else if (username.equals("member")) {
//            mainFrame.showMemberPanel();
//        } else {
//            JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
}
