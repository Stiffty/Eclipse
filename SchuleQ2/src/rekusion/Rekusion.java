package rekusion;

public class Rekusion {

    public Rekusion() {
        callME(0);
    }

    public static void main(String[] args) {
        Rekusion rekusion = new Rekusion();
    }

    public void callME(int i) {
        if (i < 10) {
            System.out.printf("First: %s%n",i);
            callME(i+=1);
            System.out.printf("Second: %s%n",i);
        }
    }
}
