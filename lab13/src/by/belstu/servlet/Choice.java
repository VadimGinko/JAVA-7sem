package by.belstu.servlet;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Choice {
    public String[] getChoices(String dirPath, String extension) {
        String[] choices = null;
        File dir = new File(dirPath);
        if (dir.exists()) {
            choices = dir.list(new FileFilter(extension));
        }
        Log.info(Arrays.toString(choices));
        return choices;
    }

    protected static class FileFilter implements FilenameFilter {
        private final String extension;

        public FileFilter(String extension) {
            this.extension = "." + extension;
        }

        public boolean accept(File dir, String name) {
            return name.endsWith(extension);
        }
    }
}