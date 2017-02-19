import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SurfinBirb on 17.02.2017.
 */
public class TableTest {
    @Test
    public void ChangesTest(){
        Table funct = new Table();
        funct.add(4,6);
        funct.add(5,7);
        funct.add(10,11);
        funct.add(12,13);
        funct.delete(10);
        assertEquals("Element #0 x=4 y=6 //Element #1 x=5 y=7 //Element #2 x=12 y=13 //",funct.getAll());
    }
    @Test
    public void SearchTest(){
        Table funct2 = new Table();
        funct2.add(4,6);
        funct2.add(5,7);
        funct2.add(10,11);
        funct2.add(12,13);
        assertEquals(3, funct2.search(14));
    }
    @Test
    public void LinearInterpolationTest(){
        Table funct3 = new Table();
        funct3.add(10,11);
        funct3.add(12,13);
        assertEquals(17, funct3.linearInterpolation(16), 0.001);
    }
}