package Utils;

import org.apache.commons.lang.LocaleUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    private static Date date = new Date();

    public static String getToday(String s) {
        return new SimpleDateFormat(s).format(date);
    }

    public static String getTodayWithLocale() throws IOException {
        return new SimpleDateFormat(ConfigReader.util().getString("dateFormat2"),
                LocaleUtils.toLocale(ConfigReader.util().getString("LocaleEnglish"))).format(date).toLowerCase();
    }


}
