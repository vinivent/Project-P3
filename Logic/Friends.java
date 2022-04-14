package Logic;

import java.util.Scanner;
import java.util.LinkedList;

public class Friends extends Network {
    LinkedList <Account> FriendList = new LinkedList<>();
    Scanner s = new Scanner(System.in);
    

    public void addFriend(String email, String friendEmail){
        
        for(Account Account : Accounts){
            if(Account.getEmail().equals(email)){
                FriendList = Account.getFriendList();
                for(Account friendAccount : Accounts){
                   if(friendAccount.getEmail().equals(friendEmail)){
                       FriendList.add(friendAccount);
                       Account.setFriendList(FriendList);
                       System.out.println("Now you're friend with " + getUser(email));
                   }   
                }
            }
            if(Account.getEmail().equals(friendEmail)){
                FriendList = Account.getFriendList();
                for(Account friendAccount : Accounts){
                   if(friendAccount.getEmail().equals(email)){
                       FriendList.add(friendAccount);
                       Account.setFriendList(FriendList);
                   }   
                }
            }  
        }
    }

    public boolean removeFriend(String email, String friendEmail){
        friendEmail = checkAccount(friendEmail);
        while(email.equals(friendEmail)){
            System.out.println("You can't remove yourself.");
            System.out.print("Insert friend's email: ");
            friendEmail = s.next();
            System.out.println("");
            friendEmail = checkAccount(friendEmail);
        }
        for(Account Account : Accounts){
            if(Account.getEmail().equals(email)){
                FriendList = Account.getFriendList();
                for(Account friendAccount : FriendList){
                      if(friendAccount.getEmail().equals(friendEmail)){
                          FriendList.remove(friendAccount);
                          Account.setFriendList(FriendList);
                          return true;
                      }
                }
                return false;
            } 
            if(Account.getEmail().equals(friendEmail)){
                FriendList = Account.getFriendList();
                for(Account friendAccount : FriendList){
                      if(friendAccount.getEmail().equals(email)){
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

    public void showFriends(String email){
        
        for(Account Account : Accounts){
          if(Account.getEmail().equals(email)){
              FriendList = Account.getFriendList();
              int num = 0;
              for(Account friendAccount : FriendList){
                    String friendEmail = friendAccount.getEmail();
                    num++;
                    System.out.println("{" + num + "} " +  friendAccount.getEmail() + " | " + getUser(friendEmail));
              }
              if(num == 0){
                  System.out.println("You don't have any friends.");
              }
          }  
        }
    }

    public void optionFriends(String email){
        byte op = 0;
        op = s.nextByte();
        switch (op) {
            case 1:
                System.out.print("Insert friend's email: ");
                String friendEmail = s.next();
                addFriend(email, friendEmail);
                break;
            case 2:
                System.out.print("Insert friend's email:");
                friendEmail = s.next();

               if(!removeFriend(email, friendEmail)){ 
                    System.out.println("You don't have any friend with this email.");
                }else{
                    System.out.println("You are no longer friends with " + getUser(friendEmail));
                }
                break;
            case 3:
                showFriends(email);
                break;
            default:
                System.out.println("Insert a valid option.");
                break;
        }
    }

    public void sendInvite(String email, String friendEmail){
        friendEmail = checkAccount(friendEmail);
        while(email.equals(friendEmail)){
            System.out.println("You can't add yourself.");
            System.out.print("Insert friend's email: ");
            friendEmail = s.next();
            System.out.println("");
            friendEmail = checkAccount(friendEmail);
        }
        System.out.println("");


    }
    
    public void confirmSolicitation(String email, String friendEmail) {
        System.out.println("NEW NOTIFICATION!!!");
        char option;

        System.out.println(getUser(friendEmail) + " sent you a friend request");
        System.out.println("would you like to accept? 'Y' or 'N'");
        option = s.next().charAt(0);
        if(option == 'y'|| option == 'Y'){
            addFriend(email, friendEmail);
        }else{
            System.out.println("REQUEST REJECTED");
        }
        
        
    }


}
