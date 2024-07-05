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
        JPanel checkAvailabilityPanel = new JPanel(new GridLayout(2, 2));

        JLabel isbnLabel = new JLabel("ISBN:");
        JTextField isbnField = new JTextField();

        JButton checkButton = new JButton("Check");
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = isbnField.getText();
                List<Book> books = dataAccess.getBooks();
                boolean available = books.stream().anyMatch(book -> book.getIsbn().equals(isbn));
                JOptionPane.showMessageDialog(MemberPanel.this, available ? "Book is available!" : "Book is not available.");
            }
        });

        checkAvailabilityPanel.add(isbnLabel);
        checkAvailabilityPanel.add(isbnField);
        checkAvailabilityPanel.add(new JLabel()); // Empty cell
        checkAvailabilityPanel.add(checkButton);

        JFrame frame = new JFrame("Check Availability");
        frame.setContentPane(checkAvailabilityPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void showCheckOutPanel() {
        JPanel checkOutPanel = new JPanel(new GridLayout(3, 2));

        JLabel isbnLabel = new JLabel("ISBN:");
        JTextField isbnField = new JTextField();
        JLabel memberIdLabel = new JLabel("Member ID:");
        JTextField memberIdField = new JTextField();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = isbnField.getText();
                String memberId = memberIdField.getText();
                // Add check out logic here
                JOptionPane.showMessageDialog(MemberPanel.this, "Book checked out successfully!");
            }
        });

        checkOutPanel.add(isbnLabel);
        checkOutPanel.add(isbnField);
        checkOutPanel.add(memberIdLabel);
        checkOutPanel.add(memberIdField);
        checkOutPanel.add(new JLabel()); // Empty cell
        checkOutPanel.add(submitButton);

        JFrame frame = new JFrame("Check Out Book");
        frame.setContentPane(checkOutPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
