package Logic;

import java.util.LinkedList;

public class StoreMessages {
    private LinkedList<String> messageHistory;
    private Account sentUser;
    private Account recivedUser;


    public StoreMessages(Account sentUser, Account recivedUser) {
        this.messageHistory = new LinkedList<String>();
        this.sentUser = sentUser;
        this.recivedUser = recivedUser;
    }

    public LinkedList<String> getMessageHistory() {
        return this.messageHistory;
    }

    public void setMessageHistory(LinkedList<String> messageHistory) {
        this.messageHistory = messageHistory;
    }

    public Account getSentUser() {
        return this.sentUser;
    }

    public void setSentUser(Account sentUser) {
        this.sentUser = sentUser;
    }

    public Account getRecivedUser() {
        return this.recivedUser;
    }

    public void setRecivedUser(Account recivedUser) {
        this.recivedUser = recivedUser;
    }

}
