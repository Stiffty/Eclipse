package hackMe1;

public class Main {
   private int eins = 90;

    public Main() {
        int zwei = 30;
        while (true) {
            System.out.println(eins + zwei);
            zwei++;
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
