package Controller;

import java.util.InputMismatchException;

import Model.Account;

public class EditAccount extends Network {
    
   
    public void editAcc(String email) {
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

                while(searchPassword(oldPassword)){
                    System.out.println("Invalid password");
                    oldPassword = s.nextLine();
                }

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
}
