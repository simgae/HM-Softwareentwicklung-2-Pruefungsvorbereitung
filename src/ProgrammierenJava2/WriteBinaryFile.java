package ProgrammierenJava2;

import java.io.FileWriter;
import java.io.IOException;

public class WriteBinaryFile {

    public static void main(String... args) {

        try (
                FileWriter fileWriter = new FileWriter("10");
        ) {
            for (String arg : args) {
                String[] token = arg.split("x");
                int num = Integer.parseInt(token[0]);
                int code = Integer.parseInt(token[1]);

                while (num-- > 0)
                    fileWriter.write(code);
            }
            fileWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
