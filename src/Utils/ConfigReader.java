package Utils;

import org.json.*;
//import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {

    public JSONObject js;

    public static JSONObject util() throws IOException {
        String propertyFilePath = "configs/Config.json";
        try (
                BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
            String file;
            StringBuilder temp = new StringBuilder();
            while ((file = reader.readLine()) != null) {
                temp.append(file);
            }
            return new JSONObject(temp.toString());
        }
    }
}