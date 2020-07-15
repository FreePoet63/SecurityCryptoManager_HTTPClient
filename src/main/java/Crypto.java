import javax.crypto.*;
import javax.security.auth.login.LoginException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.security.AccessControlException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class Crypto {
    public static void main(String[] args) throws AccessControlException, LoginException, SQLException, UnsupportedEncodingException, MalformedURLException, InterruptedException, LoginException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        String st = "Selenium WebDriver";

        Cipher cipher = Cipher.getInstance("AES");

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(256);
        SecretKey key = kgen.generateKey();

        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] bytes19 = cipher.doFinal(st.getBytes());
        for (byte b : bytes19) {
            System.out.print(b);
        }
        System.out.println("\n");

        Cipher decriptCipher = Cipher.getInstance("AES");
        decriptCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decriptedBytes = decriptCipher.doFinal(bytes19);
        for (byte b : decriptedBytes) {
            System.out.print((char) b);
        }
    }

}
