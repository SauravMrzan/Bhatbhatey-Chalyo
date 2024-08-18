/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Acer
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import DAO.BikeDAO;
import Model.BikeProfileModel;
import Model.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import View.BikeProfile;

/**
 *
 * @author Acer
 */
public class BikeProfileController {
    private final BikeProfile b;
    private final BikeDAO bikedao;
    
     public BikeProfileController( BikeProfile b) {
        this.b = b;
        Connection conn = null;
        try {
            conn = Database.getConnection();
            this.bikedao= new BikeDAO(conn);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(b, "Error establishing database connection: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Unable to establish database connection.", e);
        }
        
        b.getAddbtn().addActionListener(new AddButtonListener());
        b.getUpbtn().addActionListener(new UpbtnListener());
        b.getDltbtn().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DltbtnMouseClicked(evt);
            }
        });
    }

    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) b.getBikeTable().getModel();
    
    // Clear the existing data from the table
    model.setRowCount(0);
    
    // Retrieve new data from your database or wherever it's stored
    List<Object[]> newData = fetchDataFromDatabase();
    
    // Populate the table with the new data
    for (Object[] rowData : newData) {
        model.addRow(rowData);
    }
}

// Method to fetch data from the database, replace it with your actual implementation
    private List<Object[]> fetchDataFromDatabase() {
        List<Object[]> data = new ArrayList<>();
        try (PreparedStatement ps = bikedao.getConnection().prepareStatement("SELECT * FROM bikedetials")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] row = new Object[] {
                        rs.getString("RegistrationNO"),
                        rs.getString("Model"),
                        rs.getString("Brand"),
                        rs.getString("Year"),
                        rs.getString("Price"),
                        rs.getString("Status")
                    };
                    data.add(row);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(b, "Error fetching data from database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return data;
    }
     private class AddButtonListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            AddbtnActionPerformed(evt);
        }
    }

  private class UpbtnListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            UpbtnActionPerformed(evt);
        }
    }
  

  
      private void AddbtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
    String model = b.getModel().getText().trim();
    String brand = b.getBrand().getText().trim();
    String year = b.getYear().getText().trim();
    String price = b.getPrice().getText().trim();
    String status = (String) b.getStatus().getSelectedItem(); // Assuming GenderC is a JComboBox with gender options
    String registration= b.getRegister().getText().trim();

    
    if (model.isEmpty() || brand.isEmpty() || year.isEmpty() || price.isEmpty() || status == null || registration.isEmpty()) {
        JOptionPane.showMessageDialog(b, "All fields must be filled out.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    BikeProfileModel cm=new BikeProfileModel(registration,model,brand,year, price,status);
 try {
        if (!bikedao.userExists(registration)) {
        } else {
            JOptionPane.showMessageDialog(b, "User with ID " + registration+ " already exists.", "Duplicate ID", JOptionPane.WARNING_MESSAGE);
            return;
        }
        bikedao.addBike(cm);
        JOptionPane.showMessageDialog(b,"User added successfully");
         loadTableData();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(b, "Error checking existing user data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        
        b.getModel().setText("");
     b.getYear().setText("");
     b.getBrand().setText("");
     b.getPrice().setText("");
     b.getRegister().setText("");
    }                      
    
  private void UpbtnActionPerformed(java.awt.event.ActionEvent evt) {                                      
        String model = b.getModel().getText().trim();
    String brand = b.getBrand().getText().trim();
    String year = b.getYear().getText().trim();
    String price = b.getPrice().getText().trim();
    String status = (String) b.getStatus().getSelectedItem(); // Assuming GenderC is a JComboBox with gender options
    String registration= b.getRegister().getText().trim();

        if (price.isEmpty()) {
            JOptionPane.showMessageDialog(b, "Price can't be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BikeProfileModel cm=new BikeProfileModel(registration,model,brand,year, price,status);
//        String selectedId = c.getSelectedRowId();
         try {
             if (!bikedao.userExists(registration)) {
                JOptionPane.showMessageDialog(b, "User with ID " + registration + " does not exist.", "User Not Found", JOptionPane.WARNING_MESSAGE);
                return;
            }
        bikedao.updateBike(cm);
        JOptionPane.showMessageDialog(b,"Bikes updated successfully");
         loadTableData();
         }catch (SQLException e) {
        JOptionPane.showMessageDialog(b, "Error checking existing bike data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        return;}
      
    b.getModel().setText("");
     b.getYear().setText("");
     b.getBrand().setText("");
     b.getPrice().setText("");
     b.getRegister().setText("");
    }     
       
       
       
     private void DltbtnMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
     String register = b.getRegister().getText().trim(); 

    if (register.isEmpty()) {
        JOptionPane.showMessageDialog(b, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(b, "Are you sure you want to delete this record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            if (bikedao.userExists(register)) {
                bikedao.deleteUser(register);
                JOptionPane.showMessageDialog(b, "Record deleted successfully!");
                 loadTableData();
               
            } else {
                JOptionPane.showMessageDialog(b, "No record found with the provided Registration No.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(b, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
     
       b.getModel().setText("");
     b.getYear().setText("");
     b.getBrand().setText("");
     b.getPrice().setText("");
     b.getRegister().setText("");
       
}
}
