/**
 * Created by SurfinBirb on 09.02.2017.
 */

import java.util.Vector;

public class Table {
    private int TableSize = 0;
    private Vector<Point>  Points = new Vector<>();

    void add(int x, int y){
        if (TableSize == 0){
            Points.add(new Point(x, y));
            TableSize++;
        }
        else {
            int index = 0;
            for (int i = 0; i <  Points.size(); i++) {
                Point dot = Points.elementAt(index);
                if (x <= dot.x) {
                    Points.insertElementAt(new Point(x, y), index);
                    TableSize++;
                    break;
                }
                else{
                    Points.add(new Point(x, y));
                    TableSize++;
                    break;
                }
            }
        }
    }

    void delete(int abscissa) {
        if (TableSize > 0) {
            int index = 0;
            for (int i = 0; i < Points.size(); i++) {
                Point dot = Points.get(index);
                if (dot.x != abscissa) {
                    index++;
                } else{
                    Points.removeElementAt(index);
                    TableSize--;
                    break;
                }
            }
        }
    }

    String getAll(){
        int index = 0;
        String line = "";
        for (int i = 0; i < Points.size(); i++){
            Point dot = Points.elementAt(index);
            line = line + ("Element #"+index+" x="+dot.x+" y="+dot.y+" //");
            index++;
        }
        return line;
    }

    int search(int x){
        int d;
        Point dot = Points.get(0);
        int min = dot.x;
        int index = 0;
        int result = 0;
        for (int i = 0; i < Points.size(); i++) {
            dot = Points.get(index);
            d = Math.abs(dot.x-x);
            if (d < min){
                min = d;
                result=index;
            }
            index++;
        }
        return result;
    }

    float linearInterpolation(int x) {
        int index = 0;
        int result = 0;
        Point PreviousPoint;
        Point NextPoint;
        for (int i = 0; i  < Points.size(); i++) {
            PreviousPoint = Points.elementAt(index);
            if (PreviousPoint==Points.lastElement()){
                Points.add(new Point(0,0));
                TableSize++;
                index--;
                PreviousPoint = Points.elementAt(index);
                NextPoint = Points.elementAt(index + 1);
                result = (PreviousPoint.y + (NextPoint.y - PreviousPoint.y) * (x - PreviousPoint.x) / (NextPoint.x - PreviousPoint.x));
                break;
            }else {
                NextPoint = Points.elementAt(index + 1);
                if (PreviousPoint.x > x) {
                    result = (PreviousPoint.y + (NextPoint.y - PreviousPoint.y) * (x - PreviousPoint.x) / (NextPoint.x - PreviousPoint.x));
                    break;
                }
            }
            index++;
        }
        return result;
    }
}
