package Controller;

import Model.BikeProfileModel;
import View.BikeProfile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;

public class BikeProfileController {

    private BikeProfile view;
    private BikeProfileModel model;

    public BikeProfileController(BikeProfile view, BikeProfileModel model) {
        this.view = view;
        this.model = model;

        // Add action listeners to the view's buttons
        view.getAdd().addActionListener(new AddButtonListener());
        view.getUpdate().addActionListener(new UpdateButtonListener());
        view.getDelete().addActionListener(new DeleteButtonListener());
        view.getRefresh().addActionListener(new RefreshButtonListener());
        view.getLogout().addActionListener(new LogoutButtonListener());
    }

    // Inner class for the add button listener
    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the data from the view
            String registrationNo = view.getRegistration().getText();
            String model = view.getModel().getText();
            String brand = view.getBrand().getText();
            int year = Integer.parseInt(view.getYear().getText());
            double price = Double.parseDouble(view.getPrice().getText());
            String status = (String) view.getStatus().getSelectedItem();

            // Create a new BikeProfileModel object
            BikeProfileModel newModel = new BikeProfileModel(registrationNo, model, brand, year, price, status, new Date());

            // Add the new model to the database (not implemented here)
            // For example, you could use a JDBC connection to insert the data into a database
            // ...

            // Clear the view's fields
            view.getRegistration().setText("");
            view.getModel().setText("");
            view.getBrand().setText("");
            view.getYear().setText("");
            view.getPrice().setText("");
        }
    }

    // Inner class for the update button listener
    private class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the data from the view
            String registrationNo = view.getRegistration().getText();
            String bikemodel = view.getModel().getText();
            String brand = view.getBrand().getText();
            int year = Integer.parseInt(view.getYear().getText());
            double price = Double.parseDouble(view.getPrice().getText());
            String status = (String) view.getStatus().getSelectedItem();

//             Update the model
            model.setRegistrationNo(registrationNo);
            model.setModel(bikemodel);
            model.setBrand(brand);
            model.setYear(year);
            model.setPrice(price);
            model.setStatus(status);

            // Update the model in the database (not implemented here)
            // For example, you could use a JDBC connection to update the data in a database
            // ...

            // Clear the view's fields
            view.getRegistration().setText("");
            view.getModel().setText("");
            view.getBrand().setText("");
            view.getYear().setText("");
            view.getPrice().setText("");
        }
    }

    // Inner class for the delete button listener
    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the registration number from the view
            String registrationNo = view.getRegistration().getText();

            // Delete the model from the database (not implemented here)
            // For example, you could use a JDBC connection to delete the data from a database
            // ...

            // Clear the view's fields
            view.getRegistration().setText("");
            view.getModel().setText("");
            view.getBrand().setText("");
            view.getYear().setText("");
            view.getPrice().setText("");
        }
    }

    // Inner class for the refresh button listener
    private class RefreshButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Refresh the view's fields
            view.getRegistration().setText(model.getRegistrationNo());
            view.getModel().setText(model.getModel());
            view.getBrand().setText(model.getBrand());
            view.getYear().setText(String.valueOf(model.getYear()));
            view.getPrice().setText(String.valueOf(model.getPrice()));
        }
    }

    // Inner class for the logout button listener
    private class LogoutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logout logic (not implemented here)
            // For example, you could show a login dialog or exit the application
            // ...

            // Close the view
            view.dispose();
        }
    }
}