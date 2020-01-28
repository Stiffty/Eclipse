package C2;

import java.util.Scanner;

public class c5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();

        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            for (int j = 0; j < n; j++) {
                int x = 0;
                for (int k = 0; k < j+1; k++) {
                   //System.out.println((Math.pow(2,k)*b));
                    x+=((Math.pow(2,k))*b);
                }
                System.out.print((x +a) + " ");
            }
            System.out.println();
        }
    }
}
