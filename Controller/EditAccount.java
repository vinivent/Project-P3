package Controller;


import Model.Account;

public class EditAccount extends Network {

    public void editUser(String email, String newUsername){
        for (Account account : Accounts) {
            if ((account.getEmail()).equals(email)) {
                account.setUsername(newUsername);
            }
        }
    }

    public void editPassword(String email, String newPassword){
        for (Account account : Accounts) {
            if (account.getEmail().equals(email)) {
                account.setPassword(newPassword);
            }
        }
    }

    public void editBirth(String email, String newBirth){
        for (Account account : Accounts) {
            if (account.getEmail().equals(email)) {
                account.setBirthdate(newBirth);
            }
        }
    }

    public void editRelatioship(String email, String relationship){
        for (Account account : Accounts) {
            if (account.getEmail().equals(email)) {
                account.setRelationship(relationship);
            }
        }
    }
    public void editDescription(String email, String description){
        for (Account account : Accounts) {
            if (account.getEmail().equals(email)) {
                account.setDescription(description);
            }
        }
    }
}



