package Own_tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Count_Words_of_File {

    public static void main(String[] args) throws IOException {

        try(FileReader reader = new FileReader(args[0]);
            BufferedReader buffReader = new BufferedReader(reader)){


            long wordCount = buffReader.lines().flatMap(n -> Arrays.stream(n.split(" "))).count();

            System.out.println(wordCount);

        }

        try(FileReader reader = new FileReader(args[0]);
            BufferedReader buffReader = new BufferedReader(reader)){


            long lineCount = buffReader.lines().count();

            System.out.println(lineCount);

        }

    }
}
