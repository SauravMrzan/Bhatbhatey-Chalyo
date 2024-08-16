package Controller;

import Model.NewLoginModel;
import View.Newlogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Logincontroller {

    private final Newlogin view;

    public Logincontroller(Newlogin view) {
        this.view = view;

        // Add action listener to the login button
        view.getLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButtonClicked();
            }
        });


    }

    private void loginButtonClicked() {
        String email = view.getEmail().getText().trim();
        String password = new String(view.getPassword().getPassword()).trim();

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        NewLoginModel log = new NewLoginModel(email, password);
//        try {
//            if (Logindao.isValidLogin(log)) {
//                // Login successful
//                JOptionPane.showMessageDialog(view, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
//
//                // Handle navigation to next view
//                Functionportal up = new Functionportal();
//                up.setLocationRelativeTo(null);
//                up.setVisible(true);
//
//                view.dispose();
//            } else {
//                JOptionPane.showMessageDialog(view, "Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(view, "An error occurred while logging in: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
    }

    private void signUpButtonClicked() {
        // Handle sign up logic here
        // For now, just show a message dialog
        JOptionPane.showMessageDialog(view, "Sign up button clicked!", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void checkboxActionPerformed(ActionEvent e) {
        if (view.getCheckbox().isSelected()) {
            view.getPassword().setEchoChar((char) 0);
        } else {
            view.getPassword().setEchoChar('*');
        }
    }
}