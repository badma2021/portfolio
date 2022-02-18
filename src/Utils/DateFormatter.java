package Utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class DateFormatter {
private static Locale locale;
    private static Date date = new Date();
    //private DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
   // private String today = new SimpleDateFormat("MM/dd/yyyy").format(date);

    public static String getToday(String s) {
        return new SimpleDateFormat(s).format(date);
    }
    public static String getTodayWithLocale() throws IOException {
        return new SimpleDateFormat("MMMM dd, yyyy h:mm aa", Locale.forLanguageTag(ConfigReader.util().getString("LocaleEnglish"))).format(date);
    }


}
