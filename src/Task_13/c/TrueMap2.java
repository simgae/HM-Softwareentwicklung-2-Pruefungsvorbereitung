package Task_13.c;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TrueMap2<T, U, V> implements Map2<T, U, V> {

    Map<T, Map<U, V>> table = new HashMap<>();


    @Override
    public V put(T row, U column, V value) {

        table.computeIfAbsent(row, k -> new HashMap<>());

        Map<U, V> mapRow = table.get(row);

        return mapRow.put(column, value);
    }

    @Override
    public V get(T row, U col) {

        Map<U,V> column = table.get(row);

        return column.get(col);
    }

    @Override
    public int size() {

        int size = 0;

        for(Map<U,V> map : table.values())
            size += map.size();

        return size;
    }

    @Override
    public int size(T row) {
        return table.get(row).size();
    }

    @Override
    public boolean contains(T row, U col) {

        Map<U,V> map = table.get(row);

        return map.containsKey(col);
    }

    @Override
    public Set<T> keySet() {
        return table.keySet();
    }

    @Override
    public Set<U> keySet(T row) {
        return table.get(row).keySet();
    }

    @Override
    public String toString() {
        return "TrueMap2{" +
                "table=" + table +
                '}';
    }
}
