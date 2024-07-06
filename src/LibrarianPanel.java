import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LibrarianPanel extends JPanel {

    private DataAccessFacade dataAccess;
    private LibraryManagementUI mainFrame;

    public LibrarianPanel(DataAccessFacade dataAccess, LibraryManagementUI mainFrame) {
        this.dataAccess = dataAccess;
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Librarian Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JButton checkOutBookButton = new JButton("Check Out Book");
        JButton findOverdueButton = new JButton("Find Overdue Books");
        JButton addCopyButton = new JButton("Add Copy");
        JButton logoutButton = new JButton("Logout");

        checkOutBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCheckOutPanel();
            }
        });

        findOverdueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showFindOverduePanel();
            }
        });

        addCopyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddCopyPanel();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showLoginPanel();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(checkOutBookButton);
        buttonPanel.add(findOverdueButton);
        buttonPanel.add(addCopyButton);
        buttonPanel.add(logoutButton);

        add(buttonPanel, BorderLayout.CENTER);
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
                boolean checkOutBook = Librarian.checkoutBook(memberId,isbn);
                // Add check out logic here
                if (checkOutBook == true){
                    JOptionPane.showMessageDialog(LibrarianPanel.this, "Successfully!");
                }else{
                    JOptionPane.showMessageDialog(LibrarianPanel.this, "Unsuccessfully!");
                }

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

    private void showFindOverduePanel() {
      
        List<Book> overdueBooks = Librarian.findOverdue();
        StringBuilder message = new StringBuilder();

        if (overdueBooks == null || overdueBooks.isEmpty()) {
            message.append("No overdue books.");
        } else {
            message.append("Overdue Books:\n");
            for (Book book : overdueBooks) {
                message.append(book.getTitle()).append(" by ").append(book.getAuthor()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(LibrarianPanel.this, message.toString());

    }

    private void showAddCopyPanel() {
        JPanel addCopyPanel = new JPanel(new GridLayout(2, 2));

        JLabel isbnLabel = new JLabel("ISBN:");
        JTextField isbnField = new JTextField();
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = isbnField.getText();
                Librarian.addBookCopy(isbn);
                JOptionPane.showMessageDialog(LibrarianPanel.this, "Copy added successfully!");
            }
        });

        addCopyPanel.add(isbnLabel);
        addCopyPanel.add(isbnField);
        addCopyPanel.add(new JLabel()); // Empty cell
        addCopyPanel.add(submitButton);

        JFrame frame = new JFrame("Add Copy");
        frame.setContentPane(addCopyPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
