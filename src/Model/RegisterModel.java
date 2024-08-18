package Model;

public class RegisterModel {
    private final String username;
    private final String password;
    private final String contact;
    private  String email;
    private final String gender;
    private final String NID;

    public RegisterModel(String username, String password, String contact, String email, String gender, String NID) {
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.email = email;
        this.gender = gender;
        this.NID = NID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getNID() {
        return NID;
    }
}