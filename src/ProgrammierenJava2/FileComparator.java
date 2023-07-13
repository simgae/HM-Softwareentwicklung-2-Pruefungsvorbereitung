package ProgrammierenJava2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileComparator implements Comparator<Path> {
    @Override
    public int compare(Path o1, Path o2) {

        File fst = o1.toFile();
        File snd = o2.toFile();

        int value = 0;

        if (!fst.exists() || !snd.exists())
            throw new IllegalArgumentException();

        if (!fst.isFile() ||!snd.isFile())
            throw new IllegalArgumentException();

        try(FileInputStream inputStreamFst = new FileInputStream(fst);
            FileInputStream inputStreamSnd = new FileInputStream(snd);
        ){
            int byteFst = 0;
            int byteSnd = 0;
            while ((byteFst =  inputStreamFst.read()) != -1 && (byteSnd =  inputStreamSnd.read()) != -1 && value == 0){
                value = Integer.compare(byteFst, byteSnd);
            }

            if (value == 0){
                if(inputStreamFst.readAllBytes().length > inputStreamSnd.readAllBytes().length)
                    value = -1;
                if (inputStreamFst.readAllBytes().length < inputStreamSnd.readAllBytes().length)
                    value = 1;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return value;
    }
}


class FileComparatorMain {
    public static void main(String[] args) {
        List<Path> list = new ArrayList<>();
        for(String arg: args)
            list.add(Paths.get(arg));
        Collections.sort(list, new FileComparator());
        System.out.println(list);
    }
}




