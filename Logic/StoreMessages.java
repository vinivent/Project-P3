package Logic;

import java.util.LinkedList;

public class StoreMessages {
    private LinkedList<String> messageHistory;
    private String friendEmail;


    public StoreMessages(String Friend) {
        this.friendEmail = Friend;
        this.messageHistory = new LinkedList<String>();
    }

    public LinkedList<String> getMessageHistory() {
        return this.messageHistory;
    }

    public void setMessageHistory(LinkedList<String> messageHistory) {
        this.messageHistory = messageHistory;
    }

    public String getRecivedUser() {
        return this.friendEmail;
    }

    public void setRecivedUser(String recivedUser) {
        this.friendEmail = recivedUser;
    }

}
