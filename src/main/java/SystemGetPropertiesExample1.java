import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.security.*;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Logger;

import static java.lang.System.getProperty;

public class SystemGetPropertiesExample1<bytes> extends Policy {
    static Random r = new Random();

    public SystemGetPropertiesExample1() throws NoSuchAlgorithmException {
    }

    static String getToken() {
        return Integer.toString(r.nextInt());
    }


    public static void main(String[] args) throws AccessControlException, LoginException, SQLException, UnsupportedEncodingException, MalformedURLException, InterruptedException, LoginException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        System.setProperty("java.security.policy", "src/MyApp_Policy");
        System.setProperty("java.security.auth.login.config", "src/Name_Config");
        System.setSecurityManager(new SecurityManager());
        System.out.println(System.getSecurityManager());
        System.out.println(Security.getProviders());
        System.out.println("21:33");
        System.out.println(System.nanoTime());
        System.out.println(getProperty("os.name"));
        System.out.println(getProperty("os.version"));
        System.out.println(getProperty("path.separator"));
        System.out.println(Logger.getLogger("myLogger"));
        System.out.println(getToken());
        System.out.println(getToken());
        System.out.println(getToken());

        PrivilegedAction action = new PrivilegedAction() {
            public Object run() {
                System.out.println(System.getProperty("os.name"));
                return new Object();
            }
        };

        LoginContext context = new LoginContext("Login999");
        context.login();
        Subject subject = context.getSubject();
        System.out.println("Natasha Terekhova");
        Subject.doAsPrivileged(subject, action, null);
        context.logout();

        String str = "Natasha";
        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        MessageDigest md5 = null;
        md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(str.getBytes());
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        System.out.println(builder.toString());
        String S = "Natasha";
        Cipher cipher = Cipher.getInstance("RSA");
        KeyPairGenerator pairgen = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = pairgen.generateKeyPair();
        Key publicKey = keyPair.getPublic();
        Key privateKey = keyPair.getPrivate();

        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] bytes99 = cipher.doFinal(S.getBytes());
        for (byte b : bytes99) {
            System.out.print(b);
        }
        System.out.println("\n");

        Cipher decriptCipher = Cipher.getInstance("RSA");
        decriptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] descriptedBytes = decriptCipher.doFinal(bytes99);
        for (byte b : descriptedBytes) {
            System.out.print((char) b);
        }
    }
}




