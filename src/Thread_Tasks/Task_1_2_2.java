package Thread_Tasks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public class Task_1_2_2 {


    public static void main(String[] args) {

        Thread thread1 = new Thread(new FileChangeWatcher("TimeUnits.java"));
        thread1.start();
    }
}


record FileChangeWatcher(String filename) implements Runnable {
    @Override
    public void run() {

        Path path = Path.of(filename);
        Path thisFile = Path.of("Task_1_2_2.java");
        File file = path.toFile();
        FileTime fileTime;

        try {
            fileTime = Files.getLastModifiedTime(thisFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (true) {

            try {
                if (!fileTime.equals(Files.getLastModifiedTime(path))){
                    System.out.println("Filename: " + file.getName() + " ::: File size: " + file.getTotalSpace() + " ::: Modified: " + Files.getLastModifiedTime(path));
                    fileTime = Files.getLastModifiedTime(path);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
}
