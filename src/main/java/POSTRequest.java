import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class POSTRequest {
    public static void main(String[] args) throws IOException {
        POSTRequest.Json_Request();
    }

    private static void Json_Request() throws IOException {
        String url = "https://superhero.qa-test.csssr.com/superheroes";
        String JsoN = "{\"id\":30,\"fullName\":\"Doctor Nata\"," +
                "\"birthDate\":\"1963-07-18\",\"city\":\"Moscow\"," +
                "\"mainSkill\":\"Magic\",\"gender\":\"W\",\"phone\":null}";
        try {
            URL url5 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url5.openConnection();
            conn.setConnectTimeout(7000);
            conn.setRequestProperty("Content-type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");

            OutputStream os = conn.getOutputStream();
            os.write(JsoN.getBytes("UTF-8"));
            os.close();

            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in,"UTF-8");

            System.out.println(result);

            System.out.println("result after Reading JSON Response");


            JSONObject myResponse = new JSONObject(result);
            System.out.println("id- " + myResponse.getInt("id"));
            System.out.println("fullName- " + myResponse.getString("fullName"));

            in.close();
            conn.disconnect();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
