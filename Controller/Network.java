package Controller;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Account;

public class Network {
    protected static LinkedList<Account> Accounts = new LinkedList<Account>();

    static Scanner s = new Scanner(System.in);

    // Create account
    public void createAccount(String email,String username, String password, String birthdate) {
        Account a = new Account(email, username, password, birthdate);
        Accounts.add(a);

    }



    public boolean insert_mail(String email) {
            for (Account account : Accounts) {
                if ((account.getEmail()).equals(email)) {
                    return false;
                }
            }
            return true;
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

    public boolean searchAccount(String email) {
        for (Account account : Accounts) {
            if ((account.getEmail()).equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchPassword(String password) {
        for (Account account : Accounts) {
            if ((account.getPassword()).equals(password)) {
                return true;
            }
        }
        return false;
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

    public Account findAccount(String email){
        for(Account account : Accounts){
            if(account.getEmail().equals(email)){
                return account;
            }
        }
        return null;
    }




}