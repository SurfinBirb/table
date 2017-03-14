import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * Created by SurfinBirb on 17.02.2017.
 */
public class TableTest {
    @Test
    public void ChangesTest(){
        Table funct = new Table();
        funct.insert(12,13);
        funct.insert(4,6);
        funct.insert(5,7);
        funct.insert(10,11);
        funct.delete(10);
        assertEquals("Table{Table={4=6, 5=7, 12=13}}",funct.toString());
    }
    @Test
    public void FindTest(){
        Table funct = new Table();
        funct.insert(12,13);
        funct.insert(3,6);
        funct.insert(5,7);
        assertEquals(12,funct.find(16));
    }
    @Test
    public void LinearInterpolationTest(){
        Table funct = new Table();
        funct.insert(12,13);
        funct.insert(10,11);
        assertEquals(14, funct.linearInterpolation(13));
    }
    @Test(expected = IllegalArgumentException.class)
    public void InsertExceptionTest(){
        Table funct = new Table();
        funct.insert(12,13);
        funct.insert(12,13);
    }
    @Test(expected = IllegalArgumentException.class)
    public void DeleteExceptionTest(){
        Table funct = new Table();
        funct.delete(12);
    }
    @Test(expected = IllegalStateException.class)
    public void InterpolationExceptionTest(){
        Table funct = new Table();
        funct.insert(12,13);
        funct.linearInterpolation(14);
    }
    @Test(expected = IllegalStateException.class)
    public void FindExceptionTest(){
        Table funct = new Table();
        funct.find(14);
    }
    @Test
    public void GetTableTest(){
        Table funct = new Table();
        TreeMap<Integer,Integer> expectedmap = new TreeMap<>();
        expectedmap.put(12,13);
        expectedmap.put(14,15);
        funct.insert(12,13);
        funct.insert(14,15);
        assertEquals(expectedmap, funct.getTable());
    }
}