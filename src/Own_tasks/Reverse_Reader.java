package Own_tasks;

import java.io.*;

public class Reverse_Reader {


    public static void main(String[] args) throws IOException {

        try(FileReader reader = new FileReader(args[0]);
            BufferedReader buffReader = new BufferedReader(reader);
            FileWriter writer = new FileWriter("./src/Own_tasks/reversed.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer)){


            buffReader.lines().sorted((o1, o2) -> -1).forEach(n -> {
                try {
                    bufferedWriter.write(n);
                    bufferedWriter.newLine();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        }
    }
}