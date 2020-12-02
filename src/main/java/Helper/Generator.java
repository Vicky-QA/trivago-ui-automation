package Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Generator {

    public static String generateEmail() {
        String geEmail = "Unique" + generateNumber() + "@mail.com";
        return geEmail;
    }

    public static String generateUserName() {
        String gePassword = "User" + generateNumber();
        return gePassword;
    }

    public static String generatePassword() {
        String gePassword = "Pass!" + generateNumber();
        return gePassword;
    }

    public static String generateNumber() {
        String dataGen = new SimpleDateFormat("HHmmss").format(new Date());
        return dataGen;
    }

}
