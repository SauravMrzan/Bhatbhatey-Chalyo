package Controller;
import View.Newlogin;

import DAO.logindao;
import Model.NewLoginModel;
import View.HomePage;
import View.UserProfile;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Logincontroller {

    private final Newlogin view;
    private final logindao logindao;

    public Logincontroller(Newlogin view) {
        this.view = view;
        this.logindao = new logindao();

        // Add action listener to the login button
        view.getLoginButton().addActionListener(e -> loginButtonClicked());
    }

    private void loginButtonClicked() {
        String email = view.getEmail().getText().trim();
        String password = new String(view.getpassword().getPassword()).trim();

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
            NewLoginModel log= new NewLoginModel(email,password);
            try {
            if (logindao.isValidLogin(log)) {
                // Login successful
                JOptionPane.showMessageDialog(view, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Handle navigation to next view
                HomePage up = new HomePage();
                up.setLocationRelativeTo(null);
                up.setVisible(true);
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "An error occurred while logging in: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}