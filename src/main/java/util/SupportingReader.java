package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;

public class SupportingReader {

    public static JSONObject config() {
        String propertyFilePath = "supporting_data/Config.json";
        StringBuilder temp = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
            String file;

            while ((file = reader.readLine()) != null) {
                temp.append(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject(temp.toString());
    }

    public static JSONObject test()  {
        String propertyFilePath = "supporting_data/Test.json";
        StringBuilder temp = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
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



