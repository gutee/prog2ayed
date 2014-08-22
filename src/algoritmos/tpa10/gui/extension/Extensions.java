package algoritmos.tpa10.gui.extension;

import java.io.File;

/* Utils.javaParser is used by FileChooserDemo2.javaParser. */
public class Extensions {
    final static String REG = "reg";

    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }
}
