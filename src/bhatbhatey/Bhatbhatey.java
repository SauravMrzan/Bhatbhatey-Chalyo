/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bhatbhatey;

import View.Newlogin;
import View.Register;
import java.sql.SQLException;


/**
 *
 * @author sthas
 */
public class Bhatbhatey {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
//        Startscreen ss = new Startscreen();
//        ss.setVisible(true);
        
        Register ns = new Register();
        ns.setVisible(true);
        
        Newlogin nl = new Newlogin();
        nl.setVisible(true);

    }
    
}
