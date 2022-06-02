package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.Friends;
import Controller.Message;
import Controller.Network;
import Model.Account;
import Controller.EditAccount;

public class ReachMe {
    static Scanner s = new Scanner(System.in);
    static EditAccount editAccount = new EditAccount();
    static Network account = new Network();
    static Friends friend = new Friends();
    static Message message = new Message();

    public static void main(String[] args) {
        
        byte op = 9;

        do {
            System.out.println("");
            System.out.println("  ██████╗ ███████╗ █████╗  ██████╗██╗  ██╗███╗   ███╗███████╗");
            System.out.println("  ██╔══██╗██╔════╝██╔══██╗██╔════╝██║  ██║████╗ ████║██╔════╝");
            System.out.println("  ██████╔╝█████╗  ███████║██║     ███████║██╔████╔██║█████╗  ");
            System.out.println("  ██╔══██╗██╔══╝  ██╔══██║██║     ██╔══██║██║╚██╔╝██║██╔══╝  ");
            System.out.println("  ██║  ██║███████╗██║  ██║╚██████╗██║  ██║██║ ╚═╝ ██║███████╗");
            System.out.println("  ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝");
            System.out.println("             {ReachMe - a UNICAP Social Media}               ");
            menu1();

            do {
                try {
                    op = s.nextByte();
                } catch (InputMismatchException e) {
                    System.out.println("Enter a valid number");
                    s.nextLine();
                    op = 9;
                }
            } while (op == 9);

            switch (op) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    String email = logIn();
                    online(email);
                    break;
                case 0:
                    System.out.println("See you soon.");

                    break;
            }
        } while (op != 0);

    }

    public static void menu1() {
        System.out.println("");
        System.out.println("  ========================================================= ");
        System.out.println("        {1} CREATE ACCOUNT ~ {2} LOGIN ~ {0} Exit");
        System.out.print("                     Choose an option: ");
    }

    public static void welcome(String email) {
        String username = account.getUser(email);

        System.out.println("");
        System.out.println("  ██████╗ ███████╗ █████╗  ██████╗██╗  ██╗███╗   ███╗███████╗");
        System.out.println("  ██╔══██╗██╔════╝██╔══██╗██╔════╝██║  ██║████╗ ████║██╔════╝");
        System.out.println("  ██████╔╝█████╗  ███████║██║     ███████║██╔████╔██║█████╗ ");
        System.out.println("  ██╔══██╗██╔══╝  ██╔══██║██║     ██╔══██║██║╚██╔╝██║██╔══╝  ");
        System.out.println("  ██║  ██║███████╗██║  ██║╚██████╗██║  ██║██║ ╚═╝ ██║███████╗");
        System.out.println("  ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝");
        System.out.println("               {ReachMe - Welcome " + username + "}           ");

    }

    public static void menuOnline() {
        System.out.println("");
        System.out.println("  ========================================================= ");
        System.out.println("   {1} EDIT ACCOUNT ~ {2} FRIEND SECTION ~ {3} MESSAGES");
        System.out.println("              {4} SHOW PROFILE ~ {0} LOGOUT               ");
        System.out.print("                       Choose an option: ");
        System.out.print("");
    }

    public static void menuFriends(String email) {
        System.out.println("");
        System.out.println("  ========================================================= ");
        System.out.println("     {1} ADD FRIEND ~ {2} REMOVE FRIEND ~ {3} SHOW FRIENDS");
        System.out.println("                      {4} NOTIFICATIONS [" + account.getNotifications(email) + "]");
        System.out.print("                        Choose an option: ");
        System.out.print("");
    }

    public static void separator() {
        System.out.println("===================================================");
    }

    public static void online(String email) {
        byte op = 9;

        do {
            welcome(email);
            menuOnline();

            do {
                try {
                    op = s.nextByte();
                } catch (InputMismatchException e) {
                    System.out.println("Escreva um Número");
                    s.nextLine();
                    op = 9;
                }
            } while (op == 9);

            switch (op) {
                case 1:
                    editAcc(email);
                    break;
                case 2:
                    menuFriends(email);
                    optionFriends(email);
                    break;
                case 3:
                System.out.println("Insert friend's Email or type {LEAVECHAT} to leave:");
                String friendEmail=s.next();
                while(!friend.searchAccount(friendEmail)){
                    System.out.println("This account doesn't exist. Try again.");
                    friendEmail = s.next();
                }
                    optionMessages(email, friendEmail);
                    break;
                case 4:
                    profile(email);
                    break;
                case 0:
                    System.out.println("See you soon.");
                    break;

                default:
                    System.out.println("Insert a valid option");
                    break;
            }

        } while (op != 0);

    }

    public static void createAccount() {
        System.out.println("EMAIL: ");
        s.nextLine();
        String email = s.nextLine();
        while (!account.isMail(email) || !account.insert_mail(email)) {
            if (!account.isMail(email)) {
                System.out.println("========================");
                System.out.println("Please insert a valid email.");
                System.out.print("EMAIL: ");
                email = s.nextLine();
            } else {
                System.out.println("========================");
                System.out.println("This email is already registered");
                System.out.println("Please insert a valid email.");
                System.out.print("EMAIL: ");
                email = s.nextLine();

            }
        }
        System.out.println("========================");
        System.out.print("USERNAME: ");
        String username = s.nextLine();
        System.out.println("========================");
        System.out.print("PASSWORD: ");
        String password = s.nextLine();
        System.out.println("========================");
        System.out.println("DD/MM/YYYY");
        System.out.println("BIRTHDATE: ");
        String birthdate = s.nextLine();
        while (!account.isDate(birthdate)) {
            System.out.println("Insert a valid birthdate");
            System.out.println("DD/MM/YYYY");
            System.out.println("BIRTHDATE: ");
            birthdate = s.nextLine();
        }
        account.createAccount(email, username, password, birthdate);
    }

    public static String logIn() {
        System.out.println("Insert your email: ");
        s.nextLine();
        String email = s.nextLine();
        while (account.findAccount(email) == null) {
            System.out.print("Email not registered, try again: ");
            email = s.nextLine();
        }
        System.out.println("========================");
        System.out.println("PASSWORD: ");
        String password = s.nextLine();
        while (!account.searchPassword(email, password)) {
            System.out.println("Invalid password");
            password = s.nextLine();
        }

        return email;
    }

    // Testes
    public static void profile(String email) {
        System.out.println();
        Account accountTest = account.findAccount(email);
        if (accountTest.getEmail().equals(email)) {
            System.out.println("===========================");
            System.out.println("Username: " + accountTest.getUsername());
            System.out.println("Birthdate: " + accountTest.getBirthdate());
            System.out.println("Relationship: " + accountTest.getRelationship());
            System.out.println("Bio: " + accountTest.getDescription());
            System.out.println("===========================");

        }

    }

    // Edit account
    public static void editAcc(String email) {
        byte op = 9;
        System.out.println("=========================");
        System.out.println("What you want to edit?");
        System.out.println("{1} Username ");
        System.out.println("{2} Password");
        System.out.println("{3} Birthdate");
        System.out.println("{4} Relationship");
        System.out.println("{5} Add Description");
        System.out.println("{0} Back to menu");
        System.out.println("=========================");
        System.out.print("Choose an option: ");

        do {
            try {
                op = s.nextByte();
            } catch (InputMismatchException e) {
                System.out.println("Escreva um Número");
                s.nextLine();
                op = 9;
            }
        } while (op == 9);

        switch (op) {
            case 1:
                char option = 'n';
                String newUsername = "";

                do {
                    System.out.println("enter the new username: ");
                    s.nextLine();
                    newUsername = s.nextLine();
                    System.out.println(newUsername + " Is correct? 'Y' or 'N'");
                    option = s.next().charAt(0);
                } while (option != 'y' && option != 'Y');

                editAccount.editUser(email, newUsername);
                break;
            case 2:
                String oldPassword = "", newPassword = "";

                System.out.println("Insert the old Password");
                oldPassword = s.next();

                while (editAccount.searchPassword(email, oldPassword)) {
                    System.out.println("Invalid password");
                    oldPassword = s.nextLine();
                }

                System.out.println("Insert the new Password");
                newPassword = s.next();
                while (oldPassword.equals(newPassword)) {
                    System.out.println("the new password cannot be the same as the old one");
                    newPassword = s.next();
                }

                editAccount.editPassword(email, newPassword);

                break;
            case 3:
                String birthdate = "";
                System.out.println("Insert the new birthdate");
                System.out.println("DD/MM/YYYY");
                birthdate = s.nextLine();
                while (!editAccount.isDate(birthdate)) {
                    System.out.println("Insert a valid birthdate");
                    System.out.println("DD/MM/YYYY");
                    System.out.print("BIRTHDATE: ");
                    birthdate = s.nextLine();
                }
                editAccount.editBirth(email, birthdate);
                break;
            case 4:
                byte opt = 9;
                System.out.println("=========================");
                System.out.println("What you want to edit?");
                System.out.println("{1} Dating");
                System.out.println("{2} Married");
                System.out.println("{3} Single");
                System.out.println("{0} Back to menu");
                System.out.println("=========================");

                do {
                    try {
                        op = s.nextByte();
                    } catch (InputMismatchException e) {
                        System.out.println("Escreva um Número");
                        s.nextLine();
                        op = 9;
                    }
                } while (op == 9);

                switch (opt) {
                    case 1:
                        editAccount.editRelatioship(email, "Dating");
                        break;
                    case 2:
                        editAccount.editRelatioship(email, "Married");
                        break;
                    case 3:
                        editAccount.editRelatioship(email, "Single");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Insert a valid option");
                        break;
                }
                break;
            case 5:
                System.out.println("Insert your description: ");
                s.nextLine();
                String description = s.nextLine();
                editAccount.editDescription(email, description);
                System.out.println("Bio added.");
                break;
            case 0:
                break;

            default:
                System.out.println("Insert a valid option");
                break;
        }

    }

    // Friends

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
    public static void optionMessages(String email, String friendEmail){
        message.showMessageList(email);
        if(!friendEmail.equalsIgnoreCase("leavechat")){
            System.out.println("Write your message or type {LEAVECHAT} to leave: ");
            String messages="";
            messages = s.nextLine();
            message.sendMessage(email, friendEmail, messages);
         }
    }

}