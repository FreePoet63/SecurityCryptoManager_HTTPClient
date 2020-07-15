import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HTTP {
    public static void main(String[] args) throws IOException {
        URLConnection connection = new URL("https://superhero.qa-test.csssr.com/superheroes").openConnection();

        Map<String, List<String>> headerFields = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            System.out.println(entry.getKey() + "/" +entry.getValue());
        }
    }
}
