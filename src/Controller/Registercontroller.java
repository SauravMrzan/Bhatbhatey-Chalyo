package Controller;

import DAO.AdminDAO;
import Model.RegisterModel;
import View.Register;
import View.Newlogin;  // Import the Login class
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Registercontroller {

    private final Register view;
    private final AdminDAO adminDao;

    public Registercontroller(Register view) {
        this.view = view;
        this.adminDao = new AdminDAO();
        
    }
 
    public void jLabel12MouseClicked(MouseEvent evt) {
        // Dispose the signup view
        view.dispose();

        // Show the login view
        Newlogin loginView = new Newlogin();
        loginView.setVisible(true);
    }

    public boolean isUsernameTaken(String userName) {
        try {
            // Perform a database query to check if the username exists
            return adminDao.isUsernameTaken(userName);
        } catch (SQLException e) {
            // Handle any SQL exceptions
            JOptionPane.showMessageDialog(view, "An error occurred while checking username availability: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return true; // Assuming the username is taken to prevent further issues
        }
    }
 public boolean isEmailTaken(String email) {
        try {
            // Perform a database query to check if the username exists
            return adminDao.isEmailTaken(email);
        } catch (SQLException e) {
            // Handle any SQL exceptions
            JOptionPane.showMessageDialog(view, "An error occurred while checking username availability: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return true; // Assuming the username is taken to prevent further issues
        }
    }
  public boolean isContactTaken(String contact) {
        try {
            // Perform a database query to check if the username exists
            return adminDao.isContactTaken(contact);
        } catch (SQLException e) {
            // Handle any SQL exceptions
            JOptionPane.showMessageDialog(view, "An error occurred while checking username availability: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return true; // Assuming the username is taken to prevent further issues
        }
    }
   public boolean isCitizenshipIdTaken(String citizenshipId) {
        try {
            // Perform a database query to check if the username exists
            return adminDao.isCitizenshipIdTaken(citizenshipId);
        } catch (SQLException e) {
            // Handle any SQL exceptions
            JOptionPane.showMessageDialog(view, "An error occurred while checking username availability: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return true; // Assuming the username is taken to prevent further issues
        }
    }
    public boolean registerAdmin(String userName, String password, String contact, String email, String gender, String citizenshipID) {
        try {
            // Create an Admin object with the provided details
            RegisterModel admin = new RegisterModel(userName, password, contact, email, gender, citizenshipID);
            // Register the admin using the AdminDAO
            return adminDao.registerAdmin(admin);
        } catch (SQLException e) {
            // Handle any SQL exceptions
            JOptionPane.showMessageDialog(view, "An error occurred while registering user: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}