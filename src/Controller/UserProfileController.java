package Controller;

import Model.UserProfileModel;
import View.UserProfile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class UserProfileController {

    private UserProfile view;
    private UserProfileModel model;

    public UserProfileController(UserProfile view, UserProfileModel model) {
        this.view = view;
        this.model = model;

        view.getAdd().addActionListener(new AddButtonListener());
        view.getUpdate().addActionListener(new UpdateButtonListener());
        view.getDelete().addActionListener(new DeleteButtonListener());
        view.getRefresh().addActionListener(new RefreshButtonListener());
        view.getLogout().addActionListener(new LogoutButtonListener());
    }

    class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String customerId = view.getCustomerid().getText();
            String name = view.getNamee().getText();
            String contact = view.getContact().getText();
            String address = view.getAddress().getText();
            String licenseNo = view.getLicenseno().getText();
            String gender = (String) view.getGender().getSelectedItem();

            model.setCustomerId(customerId);
            model.setNamee(name);
            model.setContact(contact);
            model.setAddress(address);
            model.setLicenseNo(licenseNo);
            model.setGender(gender);

            // Add the data to the database or perform any other operation
            JOptionPane.showMessageDialog(view, "Data added successfully");
        }
    }

    class UpdateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String customerId = view.getCustomerid().getText();
            String name = view.getNamee().getText();
            String contact = view.getContact().getText();
            String address = view.getAddress().getText();
            String licenseNo = view.getLicenseno().getText();
            String gender = (String) view.getGender().getSelectedItem();

            model.setCustomerId(customerId);
            model.setNamee(name);
            model.setContact(contact);
            model.setAddress(address);
            model.setLicenseNo(licenseNo);
            model.setGender(gender);

            // Update the data in the database or perform any other operation
            JOptionPane.showMessageDialog(view, "Data updated successfully");
        }
    }

    class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String customerId = view.getCustomerid().getText();

            model.setCustomerId(customerId);

            // Delete the data from the database or perform any other operation
            JOptionPane.showMessageDialog(view, "Data deleted successfully");
        }
    }

    class RefreshButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Refresh the data in the view or perform any other operation
            JOptionPane.showMessageDialog(view, "Data refreshed successfully");
        }
    }

    class LogoutButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Logout the user or perform any other operation
            JOptionPane.showMessageDialog(view, "Logged out successfully");
        }
    }
}