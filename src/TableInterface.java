import java.util.TreeMap;

/**
 * Created by SurfinBirb on 14.03.2017.
 */

public interface TableInterface {

    /**
     * Inserts point in the table
     * @param x The X coordinate of the new point
     * @param y The y coordinate of the new point
     */
    public void insert(int x, int  y);

    /**
     * Removes point from the table
     * @param x The X coordinate of the point
     * */
    public void delete(int x);

    /**
     * Returns the X coordinate of the nearest point
     * @param x The X coordinate of the point
     * */
    public int find(int x);

    /**
     * Returns the Y coordinate of the point using linear interpolation
     * @param x The X coordinate of the point
     * */
    public int linearInterpolation(int x);

    /**
     * Returns TreeMap contains all table points
     * */
    public TreeMap<Integer,Integer> getTable();

}
