package C2;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class c10 {

    public static void main(String[] args) {

        int month = 5;
        int day = 8;
        int year = 2015;

        Calendar c = Calendar.getInstance();

        c.set(year, month-1, day);
        // Date d = new Date(year,month,day);
        int weekday = c.get(Calendar.DAY_OF_WEEK);

        DateFormatSymbols dfs = new DateFormatSymbols();

        System.out.println(dfs.getWeekdays()[weekday].toUpperCase());
    }
}
