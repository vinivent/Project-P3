package Logic;

import java.util.LinkedList;

public class Account {
    private String email, password, username, birthdate, relationship, description;

    private LinkedList<Account> RequestsList;
    private LinkedList<String> MessageList;
    private LinkedList<Account> FriendList;

    public Account(String email, String username, String password, String birthdate) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.birthdate = birthdate;
        relationship = "???";
        description = "Missing description";
        FriendList = new LinkedList<Account>();
        RequestsList = new LinkedList<Account>();
        MessageList = new LinkedList<String>();
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkedList<Account> getFriendList() {
        return FriendList;
    }

    public void setFriendList(LinkedList<Account> newList) {
        this.FriendList = newList;
    }

    public int getNotifications() {
        return RequestsList.size();
    }

    public LinkedList<Account> getRequestsList() {
        return RequestsList;
    }

    public void setRequestsList(LinkedList<Account> newRequests) {
        this.RequestsList = newRequests;
    }

    public LinkedList<String> getMessageList() {
        return MessageList;
    }

    public void setMessageList(LinkedList<String> newMessage) {
        this.MessageList = newMessage;
    }

}
