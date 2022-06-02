package Controller;

public final class Singleton {

    private static Singleton instance;
    public String email;

    private Singleton(String email){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.email = email;
    }

    public static Singleton getInstance(String email){
        if(instance == null){
            instance = new Singleton(email);
        }
        return instance;
    }
    
}
