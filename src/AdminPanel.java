import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

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
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

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

        Dimension buttonSize = new Dimension(200, 50); // Set preferred size for buttons
        addBookButton.setPreferredSize(buttonSize);
        addMemberButton.setPreferredSize(buttonSize);
        editMemberButton.setPreferredSize(buttonSize);
        logoutButton.setPreferredSize(buttonSize);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 0, 10, 0); // Add vertical spacing between buttons
        gbc.anchor = GridBagConstraints.CENTER;

        buttonPanel.add(addBookButton, gbc);
        buttonPanel.add(addMemberButton, gbc);
        buttonPanel.add(editMemberButton, gbc);
        buttonPanel.add(logoutButton, gbc);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void showAddBookPanel() {
        JPanel addBookPanel = new JPanel(new GridLayout(8, 4));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        Insets columnPadding = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

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
        submitButton.setPreferredSize(new Dimension(200, 50));
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

        gbc.gridx = 0;
        gbc.gridy = 0;
        addBookPanel.add(isbnLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(isbnField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(titleLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(authorIdLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(authorIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(lastNameLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(streetLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(streetField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(cityLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(cityField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(stateLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(stateField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(zipLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(zipField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(credentialLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(credentialField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(bioLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(bioField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(copiesLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(copiesField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        addBookPanel.add(borrowDurationLabel, gbc);
        gbc.gridx = 1;
        addBookPanel.add(borrowDurationField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
//        addBookPanel.add(submitButton, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        addBookPanel.add(submitButton, gbc);


        JFrame frame = new JFrame("Add Book");
        frame.setSize(new Dimension(600, 400));
        frame.setLocationRelativeTo(null);
        frame.setContentPane(addBookPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void showAddMemberPanel() {
        JPanel addMemberPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Reduced padding around components
        Insets reducedInsets = new Insets(5, 5, 5, 5);
        // Padding between columns
        Insets columnPadding = new Insets(5, 10, 5, 10);

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
        submitButton.setPreferredSize(new Dimension(200, 50));
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

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = reducedInsets;
        addMemberPanel.add(firstName, gbc);
        gbc.gridx = 1;
        gbc.insets = columnPadding;
        addMemberPanel.add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.insets = reducedInsets;
        addMemberPanel.add(lastName, gbc);
        gbc.gridx = 1;
        gbc.insets = columnPadding;
        addMemberPanel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.insets = reducedInsets;
        addMemberPanel.add(phone, gbc);
        gbc.gridx = 1;
        gbc.insets = columnPadding;
        addMemberPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.insets = reducedInsets;
        addMemberPanel.add(roleLabel, gbc);
        gbc.gridx = 1;
        gbc.insets = columnPadding;
        addMemberPanel.add(roleComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.insets = reducedInsets;
        addMemberPanel.add(streetLabel, gbc);
        gbc.gridx = 1;
        gbc.insets = columnPadding;
        addMemberPanel.add(streetField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.insets = reducedInsets;
        addMemberPanel.add(cityLabel, gbc);
        gbc.gridx = 1;
        gbc.insets = columnPadding;
        addMemberPanel.add(cityField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.insets = reducedInsets;
        addMemberPanel.add(stateLabel, gbc);
        gbc.gridx = 1;
        gbc.insets = columnPadding;
        addMemberPanel.add(stateField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.insets = reducedInsets;
        addMemberPanel.add(zipLabel, gbc);
        gbc.gridx = 1;
        gbc.insets = columnPadding;
        addMemberPanel.add(zipField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 0, 0); // Add some top padding for the submit button
        gbc.anchor = GridBagConstraints.CENTER;
        addMemberPanel.add(submitButton, gbc);

        JFrame frame = new JFrame("Add Member");
        frame.setContentPane(addMemberPanel);
        frame.setSize(new Dimension(600, 400));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private void showAskForMemberIdPanel() {
        JPanel askForMemberIdPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        // Padding around components
        Insets padding = new Insets(10, 10, 10, 10);

        JLabel memberIdLabel = new JLabel("ID Number:");
        JTextField memberIdField = new JTextField(20);

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(200, 50)); // Set button size
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String memberId = memberIdField.getText();
                Person person = dataAccess.findPersonById(memberId);
                if (person != null) {
                    showEditMemberPanel(person);
                } else {
                    JOptionPane.showMessageDialog(AdminPanel.this, "Member not found.");
                }
            }
        });

        // Adding components to the panel with GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = padding;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        askForMemberIdPanel.add(memberIdLabel, gbc);

        gbc.gridy++;
        askForMemberIdPanel.add(memberIdField, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(20, 10, 10, 10); // Add some top padding for the submit button
        askForMemberIdPanel.add(submitButton, gbc);

        JFrame frame = new JFrame("Enter Member ID");
        frame.setContentPane(askForMemberIdPanel);
        frame.setSize(new Dimension(400, 200)); // Set the frame size
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    private void showEditMemberPanel(Person person) {
        JPanel editMemberPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Insets increasedPadding = new Insets(15, 15, 15, 15);

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
        submitButton.setPreferredSize(new Dimension(200, 50));
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

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = increasedPadding;
        editMemberPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        editMemberPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        editMemberPanel.add(roleLabel, gbc);
        gbc.gridx = 1;
        editMemberPanel.add(roleComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        editMemberPanel.add(streetLabel, gbc);
        gbc.gridx = 1;
        editMemberPanel.add(streetField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        editMemberPanel.add(cityLabel, gbc);
        gbc.gridx = 1;
        editMemberPanel.add(cityField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        editMemberPanel.add(stateLabel, gbc);
        gbc.gridx = 1;
        editMemberPanel.add(stateField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        editMemberPanel.add(zipLabel, gbc);
        gbc.gridx = 1;
        editMemberPanel.add(zipField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 15, 15, 15); // Add some top padding for the submit button
        gbc.anchor = GridBagConstraints.CENTER;
        editMemberPanel.add(submitButton, gbc);

        JFrame frame = new JFrame("Edit Member");
        frame.setContentPane(editMemberPanel);
        frame.setSize(new Dimension(800, 600)); // Set a larger frame size
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}
