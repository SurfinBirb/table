/**
 * Created by SurfinBirb on 09.02.2017.
 */

import java.util.Vector;

public class Table {
    private Vector<Point>  Points = new Vector<>();

    void add(int x, int y){
        if (Points.isEmpty()){
            Points.add(new Point(x, y));
        }
        else {
            int index = 0;
            for (int i = 0; i <  Points.size(); i++) {
                if (x <= Points.elementAt(index).x) {
                    Points.insertElementAt(new Point(x, y), index);
                    break;
                }
                else{
                    Points.add(new Point(x, y));
                    break;
                }
            }
        }
    }

    void delete(int abscissa) {
        if (!Points.isEmpty()) {
            int index = 0;
            for (int i = 0; i < Points.size(); i++) {
                if (Points.elementAt(index).x != abscissa) {
                    index++;
                } else{
                    Points.removeElementAt(index);
                    break;
                }
            }
        }
    }

    String getAll(){
        int index = 0;
        String line = "";
        for (int i = 0; i < Points.size(); i++){
            line = line + ("Element #"+index+" x="+Points.elementAt(index).x+" y="+Points.elementAt(index).y+" //");
            index++;
        }
        return line;
    }

    int search(int x){
        int d;
        int min = Points.get(0).x;
        int index = 0;
        int result = 0;
        for (int i = 0; i < Points.size(); i++) {
            if (Points.get(index) == Points.firstElement()&&x<=Points.get(index).x){
                return 0;
            }
            if (Points.get(index)==Points.lastElement()&&x>=Points.get(index).x){
                return Points.size()-1;
            }
            d = Math.abs(Points.get(index).x-x);
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
