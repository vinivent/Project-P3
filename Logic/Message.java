package Logic;

import java.util.Scanner;
import java.util.LinkedList;

public class Message extends Network {
    LinkedList <Account> MessageList = new LinkedList<>();
    Scanner s = new Scanner(System.in);

    public void sendMessage(String email, String friendEmail, String message) {
        for (Account Account : Accounts) {
            if (Account.getEmail().equals(email)) {
                MessageList = StoreMessages.getMessageList();
                for (Account accountMessages : MessageList) {
                    if (accountMessages.getEmail().equals(friendEmail)) {
                        MessageList.add(accountMessages);
                        Account.setMessageList(MessageList);
                        System.out.println("Message sent to " + getUser(friendEmail));
                    }
                }
            }
            if (Account.getEmail().equals(friendEmail)) {
                MessageList = Account.getMessageList();
                for (Account accountMessages : MessageList) {
                    if (accountMessages.getEmail().equals(email)) {
                        MessageList.add(accountMessages);
                        Account.setMessageList(MessageList);
                    }
                }
            }
        }
    }

    public void replyMessage(String friendEmail, String message) {

    }

    public void showMessages(String email) {
        
    }
}
