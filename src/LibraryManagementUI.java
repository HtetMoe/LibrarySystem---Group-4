import javax.swing.*;
import java.awt.*;

public class LibraryManagementUI extends JFrame {

    private DataAccessFacade dataAccess;

    private JPanel loginPanel;
    private JPanel adminPanel;
    private JPanel librarianPanel;
    private JPanel memberPanel;

    public LibraryManagementUI() {
        dataAccess = new DataAccessFacade(); // Initialize data access facade
        //DataAccessFacade.getInstance().retrieveObject();

        setTitle("Library Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up the content panel with CardLayout
        getContentPane().setLayout(new CardLayout());

        loginPanel = new LoginPanel(this);
        adminPanel = new AdminPanel(dataAccess, this);
        librarianPanel = new LibrarianPanel(dataAccess, this);
        memberPanel = new MemberPanel(dataAccess, this);

        getContentPane().add(loginPanel, "Login");
        getContentPane().add(adminPanel, "Admin");
        getContentPane().add(librarianPanel, "Librarian");
        getContentPane().add(memberPanel, "Member");

        showLoginPanel();


    }

    public void showLoginPanel() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "Login");
    }

    public void showAdminPanel() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "Admin");
    }

    public void showLibrarianPanel() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "Librarian");
    }

    public void showMemberPanel() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "Member");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryManagementUI().setVisible(true);
            }
        });
    }
}
