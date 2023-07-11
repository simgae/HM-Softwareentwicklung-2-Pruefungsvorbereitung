package Own_tasks;

import Task_13.b.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileWatcher {

    private final Path start;

    public FileWatcher(Path start){
        this.start = start;
    }

    private static List<File> getAllFiles(Path pathname){
        Objects.requireNonNull(pathname);

        File[] files = new File(pathname.toUri()).listFiles();
        List<File> result = new ArrayList<>();

        if(files != null)
            for (File file : files){
                if (file.isFile())
                    result.add(file);
                else{
                    result.addAll(getAllFiles(file.toPath()));
                }
            }

        return result;
    }


    public void detectChanges(){
        List<File> files = getAllFiles(start);

        List<Pair<File, FileTime>> information = files.stream()
                .map(n -> {
                    try {
                        return new Pair<>(n, Files.getLastModifiedTime(n.toPath()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();

        while (true){

            information.stream()
                    .filter(n -> {
                        try {
                            return !n.getSndElement().equals(Files.getLastModifiedTime(n.getFstElement().toPath()));
                        } catch (IOException ignored) {
                        }
                        return false;
                    })
                    .peek(n -> {
                        try {
                            n.setSndElement(Files.getLastModifiedTime(n.getFstElement().toPath()));
                        } catch (IOException ignored) {
                        }
                    })
                    .forEach(System.out::println);

        }
    }


}

class Testing{
    public static void main(String[] args) {

        FileWatcher fileWatcher = new FileWatcher(Path.of(args[0]));
        fileWatcher.detectChanges();


    }
}
