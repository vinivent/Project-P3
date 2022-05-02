package Controller;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Account;

public class Network {
    protected static LinkedList<Account> Accounts = new LinkedList<Account>();

    static Scanner s = new Scanner(System.in);

    // Create account
    public void createAccount() {

        System.out.println("EMAIL: ");
        String email = s.nextLine();
        while (!insert_mail(email)) {
            System.out.println("========================");
            System.out.println("Please insert a valid email.");
            System.out.print("EMAIL: ");
            email = s.nextLine();
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
        while (!isDate(birthdate)) {
            System.out.println("Insert a valid birthdate");
            System.out.println("DD/MM/YYYY");
            System.out.println("BIRTHDATE: ");
            birthdate = s.nextLine();
        }
        Account a = new Account(email, username, password, birthdate);
        Accounts.add(a);

    }

    // Edit ACCOUNT
    public void editAccount(String email) {
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
                char option = 'n';
                String newUsername = "";
               
                do {
                    System.out.println("enter the new username: ");
                    s.nextLine();
                    newUsername = s.nextLine();
                    System.out.println(newUsername + " Is correct? 'Y' or 'N'");
                    option = s.next().charAt(0);
                } while (option != 'y' && option != 'Y');

                for (Account account : Accounts) {
                    if ((account.getEmail()).equals(email)) {
                        account.setUsername(newUsername);

                    }
                }
                break;
            case 2:
                String oldPassword = "", newPassword = "";

                System.out.println("Insert the old Password");
                oldPassword = s.next();
                checkPassword(oldPassword);
                System.out.println("Insert the new Password");
                newPassword = s.next();
                while (oldPassword.equals(newPassword)) {
                    System.out.println("the new password cannot be the same as the old one");
                    newPassword = s.next();
                }
                for (Account account : Accounts) {
                    if (account.getEmail().equals(email)) {
                        account.setPassword(newPassword);
                    }
                }

                break;
            case 3:
                String birthdate = "";
                System.out.println("Insert the new birthdate");
                System.out.println("DD/MM/YYYY");
                birthdate = s.nextLine();
                while (!isDate(birthdate)) {
                    System.out.println("Insert a valid birthdate");
                    System.out.println("DD/MM/YYYY");
                    System.out.print("BIRTHDATE: ");
                    birthdate = s.nextLine();
                }
                for (Account account : Accounts) {
                    if (account.getEmail().equals(email)) {
                        account.setBirthdate(birthdate);
                    }
                }
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

                do{
                    try{
                    op = s.nextByte();
                    }catch(InputMismatchException e){
                        System.out.println("Escreva um Número");
                        s.nextLine();
                        op=9;
                    }
                }while(op==9);

                switch (opt) {
                    case 1:
                        for (Account account : Accounts) {
                            if (account.getEmail().equals(email)) {
                                account.setRelationship("Dating");
                            }
                        }
                        break;
                    case 2:
                        for (Account account : Accounts) {
                            if (account.getEmail().equals(email)) {
                                account.setRelationship("Married");
                            }
                        }
                        break;
                    case 3:
                        for (Account account : Accounts) {
                            if (account.getEmail().equals(email)) {
                                account.setRelationship("Single");
                            }
                        }
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
                for (Account account : Accounts) {
                    if (account.getEmail().equals(email)) {
                        account.setDescription(description);
                    }
                }
               System.out.println("Bio added.");
                break;
            case 0:
                break;

            default:
                System.out.println("Insert a valid option");
                break;
        }

    }

    // LogIn
    public String logIn() {
        System.out.println("Insert your email: ");
        String email = s.nextLine();
        checkAccount(email);
        System.out.println("========================");
        System.out.println("PASSWORD: ");
        String password = s.nextLine();
        checkPassword(password);
        return email;
    }

    // Testes
    public void Profile(String email) {
        System.out.println();
        for (Account account : Accounts) {
            if ((account.getEmail()).equals(email)) {
                System.out.println("===========================");
                System.out.println("Username: " + account.getUsername());
                System.out.println("Birthdate: " + account.getBirthdate());
                System.out.println("Relationship: " + account.getRelationship());
                System.out.println("Bio: " + account.getDescription());
                System.out.println("===========================");

            }
        }

    }

    public boolean insert_mail(String email) {
        if (!isMail(email)) {
            return false;
        } else {
            for (Account account : Accounts) {
                if ((account.getEmail()).equals(email)) {
                    System.out.println("This email is already registered");
                    return false;
                }
            }
            return true;
        }
    }

    public boolean isMail(String email) {
        String regex = "^(.)+@(.)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    // isDate aprender regex
    public boolean isDate(String date) {
        String regex = "^[0-3]?[0-9]/[0-1]?[0-2]/(?:[0-9]{2})?[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);

        return matcher.matches();
    }

    public String checkAccount(String emailAd) {

        int registered = searchAccount(emailAd);
        while (registered == -1) {
            System.out.print("Email not registered, try again: ");
            emailAd = s.nextLine();
            registered = searchAccount(emailAd);
        }
        return emailAd;

    }

    public int searchAccount(String email) {
        for (Account account : Accounts) {
            if ((account.getEmail()).equals(email)) {
                return 1;
            }
        }
        return -1;
    }

    public int searchPassword(String password) {
        for (Account account : Accounts) {
            if ((account.getPassword()).equals(password)) {
                return 1;
            }
        }
        return -1;
    }

    public int checkPassword(String passwordUser) {

        int registered = searchPassword(passwordUser);
        while (registered == -1) {
            System.out.println("Invalid password, try again.");
            passwordUser = s.nextLine();
            registered = searchPassword(passwordUser);
        }
        return registered;
    }

    public String getUser(String email) {
        for (Account account : Accounts) {
            if (account.getEmail().equals(email)) {
                String tempName;
                if (account.getUsername().equals("")) {
                    tempName = "Guest" + (int) (1 + Math.random() * 999999);
                    account.setUsername(tempName);
                }
                return account.getUsername();
            }
        }
        return null;
    }

    public int getNotifications(String email) {
        for (Account account : Accounts) {
            if (account.getEmail().equals(email)) {
                return account.getNotifications();
            }
        }
        return 0;
    }




}