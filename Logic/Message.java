package Logic;

import java.util.Scanner;
import java.util.LinkedList;

public class Message extends Network {
    LinkedList <StoreMessages> StoreMessage = new LinkedList<>();
    LinkedList <String> MessageList = new LinkedList<>();
    Scanner s = new Scanner(System.in);

    public void optionMessages(String email){
        showMessageList(email);
        System.out.println("Insert friend's Email or type {LEAVECHAT} to leave:");
        String friendEmail=s.next();
        if(!friendEmail.equalsIgnoreCase("leavechat")){
            sendMessage(email, friendEmail);
        }
    }

    public void addMessage(String email, String friendEmail, String message) {
        
        for (Account Account : Accounts) {
            if (Account.getEmail().equals(email)) {
                StoreMessage = Account.getMessageList();
                for (StoreMessages accountMessages : StoreMessage) {
                    if (accountMessages.getRecivedUser().equals(friendEmail)) {
                        MessageList = accountMessages.getMessageHistory();
                        MessageList.add(getUser(email) + ": " + message);
                        accountMessages.setMessageHistory(MessageList);
                    }
                }
            }
        }
        for (Account Account : Accounts) {
            if (Account.getEmail().equals(friendEmail)) {
                StoreMessage = Account.getMessageList();
                for (StoreMessages accountMessages : StoreMessage) {
                    if (accountMessages.getRecivedUser().equals(email)) {
                        MessageList = accountMessages.getMessageHistory();
                        MessageList.add(getUser(email) + ": " + message);
                        accountMessages.setMessageHistory(MessageList);
                    }
                }
            }
        }
        
    }

    public void sendMessage(String email, String friendEmail) {
        String message ="";
        System.out.println("Write your message or type {LEAVECHAT} to leave: ");
        message = s.nextLine();
        while(!message.equalsIgnoreCase("leavechat")){
            showMessages(email, friendEmail);
            message = s.nextLine();
            addMessage(email, friendEmail, message);
        }
    }

    public void showMessages(String email,String friendEmail) {

        for(Account account : Accounts){
            if(account.getEmail().equals(email)){
                StoreMessage = account.getMessageList();
                for(StoreMessages accountMessages : StoreMessage){
                    if(accountMessages.getRecivedUser().equals(friendEmail)){
                        MessageList = accountMessages.getMessageHistory();
                        System.out.println("===================================================");
                        for(String message : MessageList){
                            System.out.println(message);
                        }
                    }    

                }
            }
        }

    }

    public void showMessageList(String email){
        for(Account account : Accounts){
            if(account.getEmail().equals(email)){
                StoreMessage = account.getMessageList();
                int num = 1;
                for(StoreMessages accountMessages : StoreMessage){
                    System.out.println("{"+ num + "} " + accountMessages.getRecivedUser() );
                    num++;
                }
            }
        }
    }

    





}
