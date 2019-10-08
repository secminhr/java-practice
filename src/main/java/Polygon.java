import java.util.InputMismatchException;

public class Polygon extends Shape {
    private Vector[] _v;
    private Vector center;

    public Polygon(Vector ... vectors) {
        for(Vector i : vectors)
            if(i.getDim()!=2)
                throw new InputMismatchException("Polygon only can be calculated in two dimension!!");
        _v = vectors;
        double x[] = { 0, 0 };
        for (Vector i : _v) {
            x[0] += i.getElement(0);
            x[1] += i.getElement(1);
        }
        x[0] /= _v.length;
        x[1] /= _v.length;
        center = new Vector(x);
    }

    private Vector[] vectorsBetweenCentroid(){
        Vector[] v = new Vector[_v.length];
        for (int i = 0; i < _v.length; i++)
            v[i] = Calculate.substract(_v[i], center);
        return v;
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
        String result = _v[0].toString();
        for(int i=1; i<_v.length;i++)
            result += ", " + _v[i].toString();
        return result;
    }
}