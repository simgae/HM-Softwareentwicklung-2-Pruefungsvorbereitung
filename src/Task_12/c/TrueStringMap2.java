package Task_12.c;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class TrueStringMap2 implements StringMap2{

    private final Map<String, Map<String, String>> table;

    public TrueStringMap2(){
        table = new HashMap<>();
    }

    @Override
    public String put(String row, String column, String value) {

        table.computeIfAbsent(row, k -> new HashMap<>());

        Map<String, String> mapRow = table.get(row);

        return mapRow.put(column, value);
    }

    @Override
    public String get(String row, String col) {

        Map<String, String> mapRow = table.get(row);

        String value = null;

        if(Objects.nonNull(mapRow))
            value = mapRow.get(col);

        return value;
    }

    @Override
    public int size() {

        int values = 0;

        for (Map<String, String> row: table.values()){
            values += row.size();
        }

        return values;
    }

    @Override
    public int size(String row) {

        Map<String, String> mapRow = table.get(row);

        int result = 0;
        if(mapRow != null)
            result = mapRow.size();

        return result;
    }

    @Override
    public boolean contains(String row, String col) {

        boolean result = false;

        Map<String, String> mapRow = table.get(row);

        if(mapRow != null)
            result = mapRow.containsKey(col);

        return result;
    }

    @Override
    public Set<String> keySet() {
        return table.keySet();
    }

    @Override
    public Set<String> keySet(String row) {
        return table.get(row).keySet();
    }

    @Override
    public String toString() {
        return "TrueStringMap2{" +
                "table=" + table +
                '}';
    }

    public static void main(String[] args) {
        StringMap2 stringMap2 = new TrueStringMap2();
        System.out.println(stringMap2);
        System.out.println(stringMap2.put("Test Row", "Test Column", "Value"));
        System.out.println(stringMap2);
        stringMap2.put("Test Row", "Test 2", "Value");
        System.out.println(stringMap2);
        stringMap2.put("Test 2", "Test 2", "Value");
        System.out.println(stringMap2);
        System.out.println(stringMap2.get("Test Row", "Test 2"));
        System.out.println(stringMap2.size());
        System.out.println(stringMap2.size("Test Row"));
        System.out.println(stringMap2.contains("Test Row", "Test 2"));
        System.out.println(stringMap2.keySet());
        System.out.println(stringMap2.keySet("Test 2"));
    }
}
