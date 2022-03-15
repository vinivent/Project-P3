import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SocialMedia {
    static Scanner scanner = new Scanner(System.in);
    static List<CreateAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        byte op = 1;
        
        do {
            System.out.println("");
            menu();
            op = scanner.nextByte();

            switch (op) {
                case 0 -> System.out.println("See you soon.");
                case 1 -> System.out.println("1");// logIn();
                case 2 -> System.out.println("2");// singUp();
                case 3 -> System.out.println("3");// aaa
                default -> System.out.println("Insert a valid option.");

            }
            if (op == 1) {
                // chamar método para usuário efetuar log in.
                System.out.println("teste1");
            } else if (op == 2) {
                // chamar método para usuário criar conta.
                System.out.println("teste1");
            }
        } while (op != 0);

    }

    public static void menu() {
        System.out.printf("""
                 ===============
                 1 - Sing In;
                 2 - Create account;
                 0 - End Application.

                Choose an option:\040""");
    }
}