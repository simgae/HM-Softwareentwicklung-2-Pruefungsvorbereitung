package Task_12.f;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class FindDuplicates {
    public static void main(String[] args) {
        FindDuplicates duplicates = new FindDuplicates();

        System.out.println(duplicates.searchDuplicates(args[0]));

    }

    public Map<File, Long> searchDuplicates(String pathname) {
        List<File> files = getAllFiles(pathname);

        Map<File, Long> analytics = files.stream()
                .filter(File::isFile)
                .distinct()
                .collect(Collectors.toMap(
                        Function.identity(),
                        n -> files.stream()
                                .filter(p -> n.getName().equals(p.getName()))
                                .filter(p -> n.length() == p.length())
                                .count()));


        Map<File, Long> temp = Map.copyOf(analytics);

        for (Map.Entry<File, Long> entry: temp.entrySet()) {
            if(entry.getValue() < 2){
                analytics.remove(entry.getKey());
            } else
                System.out.println(entry);
        }
        System.out.println();


        return analytics;

    }


    private List<File> getAllFiles(String pathname) {

        File[] filesInThisDictionary = new File(pathname).listFiles();
        List<File> allFiles = new ArrayList<>();

        if (filesInThisDictionary != null) {
            for (File file : filesInThisDictionary) {

                if (file.isDirectory())
                    allFiles.addAll(getAllFiles(file.getAbsolutePath()));
                else
                    allFiles.add(file);
            }
        }

        return allFiles;
    }
}
