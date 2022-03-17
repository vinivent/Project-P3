
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReachMe {
    static Scanner scanner = new Scanner(System.in);
    static List<CreateAccount> accounts = new ArrayList<>();

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
            op = scanner.nextByte();

            switch (op) {
                case 1:
                    singUp();
                    break;
                case 2:
                    System.out.println("implementar log in");
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
        System.out.println("  =========================================================");
        System.out.println("        {1} CREATE ACCOUNT ~ {2} LOGIN ~ {0} Exit");
        System.out.print("                     Choose an option: ");
    }

    public static void singUp() {
        scanner.nextLine();
        System.out.println("EMAIL: ");
        String email = scanner.nextLine();
        while (insert_mail(email) == false) {
            System.out.println("Please insert a valid email.");
            System.out.println("EMAIL: ");
            email = scanner.nextLine();
        }
        System.out.println("USERNAME: ");
        String username = scanner.nextLine();
        System.out.println("PASSWORD: ");
        String password = scanner.nextLine();
        System.out.println("BIRTHDATE (dd/MM/yyyy): ");
        String birthdate = scanner.nextLine();
        while (isDate(birthdate) == false) {
            System.out.println("Please insert a valid birthdate.");
            System.out.println("BIRTHDATE (dd/MM/yyyy): ");
            birthdate = scanner.nextLine();
        }
        System.out.println("RELATIONSHIP: ");
        String relationship = scanner.nextLine();
        accounts.add(new CreateAccount(email, username, password, birthdate, relationship));
    }

    // VALIDATING METHODS.

    public static boolean isMail(String email) {
        String regex = "^(.)+@(.)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean insert_mail(String email) {
        if (!isMail(email)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isDate(String date) {
        String regex = "^[0-3]?[0-9]/[0-1]?[0-2]/(?:[0-9]{2})?[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);

        return matcher.matches();
    }

}