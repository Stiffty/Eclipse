package algorithmen_HackerRank;

import java.util.ArrayList;
import java.util.List;

public class Algorithmen {
    public static int solveMeFirst(int a, int b) {
        // Hint: Type return a+b; below
        return a+b;
    }

    public static int simpleArraySum(int[] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum+=ar[i];
        }
        return sum;
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int resulta = 0;
        int resultb = 0;
        for (int i = 0; i < a.size(); i++) {
            int an = a.get(i);
            int bn = b.get(i);
            if(an<bn){
                resultb++;
            }else if(an>bn){
                resulta++;
            }
        }
        result.add( resulta);
        result.add( resultb);
        return result;
    }

    private static long aVeryBigSum(long[] ar) {
    long result = 0;
        for (int i = 0; i < ar.length; i++) {
            result += ar[i];
        }
        return result;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum1+=arr.get(i).get(i);
            sum2+= arr.get(i).get((arr.size()-1)-i);
        }
        return Math.abs(sum1-sum2);
    }
}
