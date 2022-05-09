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

            do{
                try{
                op = s.nextByte();
                }catch(InputMismatchException e){
                    System.out.println("Escreva um Número");
                    s.nextLine();
                    op=9;
                }
            }while(op==9);
            

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
                default:
                    System.out.println("Insert a valid option.");
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

    public static void online(String email) {
        byte op = 9;

        do {
            welcome(email);
            menuOnline();

            do{
                try{
                op = s.nextByte();
                }catch(InputMismatchException e){
                    System.out.println("Escreva um Número");
                    s.nextLine();
                    op=9;
                }
            }while(op==9);


            switch (op) {
                case 1:
                    editAccount.editAcc(email);
                    break;
                case 2:
                    menuFriends(email);
                    friend.optionFriends(email);
                    break;
                case 3:
                    message.optionMessages(email);
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
        while(!account.isMail(email) || !account.insert_mail(email)){
            if(!account.isMail(email)){
                System.out.println("========================");
                System.out.println("Please insert a valid email.");
                System.out.print("EMAIL: ");
                email = s.nextLine();
            }else{
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
        while(account.findAccount(email) == null){
            System.out.print("Email not registered, try again: ");
            email = s.nextLine();
        }
        System.out.println("========================");
        System.out.println("PASSWORD: ");
        String password = s.nextLine();
        while(!account.searchPassword(password)){
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
}