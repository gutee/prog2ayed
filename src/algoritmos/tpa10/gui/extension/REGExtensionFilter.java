package algoritmos.tpa10.gui.extension;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Javier
 * Date: 2/22/12
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class REGExtensionFilter extends FileFilter {


    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Extensions.getExtension(f);
        return (extension != null) && (extension.equals(Extensions.REG));

    }

    public String getDescription() {
        return "*.reg";
    }
}
