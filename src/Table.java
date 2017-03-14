/**
 * Created by SurfinBirb on 02.03.2017.
 */

import java.util.*;
import static java.lang.Math.abs;

/**
 * The <code>Table</code> class defines a table, set of points in (x,y) coordinate space
 * */
public final class Table implements TableInterface {
    /**
     * Tree map container stores the table
     * */
     TreeMap<Integer,Integer> Table = new TreeMap<>();

    /**
    * Inserts point in the table
    * @param x The X coordinate of the new point
    * @param y The y coordinate of the new point
    */
    public void insert(int x, int  y) throws IllegalArgumentException{
        if(Table.containsKey(x)){throw new IllegalArgumentException("Already have point with " + x + " abscissa");}
        Table.put(x,y);
    }
    /**
     * Removes point from the table
     * @param x The X coordinate of the point
     * */
    public void delete(int x) throws IllegalArgumentException{
        if(!Table.containsKey(x)){throw new IllegalArgumentException("No point with " + x + " abscissa");}
        Table.remove(x);
    }

    /**
     * Returns the X coordinate of the nearest point
     * @param x The X coordinate of the point
     * */
    public int find(int x) throws IllegalStateException{
        int d;
        Integer[] KeyArray = Table.keySet().toArray(new Integer[Table.keySet().size()]);
        if(KeyArray.length == 0){throw new IllegalStateException("Table is empty");}
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

    /**
     * Returns the Y coordinate of the point using linear interpolation
     * @param x The X coordinate of the point
     * */
    public int linearInterpolation(int x)throws IllegalStateException{
        int current = 0;
        Integer[] KeyArray = Table.keySet().toArray(new Integer[Table.keySet().size()]);
        if(KeyArray.length<2){throw new IllegalStateException("Not enough points in the table");}
        for (int i = 0; i  < KeyArray.length-1; i++) {
            current=i;
            if(x<KeyArray[i+1]){break;}
        }
        return(Table.get(KeyArray[current]) + (Table.get(KeyArray[current+1]) - Table.get(KeyArray[current])) * (x - KeyArray[current]) / (KeyArray[current+1] - KeyArray[current]));

    }

    /**
     * Returns TreeMap contains all table points
     * */
    public TreeMap<Integer,Integer> getTable(){return Table;}

    /**
     * Returns a <code>String</code> represents the value of that <code>Table</code>
     * */
    @Override
    public String toString() {
        return "Table{" +
                "Table=" + Table.toString() +
                '}';
    }

    /**
     * Determines whether or not two tables are equal.
     * @param obj An object to be compared with this <code>Table</code>
     * @return <code>true</code> if the object to be compared is
     *         an instance of <code>Table</code> and has
     *         the same values; <code>false</code> otherwise.
     * */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Table table = (Table) obj;
        return Objects.equals(Table, table.Table);
    }

    /**
     * Returns the hashcode for this <code>Table</code>
     * @return A hash code for this <code>Table</code>
     * */
    @Override
    public int hashCode() {
        return Table.hashCode();
    }

}
