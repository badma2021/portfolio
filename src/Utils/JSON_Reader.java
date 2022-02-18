package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class JSON_Reader {

    public static Object[][] getData(String JSON_path, String JSON_data, int JSON_attributes) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader((JSON_path)));
        org.json.simple.JSONObject jo = (JSONObject) obj;
        org.json.simple.JSONArray js = (JSONArray) jo.get(JSON_data);
        Object[][] arr = new String[js.size()][JSON_attributes];
        for (int i = 0; i < js.size(); i++) {
            JSONObject obj1 = (JSONObject) js.get(i);

            arr[i][0] = String.valueOf(obj1.get("UserNumber"));

            arr[i][1] = String.valueOf(obj1.get("FirstName"));

            arr[i][2] = String.valueOf(obj1.get("LastName"));
            arr[i][3] = String.valueOf(obj1.get("Email"));
            arr[i][4] = String.valueOf(obj1.get("Age"));
            arr[i][5] = String.valueOf(obj1.get("Salary"));
            arr[i][6] = String.valueOf(obj1.get("Department"));
        }

        return arr;
    }

}
