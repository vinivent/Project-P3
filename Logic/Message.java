package Logic;

import java.util.Scanner;
import java.util.LinkedList;

public class Message extends Network {
    LinkedList <StoreMessages> StoreMessage = new LinkedList<>();
    LinkedList <String> MessageList = new LinkedList<>();
    Scanner s = new Scanner(System.in);

    public void optionMessages(String email){
        showMessageList(email);
        int op=1;
        op = s.nextInt();
        
        
    }

    public void addMessage(String email, String friendEmail, String message) {
        
        for (Account Account : Accounts) {
            if (Account.getEmail().equals(email)) {
                StoreMessage = Account.getMessageList();
                for (StoreMessages accountMessages : StoreMessage) {
                    if (accountMessages.getRecivedUser().equals(friendEmail)) {
                        MessageList = accountMessages.getMessageHistory();
                        MessageList.add(message);
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
                        MessageList.add(message);
                        accountMessages.setMessageHistory(MessageList);
                    }
                }
            }
        }
        
    }

    public void sendMessage(String email, String friendEmail) {
        System.out.println("Write your message: ");
        s.nextLine();
        String message = s.nextLine();
        addMessage(email, friendEmail, message);
    }

    public void showMessages(String email, int num) {
        int position = 1;
        for(Account account : Accounts){
            if(account.getEmail().equals(email)){
                StoreMessage = account.getMessageList();
                for(StoreMessages accountMessages : StoreMessage){
                    position++;
                    if(position == num){
                        MessageList = accountMessages.getMessageHistory();
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
                    System.out.println("{"+ num + "} " + getUser(accountMessages.getRecivedUser()) );
                    num++;
                }
            }
        }
    }


    // for(Account account : Accounts){
    //     if(account.getEmail().equals(email)){
           
    //     }
    // }

}
