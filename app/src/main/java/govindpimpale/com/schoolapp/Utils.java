package govindpimpale.com.schoolapp;

import java.io.File;

public class Utils {
    public static void rm(String path)
    {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }
}
