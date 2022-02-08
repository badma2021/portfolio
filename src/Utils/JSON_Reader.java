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

    @DataProvider(name = "registration data")
    public Object[][] passData() throws IOException, ParseException {
       // System.out.println("hi from passdata");
       // System.out.println(JSON_Reader.getData("C:/Users/Observer/IdeaProjects/Demoqa/src/Testing_data.json", "Registration data", 7));
        return JSON_Reader.getData("C:/Users/Observer/IdeaProjects/Demoqa/src/Testing_data.json", "Registration data", 7);
        //return null;
    }

    @Test(dataProvider = "registration data")
   // public void userRegistration(int UserID) throws Exception
    public void userRegistration(int UserID, String FirstName,String LastName, String Email, int Age, int Salary, String Department) throws Exception
    {
        System.out.println(FirstName);

    }


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
