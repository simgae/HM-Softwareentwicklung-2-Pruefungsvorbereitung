package Own_tasks;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public record CopyThread(File file) implements Runnable {
    @Override
    public void run() {

        try (FileReader fileReader = new FileReader(file.getAbsolutePath());
             FileWriter fileWriter = new FileWriter("./backup_src/" + file.getName() + "_backup.txt")
        ) {
            fileReader.transferTo(fileWriter);
            System.out.println("Writing: "+ "./backup_src/" + file.getName() + "_backup.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
