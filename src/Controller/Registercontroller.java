package Controller;

import Model.RegisterModel;
import View.Register;
import javax.swing.JOptionPane;

public class Registercontroller {
    private Register view;
    private RegisterModel model;

    public Registercontroller(Register view) {
        this.view = view;
        this.model = null;

        view.getSignup().addActionListener(e -> signUp());
        view.getLogin().addActionListener(e -> logIn());
        view.getckbox().addActionListener(e -> showPassword());
    }

    public void setModel(RegisterModel model) {
        this.model = model;
    }

    private void signUp() {
        String username = view.getUsername().getText();
        String email = view.getEmail().getText();
        String password = String.valueOf(view.getPassword().getPassword());
        String phone = view.getPhone().getText();
        String NID = view.getNID().getText();
        String Gender = (String) view.getGender().getSelectedItem();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty() || NID.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            model = new RegisterModel(username, email, password, phone, NID);
            saveUserData(model);
        }
    }

    private void saveUserData(RegisterModel model) {
        // Implement the logic to save the user data to the database
        System.out.println("User data saved successfully: " + model.getUserName());
    }

    private void logIn() {
        // Implement the logic to log in the user
        System.out.println("Log in button clicked.");
    }

    private void showPassword() {
        if (view.getckbox().isSelected()) {
            view.getPassword().setEchoChar((char) 0);
        } else {
            view.getPassword().setEchoChar('*');
        }
    }
}