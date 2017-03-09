/**
 * Created by SurfinBirb on 02.03.2017.
 */

import java.util.*;
import static java.lang.Math.abs;

public final class Table {
     Map<Integer,Integer> Table = new TreeMap<>();

    public void insert(int x, int  y){
        if(Table.containsKey(x)){
            throw new IllegalArgumentException("Already have point with " + x + " abscissa");
        }
        Table.put(x,y);
    }

    public void delete(int x){
        if(!Table.containsKey(x)){
            throw new IllegalArgumentException("No point with " + x + " abscissa");
        }
        Table.remove(x);
    }

    public int find(int x){
        int d;
        Integer[] KeyArray = Table.keySet().toArray(new Integer[Table.keySet().size()]);
        if(KeyArray.length == 0){throw new IllegalArgumentException("Table is empty");}
        int min = abs(x - KeyArray[0]);
        int result = KeyArray[0];
        for (int key: KeyArray) {
            d = abs(key - x);
            if (d < min) {
                min = d;
                result = key;
            }
        }
        return result;
    }

    public int linearInterpolation(int x){
        int current = 0;
        Integer[] KeyArray = Table.keySet().toArray(new Integer[Table.keySet().size()]);
        if(KeyArray.length<2){throw new IllegalArgumentException("Not enough points in the table");}
        for (int i = 0; i  < KeyArray.length-1; i++) {
            current=i;
            if(x<KeyArray[i+1]){break;}
        }
        return(Table.get(KeyArray[current]) + (Table.get(KeyArray[current+1]) - Table.get(KeyArray[current])) * (x - KeyArray[current]) / (KeyArray[current+1] - KeyArray[current]));

    }

    @Override
    public String toString() {
        return "Table{" +
                "Table=" + Table.toString() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Table table = (Table) obj;
        return Objects.equals(Table, table.Table);
    }

    @Override
    public int hashCode() {
        return Table.hashCode();
    }

}
