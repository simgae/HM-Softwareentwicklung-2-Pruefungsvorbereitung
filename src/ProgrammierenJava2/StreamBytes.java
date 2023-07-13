package ProgrammierenJava2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class StreamBytes implements Iterable<Byte>{

    private final InputStream inputStream;
    private final byte[] bytes;


    public StreamBytes(InputStream inputStream){
        this.inputStream = inputStream;


        try {
            bytes = inputStream.readAllBytes();
            inputStream.close();
        } catch (IOException e) {
            throw new IllegalStateException();

        }

    }

    @Override
    public Iterator<Byte> iterator() {
        return new Iterator<Byte>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < bytes.length;
            }

            @Override
            public Byte next() {

                Byte value = bytes[index];
                index++;

                return value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}



class StreamBytesMain {
    public static void main(String... args) throws IOException {
        try(InputStream input = new FileInputStream(args[0])) {

            for(byte code: new StreamBytes(input))
                System.out.print((char)code);

            StreamBytes streamBytes = new StreamBytes(input);
            Iterator<Byte> iterator = streamBytes.iterator();
            try {
                iterator = streamBytes.iterator();
                throw new AssertionError("should have failed before!");
            }
            catch(IllegalStateException ex) {
                System.out.println("OK");
            }
        }
    }
}