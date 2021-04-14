package Pojo;

public class RegisterAccount {
    private String FirstName;
    private String LastName;
    private String Telephone;
    //private String email;
    private String password;
    private String confirmPassword;
    private boolean shouldRegister; //bandera o flag que determina si una cuenta se registra o no
    // si solo se usa para parsear de json a pojo, no requiere de constructor
    public RegisterAccount(String _FirstName, String _LastName, String _Telephone,
                           String _email, String _password, String _confirmPassword, boolean _shouldRegister) {
        this.setFirstName(_FirstName);
        this.setLastName(_LastName);
        this.setTelephone(_Telephone);
        //this.setEmail(_email);
        this.setPassword(_password);
        this.setConfirmPassword(_confirmPassword);
        this.setShouldRegister(_shouldRegister);
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

   /* public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     */

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isShouldRegister() {
        return shouldRegister;
    }

    public void setShouldRegister(boolean shouldRegister) {
        this.shouldRegister = shouldRegister;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
