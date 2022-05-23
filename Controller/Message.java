package Controller;

import java.util.Scanner;

import Model.Account;
import Model.StoreMessages;

import java.util.LinkedList;

public class Message extends Network {
    LinkedList <StoreMessages> StoreMessage = new LinkedList<>();
    LinkedList <String> MessageList = new LinkedList<>();
    Scanner s = new Scanner(System.in);

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

    public void sendMessage(String email, String friendEmail, String message) {
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

    public String showMessageList(String email){
        String messageList = "";
        for(Account account : Accounts){
            if(account.getEmail().equals(email)){
                StoreMessage = account.getMessageList();
                int num = 1;
                for(StoreMessages accountMessages : StoreMessage){
                    messageList += "{"+ num + "} " + accountMessages.getRecivedUser() + "\n";
                    num++;
                }
            }
        }
        return messageList;
    }



}
