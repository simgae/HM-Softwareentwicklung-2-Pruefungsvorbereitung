package Own_tasks;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class Backup_src {


    public static void main(String[] args) {

        String startPath = args[0];

        startBackup(startPath);

    }

    public static void startBackup(String pathname){

        Arrays.stream(Objects.requireNonNull(new File(pathname).listFiles()))
                .filter(File::isDirectory)
                .map(File::getAbsolutePath)
                .forEach(Backup_src::startBackup);

        Arrays.stream(Objects.requireNonNull(new File(pathname).listFiles()))
                .filter(File::isFile)
                .map(n -> new Thread(new CopyThread(n)))
                .forEach(Thread::start);
    }

}

