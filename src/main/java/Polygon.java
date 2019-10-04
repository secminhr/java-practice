public class Polygon {
    private Vector[] _v;
    private Vector center;

    public Polygon(Vector ... vectors) {
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

    public double area() {
        return Calculate.area(vectorsBetweenCentroid());
    }

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