package View;

import java.util.InputMismatchException;
import java.util.Scanner;
import Controller.Friends;
import Controller.Network;


public class FriendsPrint {

    static Scanner s = new Scanner(System.in);
    static Friends friend = new Friends();
    static Network account = new Network();

    public static void optionFriends(String email) {
        byte op = 9;

        do {
            try {
                op = s.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Insert a number");
                s.nextLine();
                op = 9;
            }
        } while (op == 9);

        switch (op) {
            case 1:
                System.out.print("Insert friend's email or LEAVE: ");
                s.nextLine();
                String friendEmail = s.nextLine();
                friendEmail = check(email, friendEmail);
                if(!friendEmail.equalsIgnoreCase("LEAVE")){
                    friend.sendInvite(email, friendEmail);
                    System.out.println("Invite sent to " + friend.getUser(friendEmail));
                }
                
                break;
            case 2:
                System.out.print("Insert friend's email:");
                friendEmail = s.next();
                
                while (email.equals(friendEmail)) {
                    System.out.println("You can't remove yourself.");
                    System.out.print("Insert friend's email: ");
                    friendEmail = s.next();
                    System.out.println("");
                    while(!account.searchAccount(friendEmail)){
                        System.out.println("Email not found");
                        friendEmail = s.nextLine();
                    }
                    
                }

                if (!friend.checkFriendList(email, friendEmail)) {
                    System.out.println("You don't have any friend with this email.");
                } else if(friend.findAccount(friendEmail)==null){
                    System.out.println("This email does not exist");
                }else{
                    friend.removeFriend(email, friendEmail);
                    System.out.println("You are no longer friends with " + friend.getUser(friendEmail));
                }
                break;
            case 3:
                System.out.println(friend.toStringFriendList(email));
                break;
            case 4:
                int quantRequest = friend.getNotifications(email);
                char option = 'y';
                while (option != 'n' && option != 'N' && quantRequest != 0) {
                    System.out.println("==PENDING==");
                    System.out.println(friend.toStringRequest(email));
                    System.out.print("If there are no friend requests type 'N' to leave. \nWould you like to answer a request? 'Y' or 'N': ");
                    option = s.next().charAt(0);
                    while (option != 'y' && option != 'Y' && option != 'n' && option != 'N') {
                        System.out.println("Insert a valid option.");
                        option = s.next().charAt(0); 
                        System.out.println("==========================");
                    }
                    if (option == 'y' || option == 'Y') {
                        System.out.print("Which request would you like to answer? (Insert Number): ");
                        int num = s.nextInt();
                        friendEmail = friend.respondRequests(email, num);
                        
                        System.out.print("Would you like to accept? 'Y' or 'N':");
                        option = s.next().charAt(0);
                        if (option == 'y' || option == 'Y') {
                            friend.confirmSolicitation(email, friendEmail);
                        }else {
                            System.out.println("REQUEST REJECTED");
                        }
                    }
                }
                break;
            default:
                System.out.println("Insert a valid option.");
                break;
        }
    }

    public static String check(String email, String friendEmail) {
        while(!friend.searchAccount(friendEmail) || friend.checkFriendList(email, friendEmail) || friend.checkRequestList(email, friendEmail) && !friendEmail.equalsIgnoreCase("LEAVE")){
                    
            if(!friend.searchAccount(friendEmail)){  
                System.out.println("Email not found try again or type {LEAVE}");
                friendEmail = s.nextLine();
            }
    
            if(friend.checkFriendList(email, friendEmail)) {
                System.out.println("You are already friend with this user try other email ");
                System.out.print("Insert friend's email or type {LEAVE} to leave: ");
                friendEmail = s.next();
            }
            if(friend.checkRequestList(email, friendEmail)) {
                System.out.println("You are already sent a friend request ");
                System.out.print("Insert friend's email or type {LEAVE} to leave: ");
                friendEmail = s.next();
            }
        }
        return friendEmail;
    }
    
}
