import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminPanel extends JPanel {

    private DataAccessFacade dataAccess;
    private LibraryManagementUI mainFrame;

    public AdminPanel(DataAccessFacade dataAccess, LibraryManagementUI mainFrame) {
        this.dataAccess = dataAccess;
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Admin Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JButton addBookButton = new JButton("Add Book");
        JButton addMemberButton = new JButton("Add Member");
        JButton editMemberButton = new JButton("Edit Member");
        JButton logoutButton = new JButton("Logout");

        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddBookPanel();
            }
        });

        addMemberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddMemberPanel();
            }
        });

        editMemberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showEditMemberPanel(dataAccess.findPersonById("admin"));
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showLoginPanel();
            }
        });

        editMemberButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAskForMemberIdPanel();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBookButton);
        buttonPanel.add(addMemberButton);
        buttonPanel.add(editMemberButton);
        buttonPanel.add(logoutButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void showAddBookPanel() {
        JPanel addBookPanel = new JPanel(new GridLayout(15, 2));

        JLabel isbnLabel = new JLabel("ISBN:");
        JTextField isbnField = new JTextField();
        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();
        JLabel authorIdLabel = new JLabel("Author ID:");
        JTextField authorIdField = new JTextField();
        JLabel firstNameLabel = new JLabel("Author First Name:");
        JTextField firstNameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Author Last Name:");
        JTextField lastNameField = new JTextField();
        JLabel phoneLabel = new JLabel("Author Phone:");
        JTextField phoneField = new JTextField();
        JLabel streetLabel = new JLabel("Author Street:");
        JTextField streetField = new JTextField();
        JLabel cityLabel = new JLabel("Author City:");
        JTextField cityField = new JTextField();
        JLabel stateLabel = new JLabel("Author State:");
        JTextField stateField = new JTextField();
        JLabel zipLabel = new JLabel("Author ZIP:");
        JTextField zipField = new JTextField();
        JLabel credentialLabel = new JLabel("Author Credential:");
        JTextField credentialField = new JTextField();
        JLabel bioLabel = new JLabel("Author Bio:");
        JTextField bioField = new JTextField();
        JLabel copiesLabel = new JLabel("Number of Copies:");
        JTextField copiesField = new JTextField();
        JLabel borrowDurationLabel = new JLabel("Borrow Duration (days):");
        JTextField borrowDurationField = new JTextField();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = isbnField.getText();
                String title = titleField.getText();
                String authorId = authorIdField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String phone = phoneField.getText();
                String street = streetField.getText();
                String city = cityField.getText();
                String state = stateField.getText();
                String zip = zipField.getText();
                String credential = credentialField.getText();
                String bio = bioField.getText();
                int copies = Integer.parseInt(copiesField.getText());
                int borrowDuration = Integer.parseInt(borrowDurationField.getText());
                Administrator.addNewBook(isbn,title,authorId,firstName,lastName,phone,street,city,state,zip,credential,bio,copies,borrowDuration);
                // Book book = Book.createBookWithAuthor(isbn, title, authorId, firstName, lastName, phone, street, city, state, zip, credential, bio, copies, borrowDuration);
//                dataAccess.addBook(book);
                JOptionPane.showMessageDialog(AdminPanel.this, "Book added successfully!");
            }
        });

        addBookPanel.add(isbnLabel);
        addBookPanel.add(isbnField);
        addBookPanel.add(titleLabel);
        addBookPanel.add(titleField);
        addBookPanel.add(authorIdLabel);
        addBookPanel.add(authorIdField);
        addBookPanel.add(firstNameLabel);
        addBookPanel.add(firstNameField);
        addBookPanel.add(lastNameLabel);
        addBookPanel.add(lastNameField);
        addBookPanel.add(phoneLabel);
        addBookPanel.add(phoneField);
        addBookPanel.add(streetLabel);
        addBookPanel.add(streetField);
        addBookPanel.add(cityLabel);
        addBookPanel.add(cityField);
        addBookPanel.add(stateLabel);
        addBookPanel.add(stateField);
        addBookPanel.add(zipLabel);
        addBookPanel.add(zipField);
        addBookPanel.add(credentialLabel);
        addBookPanel.add(credentialField);
        addBookPanel.add(bioLabel);
        addBookPanel.add(bioField);
        addBookPanel.add(copiesLabel);
        addBookPanel.add(copiesField);
        addBookPanel.add(borrowDurationLabel);
        addBookPanel.add(borrowDurationField);
        addBookPanel.add(new JLabel()); // Empty cell
        addBookPanel.add(submitButton);

        JFrame frame = new JFrame("Add Book");
        frame.setContentPane(addBookPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void showAddMemberPanel() {
        JPanel addMemberPanel = new JPanel(new GridLayout(9, 2));

        // Person fields
        JLabel firstName = new JLabel("FirstName:");
        JTextField firstNameField = new JTextField();
        JLabel lastName = new JLabel("LastName:");
        JTextField lastNameField = new JTextField();
        JLabel phone = new JLabel("Phone:");
        JTextField phoneField = new JTextField();
        JLabel roleLabel = new JLabel("Role:");
        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"ADMIN", "LIBRARIAN", "MEMBER"});

        // Address fields
        JLabel streetLabel = new JLabel("Street:");
        JTextField streetField = new JTextField();
        JLabel cityLabel = new JLabel("City:");
        JTextField cityField = new JTextField();
        JLabel stateLabel = new JLabel("State:");
        JTextField stateField = new JTextField();
        JLabel zipLabel = new JLabel("ZIP:");
        JTextField zipField = new JTextField();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String phone = phoneField.getText();
                String role = (String) roleComboBox.getSelectedItem();
                String street = streetField.getText();
                String city = cityField.getText();
                String state = stateField.getText();
                String zip = zipField.getText();
                AuthorizationLevel authorizationLevel = switch (role){
                    case("ADMIN")-> AuthorizationLevel.ADMIN;
                    case("LIBRARIAN")->AuthorizationLevel.LIBRARIAN;
                    case("MEMBER")->AuthorizationLevel.MEMBER;
                    default -> throw new IllegalStateException("Unexpected value: " + role);
                };
                Administrator.addMember("id",firstName,lastName,phone,street,city,state,zip,authorizationLevel);
 //               Address address = new Address(street, city, state, zip);
//                Person person = new Person();
//                dataAccess.addPerson(person);
                JOptionPane.showMessageDialog(AdminPanel.this, "Member added successfully!");
            }
        });

        addMemberPanel.add(firstNameField);
        addMemberPanel.add(lastNameField);
        addMemberPanel.add(roleLabel);
        addMemberPanel.add(phoneField);
        addMemberPanel.add(roleComboBox);
        addMemberPanel.add(streetLabel);
        addMemberPanel.add(streetField);
        addMemberPanel.add(cityLabel);
        addMemberPanel.add(cityField);
        addMemberPanel.add(stateLabel);
        addMemberPanel.add(stateField);
        addMemberPanel.add(zipLabel);
        addMemberPanel.add(zipField);
        addMemberPanel.add(new JLabel()); // Empty cell
        addMemberPanel.add(submitButton);

        JFrame frame = new JFrame("Add Member");
        frame.setContentPane(addMemberPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void showAskForMemberIdPanel() {
        JPanel askForMemberIdPanel = new JPanel(new GridLayout(2, 2));

        JLabel memberIdLabel = new JLabel("Member ID:");
        JTextField memberIdField = new JTextField();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String memberId = memberIdField.getText();
                Person person = dataAccess.findPersonById(memberId);
                if (person != null) {
                    showEditMemberPanel(dataAccess.findPersonById("admin"));
                } else {
                    JOptionPane.showMessageDialog(AdminPanel.this, "Member not found.");
                }
            }
        });

        askForMemberIdPanel.add(memberIdLabel);
        askForMemberIdPanel.add(memberIdField);
        askForMemberIdPanel.add(new JLabel()); // Empty cell
        askForMemberIdPanel.add(submitButton);

        JFrame frame = new JFrame("Enter Member ID");
        frame.setContentPane(askForMemberIdPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void showEditMemberPanel(Person person) {
        JPanel editMemberPanel = new JPanel(new GridLayout(9, 2));

        JLabel nameLabel = new JLabel("New Name:");
        JTextField nameField = new JTextField("person.getName()");
        JLabel roleLabel = new JLabel("New Role:");
        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"Admin", "Librarian", "Member"});
        roleComboBox.setSelectedItem(person.getRole());
        JLabel streetLabel = new JLabel("New Street:");
        JTextField streetField = new JTextField("person.getAddress().getStreet()");
        JLabel cityLabel = new JLabel("New City:");
        JTextField cityField = new JTextField("person.getAddress().getCity()");
        JLabel stateLabel = new JLabel("New State:");
        JTextField stateField = new JTextField("person.getAddress().getState(");
        JLabel zipLabel = new JLabel("New ZIP:");
        JTextField zipField = new JTextField("person.getAddress().getZip()");

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                String memberId = memberIdField.getText();
                String newName = nameField.getText();
                String newRole = (String) roleComboBox.getSelectedItem();
                String newStreet = streetField.getText();
                String newCity = cityField.getText();
                String newState = stateField.getText();
                String newZip = zipField.getText();

//                List<Person> people = dataAccess.getAllPeople();
//                for (Person person : people) {
//                    if (person.getId().equals(memberId)) {
//                        person.setFirstName(newName);
//                        //person.setRole(newRole);
//                        //person.setAddress(new Address(newStreet, newCity, newState, newZip));
//                        JOptionPane.showMessageDialog(AdminPanel.this, "Member updated successfully!");
//                        return;
//                    }
//                }
                JOptionPane.showMessageDialog(AdminPanel.this, "Member not found.");
            }
        });

//        editMemberPanel.add(memberIdLabel);
//        editMemberPanel.add(memberIdField);
        editMemberPanel.add(nameLabel);
        editMemberPanel.add(nameField);
        editMemberPanel.add(roleLabel);
        editMemberPanel.add(roleComboBox);
        editMemberPanel.add(streetLabel);
        editMemberPanel.add(streetField);
        editMemberPanel.add(cityLabel);
        editMemberPanel.add(cityField);
        editMemberPanel.add(stateLabel);
        editMemberPanel.add(stateField);
        editMemberPanel.add(zipLabel);
        editMemberPanel.add(zipField);
        editMemberPanel.add(new JLabel()); // Empty cell
        editMemberPanel.add(submitButton);

        JFrame frame = new JFrame("Edit Member");
        frame.setContentPane(editMemberPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
