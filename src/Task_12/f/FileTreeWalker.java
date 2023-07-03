package Task_12.f;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 12f. Filetree Walker
 * Das folgende Programm durchläuft einen Verzeichnisbaum und verarbeitet
 * alle Dateien mit der Methode process, die in diesem Beispiel nur den Namen
 * und die Dateilänge ausgibt.
 * import java.io.*;
 * class FileTreeWalker {
 * public static void main(String[ ] args) throws IOException {
 * new FileTreeWalker().walk(args[0]);
 * }
 * void walk(String pathname) throws IOException {
 * File[ ] files = new File(pathname).listFiles();
 * if(files != null)
 * for(File file: files)
 * if(file.isDirectory())
 * walk(file.getCanonicalPath());
 * else
 * process(file.getCanonicalPath(), (int)file.length());
 * }
 * void process(String name, int length) {
 * System.out.printf("%-70s%9d%n", name, length);
 * }
 * }
 * Modifizieren Sie das Programm so, dass es die Dateien nach fallender
 * Länge sortiert ausgibt.
 * Erstellen Sie eine andere Variante des Programms, das "Duplikate" findet.
 * Duplikate sind Dateien mit gleichen Namen in unterschiedlichen Verzeichnissen.
 * Wahlweise sollen nur Duplikate mit gleicher Länge berücksichtigt werden.
 */
class FileTreeWalker {
    public static void main(String[] args) throws IOException {
        FileTreeWalker walker = new FileTreeWalker();

        List<File> files = walker.walk(args[0]);

        files.stream().sorted((o1, o2) -> Long.compare(o2.length(), o1.length())).forEach(n -> {
            try {
                walker.process(n.getCanonicalPath(), (int) n.length());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }


    List<File> walk(String pathname) throws IOException {
        File[] files = new File(pathname).listFiles();
        List<File> allFiles = new ArrayList<>();

        if (files != null)
            for (File file : files)
                if (file.isDirectory())
                    allFiles.addAll(walk(file.getCanonicalPath()));
                else
                    allFiles.add(file);

        return allFiles;
    }

    void process(String name, int length) {
        System.out.printf("%-70s%9d%n", name, length);
    }
}
