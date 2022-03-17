import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

public class CreateAccount {
    private String email, password, username, birthdate, relationship;
    
    private List<posts> posts;   

    public CreateAccount(String email, String username, String password, String birthdate, String relationship) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.birthdate = birthdate;
        this.relationship = relationship;
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

    public String getUsermame() {
        return this.username;
    }

    public void setUsername(String username) {
        String novoNome;
        if(getUsermame().length() < 4 && getUsermame().length() >= 15){
            novoNome = "Guest";
            this.username = novoNome;
        }
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