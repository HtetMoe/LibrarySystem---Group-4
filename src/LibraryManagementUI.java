import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LibraryManagementUI extends JFrame {
    private DataAccessFacade dataAccess;

    private JPanel loginPanel;
    private JPanel adminPanel;
    private JPanel librarianPanel;
    private JPanel memberPanel;

    public LibraryManagementUI() {
        dataAccess = new DataAccessFacade(); // Initialize data access facade
        DataAccessFacade.getInstance().retrieveObject();

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

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DataAccessFacade.getInstance().saveObject();
                System.exit(0);
            }
        });
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
        DataAccessFacade.getInstance().retrieveObject();

        //Mock Data Admin
//        Person admin = new Person();
//        admin.setRole(Role.createPersonFactory(AuthorizationLevel.ADMIN));
//        admin.setId("001");
//        admin.setPassword("001");
//        DataAccessFacade.getInstance().addPerson(admin.getId(),admin);
//        DataAccessFacade.getInstance().saveObject();
//        System.out.println(DataAccessFacade.getInstance().findPersonById("001"));

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryManagementUI().setVisible(true);
            }
        });
    }
}
