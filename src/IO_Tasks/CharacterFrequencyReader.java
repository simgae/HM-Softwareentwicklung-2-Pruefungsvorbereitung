package IO_Tasks;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CharacterFrequencyReader extends FilterReader {


    Map<Character, Integer> analytics = new HashMap<>();

    /**
     * Creates a new filtered reader.
     *
     * @param in a Reader object providing the underlying stream.
     * @throws NullPointerException if {@code in} is {@code null}
     */
    protected CharacterFrequencyReader(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {

        int result = super.read();

        char character = (char) result;

        if(!analytics.containsKey(character))
            analytics.put(character, 1);
        else{
            int amount = analytics.get(character);
            analytics.put(character, amount + 1);
        }

        return result;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {

        int result = super.read(cbuf, off, len);

        for(Character character : cbuf){
            if(!analytics.containsKey(character))
                analytics.put(character, 1);
            else{
                int amount = analytics.get(character);
                analytics.put(character, amount + 1);
            }
        }

        return result;
    }

    @Override
    public String toString() {

        String result = "";

        int amountOfCharacter = analytics.values().stream().mapToInt(Integer::intValue).sum();

        for (Map.Entry<Character, Integer> entry : analytics.entrySet()){
            if(entry.getKey() != '\n')
                result += entry.getKey() + " \t | " + entry.getValue() + "\t | " + (double)(entry.getValue() / amountOfCharacter)*100 + "\t |\n";
        }

        return result;
    }
}

class Testing{

    public static void main(String[] args) throws IOException {

        try(FileReader reader = new FileReader(args[0]);
            CharacterFrequencyReader characterFrequencyReader = new CharacterFrequencyReader(reader);
            FileWriter writer = new FileWriter(args[1])){

            characterFrequencyReader.transferTo(writer);
            System.out.println(characterFrequencyReader);
        }

    }
}