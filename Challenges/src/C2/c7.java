package C2;

import java.util.Scanner;

public class c7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 1;
        while (sc.hasNext()){
            System.out.printf("%s %s%n",counter,sc.nextLine());
            counter++;
        }
    }
}
