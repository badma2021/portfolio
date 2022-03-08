package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;

public class SupportingReader {

    public static String getProperty(String path) {
        String propertyFilePath = null;

        switch (path) {
            case "config":
                propertyFilePath = "supporting_data/Config.json";
                break;
            case "test":
                propertyFilePath = "supporting_data/Test.json";
                break;
        }
        return propertyFilePath;
    }

    public static JSONObject config(String data) {
        StringBuilder temp = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(getProperty(data)))) {
            String file;

            while ((file = reader.readLine()) != null) {
                temp.append(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject(temp.toString());
    }
}
