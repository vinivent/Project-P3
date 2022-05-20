package Controller;

import java.util.Scanner;

import Model.Account;
import Model.StoreMessages;

import java.util.LinkedList;

public class Friends extends Network {
    LinkedList<Account> FriendList = new LinkedList<>();
    LinkedList<Account> RequestList = new LinkedList<>();
    LinkedList<StoreMessages> MessageList = new LinkedList<>();
    Scanner s = new Scanner(System.in);

    public boolean addFriend(String email, String friendEmail) {

        for (Account Account : Accounts) {
            if (Account.getEmail().equals(email)) {
                FriendList = Account.getFriendList();
                for (Account friendAccount : Accounts) {
                    if (friendAccount.getEmail().equals(friendEmail)) {
                        FriendList.add(friendAccount);
                        Account.setFriendList(FriendList);
                        MessageList = Account.getMessageList();
                        StoreMessages startChat= new StoreMessages(friendEmail);
                        MessageList.add(startChat);
                        Account.setMessageList(MessageList);
                    }
                }
            }
            if (Account.getEmail().equals(friendEmail)) {
                FriendList = Account.getFriendList();
                for (Account friendAccount : Accounts) {
                    if (friendAccount.getEmail().equals(email)) {
                        FriendList.add(friendAccount);
                        Account.setFriendList(FriendList);
                        MessageList = Account.getMessageList();
                        StoreMessages startChat= new StoreMessages(email);
                        MessageList.add(startChat);
                        Account.setMessageList(MessageList);
                    }
                }
            }
        }
        return true;
    }

    public boolean removeFriend(String email, String friendEmail) {        
        for (Account Account : Accounts) {
            if (Account.getEmail().equals(email)) {
                FriendList = Account.getFriendList();
                for (Account friendAccount : FriendList) {
                    if (friendAccount.getEmail().equals(friendEmail)) {
                        FriendList.remove(friendAccount);
                        Account.setFriendList(FriendList);
                        return true;
                    }
                }
                return false;
            }
            if (Account.getEmail().equals(friendEmail)) {
                FriendList = Account.getFriendList();
                for (Account friendAccount : FriendList) {
                    if (friendAccount.getEmail().equals(email)) {
                        FriendList.remove(friendAccount);
                        Account.setFriendList(FriendList);
                        return true;
                    }
                }
                return false;
            }
        }
        return true;

    }

    public void sendInvite(String email, String friendEmail) {
            for (Account account : Accounts) {
                if (account.getEmail().equals(friendEmail)) {
                    RequestList = account.getRequestsList();
                    for (Account FriendAccount : Accounts) {
                        if (FriendAccount.getEmail().equals(email)) {
                            RequestList.add(FriendAccount);
                            account.setRequestsList(RequestList);
                        }
                    }

                }
            }
        
    }

    public void confirmSolicitation(String email, String friendEmail) {
        addFriend(email, friendEmail);
        for (Account account : Accounts) {
            if (account.getEmail().equals(email)) {

                RequestList = account.getRequestsList();
                for (Account FriendAccount : Accounts) {
                    if (FriendAccount.getEmail().equals(friendEmail)) {

                        RequestList.remove(FriendAccount);
                        account.setRequestsList(RequestList);

                    }
                }

            }
        }

    }

    public String respondRequests(String email, int num) {
        int position = 0;
        for (Account account : Accounts) {
            if (account.getEmail().equals(email)) {
                RequestList = account.getRequestsList();
                for (Account requestAccount : RequestList) {
                    position++;
                    if (position == num) {
                        return requestAccount.getEmail();
                    }
                }
            }
        }
        return "";
    }

    public boolean checkFriendList(String email, String friendEmail){
        for(Account account: Accounts){
            if(account.getEmail().equals(email)){
                FriendList  = account.getFriendList();
                for(Account friendAccount : FriendList){
                    if(friendAccount.getEmail().equals(friendEmail)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkRequestList(String email, String friendEmail) {
        for (Account account : Accounts) {
            if (account.getEmail().equals(friendEmail)) {
                FriendList = account.getRequestsList();
                for (Account friendAccount : FriendList) {
                    if (friendAccount.getEmail().equals(email)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean testEmails(String email, String secondEmail){
        return email.equals(secondEmail);
    }

    public String toStringRequest (String email){
        String list = "";
        for (Account account : Accounts) {
            if (account.getEmail().equals(email)) {
                RequestList = account.getRequestsList();
                int num = 1;
                for (Account requestAccount : RequestList) {
                    list += "{" + num + "} " + requestAccount.getEmail() + " | " + getUser(requestAccount.getEmail()) + " - Sent you a request. \n";
                    num++;
                }
            }
        }
        return list;
    }

    public String toStringFriendList(String email){
        String list = "";
        for (Account Account : Accounts) {
            if (Account.getEmail().equals(email)) {
                FriendList = Account.getFriendList();
                int num = 0;
                for (Account friendAccount : FriendList) {
                    String friendEmail = friendAccount.getEmail();
                    num++;
                    list += "{" + num + "} " + friendAccount.getEmail() + " | " + getUser(friendEmail)+"\n";
                }
                if (num == 0) {
                    return "You don't have any friends.";
                }
            }
        }
        return list;
    }
    
    
}
