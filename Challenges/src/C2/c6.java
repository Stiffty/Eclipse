package C2;

import java.util.Scanner;

public class c6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        for (int j = 0; j < c; j++) {

            long in = 0;
            String y = null;
            try {
                y = sc.next();
                in = Long.parseLong(y);

                boolean b = false;
                boolean s = false;
                boolean i = false;
                boolean l = false;

                if (in > -127 && in <= 127) {
                    //byte
                    b = true;
                }
                if (in >= -Math.pow(2, 15) && in <= Math.pow(2, 15) - 1) {
                    //short
                    s = true;
                }
                if (in >= -Math.pow(2, 31) && in <= Math.pow(2, 31) - 1) {
                    //int
                    i = true;
                }
                if (in >= -Math.pow(2, 63) && in <= Math.pow(2, 63) - 1) {
                    //long
                    l = true;
                }


                System.out.printf("%s can be fitted in:%n", in);

                if (b) {
                    System.out.println("* byte");
                }
                if (s) {
                    System.out.println("* short");
                }
                if (i) {
                    System.out.println("* int");
                }
                if (l) {
                    System.out.println("* long");
                }

            } catch (Exception e) {
                System.out.printf("%s can't be fitted anywhere.%n", y);
            }
        }
    }
}