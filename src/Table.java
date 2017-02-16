/**
 * Created by SurfinBirb on 09.02.2017.
 */

import java.util.Vector;

public class Table {
    private int TableSize = 0;
    private Vector<Point>  Points = new Vector<>();

    private void add(int x,int y){
        if (TableSize == 0){
            Points.addElement(new Point(x, y));
            TableSize++;
        }
        else {
            int index = 0;
            for (int i = 0; i < Points.size(); i++) {
                Point dot = Points.elementAt(index);
                if (x <= dot.x) {
                    Points.insertElementAt(new Point(x, y), index);
                    TableSize++;
                }
                else{
                    Points.insertElementAt(new Point(x, y), index+1);
                    TableSize++;
                }
            }
        }
    }

    private void delete(int abscissa) {
        if (TableSize > 0) {
            int index = 0;
            for (int i = 0; i < Points.size(); i++) {
                Point dot = Points.get(index);
                if (dot.x != abscissa) {
                    index++;
                } else{
                    Points.removeElementAt(index);
                    break;
                }
            }
        }
    }

    private void getAll(){
        int index = 0;
        for (int i = 0; i < Points.size(); i++){
            Point dot = Points.elementAt(index);
            System.out.println("Element #"+index+" x="+dot.x+" y="+dot.y);
            index++;
        }
    }

    private void search(int x){
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
                result++;
            }
        }
    }

    private void linearInterpolation(int x){
        int index = 0;
        for (int i = 0; i < Points.size(); i++){
            Point PreviousPoint = Points.elementAt(index);
            Point NextPoint = Points.elementAt(index+1);
            if(NextPoint.x < x){
                index++;
            }else{
                int y = PreviousPoint.y + (NextPoint.y-PreviousPoint.y)*(x-PreviousPoint.x)/(NextPoint.x-PreviousPoint.x);
            }
        }
    }
}