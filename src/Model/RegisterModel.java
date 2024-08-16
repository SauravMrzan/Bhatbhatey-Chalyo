/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Saurav
 */
public class RegisterModel {
    private String username;
    private String email;
    private String password;
    private String phone;
    private String NID;
    
    public RegisterModel(String username,String email,String password,String phone,String NID){
        this.username=username;
        this.email=email;
        this.password=password;
        this.phone=phone;
        this.NID=NID;
    }
    public String getUserName(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getPhone(){
        return phone;
    }
    public String getNID(){
        return NID;
    }
}
