package encryptdecrypt;

public abstract class Algorithm {

    protected final int key;

    public Algorithm(int key)  {
        this.key = key;
    }

    public abstract String decryptMessage(String message);

    public abstract String encryptMessage(String message);
}
