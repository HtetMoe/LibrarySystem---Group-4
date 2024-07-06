import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MemberPanel extends JPanel {
    private DataAccessFacade dataAccess;
    private LibraryManagementUI mainFrame;

    public MemberPanel(DataAccessFacade dataAccess, LibraryManagementUI mainFrame) {
        this.dataAccess = dataAccess;
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Member Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JButton checkAvailabilityButton = new JButton("Check Availability");
        JButton checkOutBookButton = new JButton("Check Out Book");
        JButton logoutButton = new JButton("Logout");

        Dimension buttonSize = new Dimension(150, 40);
        checkAvailabilityButton.setPreferredSize(buttonSize);
        checkOutBookButton.setPreferredSize(buttonSize);
        logoutButton.setPreferredSize(buttonSize);

        checkAvailabilityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCheckAvailabilityPanel();
            }
        });

        checkOutBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCheckOutPanel();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showLoginPanel();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(checkAvailabilityButton);
        buttonPanel.add(checkOutBookButton);
        buttonPanel.add(logoutButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void showCheckAvailabilityPanel() {
        JPanel checkAvailabilityPanel = new JPanel();
        checkAvailabilityPanel.setLayout(new GridBagLayout());
        checkAvailabilityPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between components

        JLabel isbnLabel = new JLabel("ISBN:");
        JTextField isbnField = new JTextField(15); // Set the width of the text field

        JButton checkButton = new JButton("Check");
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = isbnField.getText();
                boolean available = Member.checkAvailability(isbn); // Call the method from Member class
                if (available){
                    JOptionPane.showMessageDialog(MemberPanel.this,"Book is available!" );
                }else {
                    JOptionPane.showMessageDialog(MemberPanel.this, "Book is not available.");
                }

            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Window window = SwingUtilities.getWindowAncestor(checkAvailabilityPanel);
                if (window != null) {
                    window.dispose();
                }
            }
        });

        // Add components to the checkAvailabilityPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        checkAvailabilityPanel.add(isbnLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        checkAvailabilityPanel.add(isbnField, gbc);

        // Add a panel for buttons to center them
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(checkButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        checkAvailabilityPanel.add(buttonPanel, gbc);

        JFrame frame = new JFrame("Check Availability");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints frameGbc = new GridBagConstraints();
        frameGbc.gridx = 0;
        frameGbc.gridy = 0;
        frameGbc.insets = new Insets(10, 10, 10, 10);
        frame.add(checkAvailabilityPanel, frameGbc);

        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    private void showCheckOutPanel() {
        JPanel checkOutPanel = new JPanel();
        checkOutPanel.setLayout(new GridBagLayout());
        checkOutPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between components

        JLabel isbnLabel = new JLabel("ISBN:");
        JTextField isbnField = new JTextField(15); // Set the width of the text field

        JLabel memberIdLabel = new JLabel("Member ID:");
        JTextField memberIdField = new JTextField(15); // Set the width of the text field

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = isbnField.getText();
                Person person = DataAccessFacade.getInstance().findPersonById(memberIdField.getText());
                Member member = (Member) person.getRole();
               boolean checkoutBook =  member.checkoutBook(isbn); // Call the method from Member class
                if (checkoutBook){
                    JOptionPane.showMessageDialog(MemberPanel.this,"Checkout Successful" );
                }else {
                    JOptionPane.showMessageDialog(MemberPanel.this,"Checkout UnSuccessful!" );
                }

            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Window window = SwingUtilities.getWindowAncestor(checkOutPanel);
                if (window != null) {
                    window.dispose();
                }
            }
        });

        // Add components to the checkOutPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        checkOutPanel.add(isbnLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        checkOutPanel.add(isbnField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        checkOutPanel.add(memberIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        checkOutPanel.add(memberIdField, gbc);

        // Add a panel for buttons to center them
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        checkOutPanel.add(buttonPanel, gbc);

        JFrame frame = new JFrame("Check Out Book");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints frameGbc = new GridBagConstraints();
        frameGbc.gridx = 0;
        frameGbc.gridy = 0;
        frameGbc.insets = new Insets(10, 10, 10, 10);
        frame.add(checkOutPanel, frameGbc);

        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}
