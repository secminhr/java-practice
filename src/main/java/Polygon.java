import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class Polygon extends Shape {
    private List<Vector> _v;
    private Vector center;

    public Polygon(Vector ... vectors) {
        for(Vector i : vectors)
            if(i.getDim()!=2)
                throw new InputMismatchException("Polygon only can be calculated in two dimension!!");
        _v = Arrays.asList(vectors);
        double x[] = { 0, 0 };
        for (Vector i : _v) {
            x[0] += i.getElement(0);
            x[1] += i.getElement(1);
        }
        x[0] /= _v.size();
        x[1] /= _v.size();
        center = new Vector(x);
    }

    private Vector[] vectorsBetweenCentroid(){
        var v = _v;
        for (int i = 0; i < v.size(); i++)
            v.set(i, Calculate.substract(_v.get(i), center));
        v.sort((o1, o2) -> {
            if (Calculate.angle(new Vector(1,0), o1) - Calculate.angle(new Vector(1,0), o2) >= 0)
                return 1;
            else if (Calculate.angle(new Vector(1,0), o1) - Calculate.angle(new Vector(1,0), o2) == 0)
                return 0;
            else
                return -1;
        });
        Vector result[] = new Vector[v.size()];
        return v.toArray(result);
    }
    
    @Override
    public double area() {
        return Calculate.area(vectorsBetweenCentroid());
    }

    @Override
    public double perimeter() {
        return Calculate.perimeter(vectorsBetweenCentroid());
    }
    public String toString(){
        String result = _v.get(0).toString();
        for(int i=1; i<_v.size();i++)
            result += ", " + _v.get(i).toString();
        return result;
    }
}