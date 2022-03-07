package util;

import java.io.IOException;

public class Util {

    public static void getDriverUrl(String key) {
      Driver.getInstance().get(SupportingReader.config().getString(key));
    }
    public static void manageDriver(){
        Driver.getInstance().manage().window().maximize();
    }

    public static void getDriver(){
        Driver.getInstance();
    }
    public static void quitDriver(){
        Driver.quitDriver();
    }

    public static int cleanText(String text){
        return Integer.parseInt(text.replaceAll("\\D", ""));
    }
}
