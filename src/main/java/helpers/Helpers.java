package helpers;

import java.io.File;

public class Helpers {
    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }
}
