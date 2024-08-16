package Controller;

import Model.BookingProfileModel;
import View.BookingProfile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class BookingProfileController {

    private BookingProfile view;
    private BookingProfileModel model;

    public BookingProfileController(BookingProfile view, BookingProfileModel model) {
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
            String bookId = view.getBookid().getText();
            String registrationId = view.getRegistrationid().getText();
            String customerId = view.getCustomerid().getText();
            String pickupDate = view.getPickupdate().getText();
            String dropoffDate = view.getDropoffdate().getText();

            model.setBookId(bookId);
            model.setRegistrationId(registrationId);
            model.setCustomerId(customerId);
            model.setPickupDate(pickupDate);
            model.setDropoffDate(dropoffDate);

            // Add the data to the database or perform any other operation
            JOptionPane.showMessageDialog(view, "Data added successfully");
        }
    }

    class UpdateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String bookId = view.getBookid().getText();
            String registrationId = view.getRegistrationid().getText();
            String customerId = view.getCustomerid().getText();
            String pickupDate = view.getPickupdate().getText();
            String dropoffDate = view.getDropoffdate().getText();

            model.setBookId(bookId);
            model.setRegistrationId(registrationId);
            model.setCustomerId(customerId);
            model.setPickupDate(pickupDate);
            model.setDropoffDate(dropoffDate);

            // Update the data in the database or perform any other operation
            JOptionPane.showMessageDialog(view, "Data updated successfully");
        }
    }

    class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String bookId = view.getBookid().getText();

            model.setBookId(bookId);

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