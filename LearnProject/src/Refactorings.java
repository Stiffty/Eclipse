import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Refactorings {
    public static final String TXT = "txt";

    public static void main(String[] args) throws IOException {
        String[] array = getStrings();
        Arrays.sort(array);
        for (String s : array) {
            System.out.println(s);
        }
    }

    private static String[] getStrings(FileReader in) throws IOException {

        FileReader in1 = in;
        BufferedReader reader = new BufferedReader(in1);
        ArrayList<String> lines = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines.toArray(new String[lines.size()]);
    }
}