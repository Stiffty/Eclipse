package C2;

import java.util.Scanner;

public class c8 {
    private static Scanner sc = new Scanner(System.in);

    private static int B = sc.nextInt();
    private static int H = sc.nextInt();
    private static boolean flag = false;

    static {
        if ((B <= 0) || (H <= 0)) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }else {
            flag = true;
        }
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}//end of class
