package C2;

import java.util.Scanner;

public class c4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            System.out.printf("%s x %s = %s%n",n,i+1,n*(i+1));
        }
    }
}
