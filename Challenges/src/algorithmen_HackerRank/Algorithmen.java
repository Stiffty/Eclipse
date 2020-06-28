package algorithmen_HackerRank;

import javax.swing.text.DateFormatter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algorithmen {
    public static int solveMeFirst(int a, int b) {
        // Hint: Type return a+b; below
        return a + b;
    }

    public static int simpleArraySum(int[] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i];
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
            if (an < bn) {
                resultb++;
            } else if (an > bn) {
                resulta++;
            }
        }
        result.add(resulta);
        result.add(resultb);
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
            sum1 += arr.get(i).get(i);
            sum2 += arr.get(i).get((arr.size() - 1) - i);
        }
        return Math.abs(sum1 - sum2);
    }

    public static void plusMinus(int[] arr) {
        double positive = 0;
        double negative = 0;
        double zero = 0;

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            if (number > 0) {
                positive++;
            } else if (number < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        double length = arr.length;
        System.out.println(positive / length);
        System.out.println(negative / length);
        System.out.println(zero / length);
    }

    public static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - 1) + i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }

    static void miniMaxSum(int[] arr) {
        long max = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    sum += arr[j];
                }
            }
            if (sum > max)
                max = sum;
            if (sum < min)
                min = sum;
        }
        System.out.println(min + " " + max);

    }

    static int birthdayCakeCandles(int[] ar) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > max) {
                max = ar[i];
            }
        }
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == max)
                count++;
        }
        return count;
    }

    static String timeConversion(String s) {
        String f = null;
        if (s.contains("P")) {
            String[] a = s.split(":");
            if (!a[0].equals("12")) {
                a[0] = String.valueOf(Integer.parseInt(a[0]) + 12);
            }
            f = a[0] + ":" + a[1] + ":" + a[2].split("P")[0];
        } else {
            String[] a = s.split(":");
            if (a[0].equals("12"))
                a[0] = "00";
            f = a[0] + ":" + a[1] + ":" + a[2].split("A")[0];
        }
        return f;
    }

    static String catAndMouse(int x, int y, int z) {
        int catA = Math.abs(z - x);
        int catB = Math.abs(z - y);
        if (catA > catB) {
            //b win
            return "Cat B";
        } else if (catA == catB) {
            //mouse
            return "Mouse C";
        } else {
            //a
            return "Cat A";
        }

    }

    static int formingMagicSquare(int[][] s) {
        int[][] erg = new int[s.length + 1][2];
        int[][] t = s.clone();
        erg[erg.length - 1][0] = 0;
        erg[erg.length - 1][1] = 0;

        for (int i = 0; i < s.length; i++) {
            int sum = 0;
            for (int j = 0; j < s[0].length; j++) {
                sum += s[i][j];
            }
            erg[i][0] = sum;
            sum = 0;
            for (int j = 0; j < s[0].length; j++) {
                sum += s[j][i];
            }
            erg[i][1] = sum;
            erg[erg.length - 1][0] += s[i][i];
            erg[erg.length - 1][1] += s[i][(s.length - 1) - i];

        }
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (erg[j][0] == 15 || erg[i][1] == 15 || (i == j && erg[erg.length - 1][0] == 15) || ((i == (s.length - 1) - j) && erg[erg.length - 1][1] == 15)) {
                    //s[i][j] =0;
                } else {
                    // s[i][j] = Math.abs(15-Math.max(erg[j][0], erg[i][1]));
                    s[i][j] = s[i][j] + (15 - Math.max(erg[j][0], erg[i][1]));
                }
            }
        }
        int erg3 = 0;
        for (int i = 0; i < erg.length; i++) {
            for (int j = 0; j < erg[0].length; j++) {
                System.out.print(erg[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                System.out.print(t[i][j] + "|");
                erg3 += Math.abs(t[i][j] - s[i][j]);
            }
            System.out.println();
        }
        return erg3;
    }

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        Collections.sort(a);
        int maxlength = 0;
        int length = 0;
        int value = -2;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == value) {
                length++;
            } else if (a.get(i) == value + 1) {
                length++;
            } else {

                length = 1;
                value = a.get(i);
            }
            if (length > maxlength)
                maxlength = length;
            System.out.println(length);
        }
        return maxlength;
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[alice.length];
        int place = 1;
        for (int i = 0; i < alice.length; i++) {
            for (int j = 0; j < scores.length; j++) {
                if (alice[i] >= scores[j]) {
                    result[i] = place ;
                    break;
                } else {
                    if(j == scores.length-1)
                        place++;
                    else if(scores[j+1] !=scores[j])
                        place++;
                }
                System.out.println(place);
            }
            result[i] = place;
            place = 1;
        }
        return result;
    }
}
