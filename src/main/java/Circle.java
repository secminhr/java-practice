public class Circle extends Shape {
    private double _radius;

    public Circle(double radius) {
        _radius = radius;
    }

    @Override
    public double area() {
        return _radius * _radius * Math.PI;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * _radius;
    }
}