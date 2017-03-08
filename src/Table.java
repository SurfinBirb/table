/**
 * Created by SurfinBirb on 02.03.2017.
 */

import java.util.*;

import static java.lang.Math.abs;

public final class Table {
     Map<Integer,Integer> Table = new TreeMap<>();

    void insert(int x, int  y){
        if(Table.containsKey(x)){
            throw new ArithmeticException("Already contains x");
        }else
        Table.put(x,y);
    }

    void delete(int x){
        if(!Table.containsKey(x)){
            throw new ArithmeticException("No point with "+x+" abscissa");
        }
        Table.remove(x);
    }

    int find(int x) {
        int d;
        Integer[] KeyArray = Table.keySet().toArray(new Integer[Table.keySet().size()]);
        int min = abs(x - KeyArray[0]);
        int result = KeyArray[0];
        for (int key: KeyArray) {
            d = Math.abs(key - x);
            if (d < min) {
                min = d;
                result = key;
            }
        }
        return result;
    }

    int linearInterpolation(int x){
        int result=0;
        Integer[] KeyArray = Table.keySet().toArray(new Integer[Table.keySet().size()]);
        for (int i = 0; i  < KeyArray.length-1; i++) {
            result = (Table.get(KeyArray[i]) + (Table.get(KeyArray[i+1]) - Table.get(KeyArray[i])) * (x - KeyArray[i]) / (KeyArray[i+1] - KeyArray[i]));
            if(x<KeyArray[i+1]){break;}
        }
        return result;
    }

    @Override
    public String toString() {
        return "Table{" +
                "Table=" + Table +
                '}';
    }
}

