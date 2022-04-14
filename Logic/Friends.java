package Logic;

import java.util.Scanner;
import java.util.LinkedList;

public class Friends extends Network {
    LinkedList<Account> FriendList = new LinkedList<>();
    LinkedList<Account> RequestList = new LinkedList<>();
    Scanner s = new Scanner(System.in);

    public void optionFriends(String email) {
        byte op = 0;
        op = s.nextByte();
        switch (op) {
            case 1:
                System.out.print("Insert friend's email: ");
                String friendEmail = s.next();
                sendInvite(email, friendEmail);
                System.out.println("Invite sent to " + getUser(friendEmail));
                break;
            case 2:
                System.out.print("Insert friend's email:");
                friendEmail = s.next();

                if (!removeFriend(email, friendEmail)) {
                    System.out.println("You don't have any friend with this email.");
                } else {
                    System.out.println("You are no longer friends with " + getUser(friendEmail));
                }
                break;
            case 3:
                showFriends(email);
                break;
            case 4:
                int quantRequest=1;
                char option = 'y';
                while (option != 'n' && option != 'N' && quantRequest!=0) {
                    showRequests(email);
                        System.out.print("Would you like to answer a request? 'Y' or 'N': ");
                        option = s.next().charAt(0);
                        if (option != 'y' && option != 'Y' && option != 'n' && option != 'N') {
                            System.out.println("Insert a valid option.");
                            System.out.println("==========================");
                        }
                        if (option == 'y' || option == 'Y') {
                            System.out.println("Which request would you like to answer? (Insert Number)");
                            int num = s.nextInt();
                            friendEmail = respondRequests(email, num);
                            confirmSolicitation(email, friendEmail);
                        }
                            for(Account account :Accounts){
                                if(account.getEmail().equals(email)){
                                    quantRequest = account.getNotifications();
                                }
                            }
                }
                break;
            default:
                System.out.println("Insert a valid option.");
                break;
        }
    }

    public void addFriend(String email, String friendEmail) {

        for (Account Account : Accounts) {
            if (Account.getEmail().equals(email)) {
                FriendList = Account.getFriendList();
                for (Account friendAccount : Accounts) {
                    if (friendAccount.getEmail().equals(friendEmail)) {
                        FriendList.add(friendAccount);
                        Account.setFriendList(FriendList);
                        System.out.println("Now you're friends with " + getUser(friendEmail));
                    }
                }
            }
            if (Account.getEmail().equals(friendEmail)) {
                FriendList = Account.getFriendList();
                for (Account friendAccount : Accounts) {
                    if (friendAccount.getEmail().equals(email)) {
                        FriendList.add(friendAccount);
                        Account.setFriendList(FriendList);
                    }
                }
            }
        }
    }

    public boolean removeFriend(String email, String friendEmail) {
        friendEmail = checkAccount(friendEmail);
        while (email.equals(friendEmail)) {
            System.out.println("You can't remove yourself.");
            System.out.print("Insert friend's email: ");
            friendEmail = s.next();
            System.out.println("");
            friendEmail = checkAccount(friendEmail);
        }
        for (Account Account : Accounts) {
            if (Account.getEmail().equals(email)) {
                FriendList = Account.getFriendList();
                for (Account friendAccount : FriendList) {
                    if (friendAccount.getEmail().equals(friendEmail)) {
                        FriendList.remove(friendAccount);
                        Account.setFriendList(FriendList);
                        return true;
                    }
                }
                return false;
            }
            if (Account.getEmail().equals(friendEmail)) {
                FriendList = Account.getFriendList();
                for (Account friendAccount : FriendList) {
                    if (friendAccount.getEmail().equals(email)) {
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

    public void showFriends(String email) {

        for (Account Account : Accounts) {
            if (Account.getEmail().equals(email)) {
                FriendList = Account.getFriendList();
                int num = 0;
                for (Account friendAccount : FriendList) {
                    String friendEmail = friendAccount.getEmail();
                    num++;
                    System.out.println("{" + num + "} " + friendAccount.getEmail() + " | " + getUser(friendEmail));
                }
                if (num == 0) {
                    System.out.println("You don't have any friends.");
                }
            }
        }
    }

    public void sendInvite(String email, String friendEmail) {
        friendEmail = checkAccount(friendEmail);
        while (email.equals(friendEmail)) {
            System.out.println("You can't add yourself.");
            System.out.print("Insert friend's email: ");
            friendEmail = s.next();
            System.out.println("");
            friendEmail = checkAccount(friendEmail);
           
        }

        for (Account account : Accounts) {
            if (account.getEmail().equals(friendEmail)) {
                RequestList = account.getRequestsList();
                for (Account FriendAccount : Accounts) {
                    if (FriendAccount.getEmail().equals(email)) {
                        RequestList.add(FriendAccount);
                        account.setRequestsList(RequestList);
                    }
                }

            }
        }
    }

    public void confirmSolicitation(String email, String friendEmail) {
        char option;
        System.out.print("Would you like to accept? 'Y' or 'N':");
        option = s.next().charAt(0);
        if (option == 'y' || option == 'Y') {
            addFriend(email, friendEmail);
        } else {
            System.out.println("REQUEST REJECTED");
        }

        for (Account account : Accounts) {
            if (account.getEmail().equals(email)) {

                RequestList = account.getRequestsList();
                for (Account FriendAccount : Accounts) {
                    if (FriendAccount.getEmail().equals(friendEmail)) {

                        RequestList.remove(FriendAccount);
                        account.setRequestsList(RequestList);

                    }
                }

            }
        }

    }

    public void showRequests(String email) {
        for (Account account : Accounts) {
            if (account.getEmail().equals(email)) {
                RequestList = account.getRequestsList();
                int num = 1;
                for (Account requestAccount : RequestList) {
                    System.out.println("{" + num + "} " + requestAccount.getEmail() + " | "
                            + getUser(requestAccount.getEmail()) + " - Sent you a request.");
                    System.out.println("");
                    num++;
                }
            }
        }
    }

    public String respondRequests(String email, int num) {
        int position = 0;
        for (Account account : Accounts) {
            if (account.getEmail().equals(email)) {
                RequestList = account.getRequestsList();
                for (Account requestAccount : RequestList) {
                    position++;
                    if (position == num) {
                        return requestAccount.getEmail();
                    }
                }
            }
        }
        return "";
    }

}
