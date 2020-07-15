import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class GETRequest {
    public static void main(String[] args) throws IOException {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            CloseableHttpResponse response = client.execute(new HttpGet("https://superhero.qa-test.csssr.com/superheroes/63"));

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String data = IOUtils.toString(entity.getContent(), "UTF-8");

                System.out.println("Data: " + data);
            }
            System.out.println();
            for (Header header : response.getAllHeaders()) {
                System.out.println(header.getName() + ":" + header.getValue());
            }
            System.out.println();
            System.out.println("Protocol version: " + response.getProtocolVersion());
            System.out.println("Status code: " + response.getStatusLine().getStatusCode());
            System.out.println("Reason phrase: " + response.getStatusLine().getReasonPhrase());
            System.out.println("Status line: " + response.getStatusLine().toString());

        } catch (Throwable cause) {
            cause.fillInStackTrace();

        }
    }
}



