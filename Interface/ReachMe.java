package Interface;

import java.util.Scanner;

import Logic.Friends;
import Logic.Message;
import Logic.Network;

public class ReachMe {
    static Scanner s = new Scanner(System.in);
    static Network account = new Network();
    static Friends friend = new Friends();
    static Message message = new Message();

    public static void main(String[] args) {
        byte op = 1;

        do {
            System.out.println("");
            System.out.println("  ██████╗ ███████╗ █████╗  ██████╗██╗  ██╗███╗   ███╗███████╗");
            System.out.println("  ██╔══██╗██╔════╝██╔══██╗██╔════╝██║  ██║████╗ ████║██╔════╝");
            System.out.println("  ██████╔╝█████╗  ███████║██║     ███████║██╔████╔██║█████╗ ");
            System.out.println("  ██╔══██╗██╔══╝  ██╔══██║██║     ██╔══██║██║╚██╔╝██║██╔══╝  ");
            System.out.println("  ██║  ██║███████╗██║  ██║╚██████╗██║  ██║██║ ╚═╝ ██║███████╗");
            System.out.println("  ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝");
            System.out.println("             {ReachMe - a UNICAP Social Media}                  ");
            menu1();
            op = s.nextByte();

            switch (op) {
                case 1:
                    account.createAccount();
                    // conta.String();
                    break;
                case 2:
                    String email = account.logIn();
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
        Scanner s = new Scanner(System.in);
        byte op = 1;

        do {
            welcome(email);
            menuOnline();
            op = s.nextByte();

            switch (op) {
                case 1:
                    account.editAccount(email);
                    break;
                case 2:
                    menuFriends(email);
                    friend.optionFriends(email);
                    break;
                case 3:
                    message.optionMessages(email);
                    break;
                case 4:
                    account.Profile(email);
                    break;
                case 0:
                    System.out.println("See you soon.");
                    ;
                    break;

                default:
                    System.out.println("Insert a valid option");
                    break;
            }

        } while (op != 0);
        s.close();

    }

}