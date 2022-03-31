package Logic;
//import java.util.ArrayList;
//import java.util.List;

public class Account {
    private String email, password, username, birthdate, relationship;
    
    // private List<posts> posts;   
    // private List<CreateAccount> accounts = new ArrayList<>();
     
    public Account(String email, String username, String password, String birthdate) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
        
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getRelationship() {
        return this.relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
     
}



  // public boolean verificarSenha(String senha){
    //     if(senha.length() < 6){
    //         return false;
    //     } else if (senha.length() >= 6) {
    //         for (int i = 0; i < senha.length(); i++) {
    //             if (Character.isDigit(senha.charAt(i))) {
    //                 return true;
    //             } else {
    //                 return false;
    //             }
    //         }
    //     }
        
    //     return true;
    // } 