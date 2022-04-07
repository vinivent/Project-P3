package Logic;


public class AddFriend {

    private Account friend;
    private Account addedFriend;

    public AddFriend(Account friend, Account addedFriend){
        this.friend = friend;
        this.addedFriend = addedFriend;
    }

    public Account getFriend() {
        return friend;
    }

    public void setFriend(Account friend) {
        this.friend = friend;
    }

    public Account getAddedFriend() {
        return addedFriend;
    }

    public void setAddedFriend(Account addedFriend) {
        this.addedFriend = addedFriend;
    }
    
}
