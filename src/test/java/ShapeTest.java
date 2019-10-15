import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Assertions;

public class ShapeTest {
    @Test
    public void OverrideTest() {
        Shape s = new Polygon(new Vector(5,0),new Vector(10,0),new Vector(9,6),new Vector(8,6));
        Shape t = new Circle(5);
        Assertions.assertEquals(18, s.area(), 0.001);
        Assertions.assertEquals(25*Math.PI, t.area(), 0.001);
    }
    @Test
    public void AreaTest() {
        Shape s = new Polygon(new Vector(2,4),new Vector(7,0),new Vector(0,2),new Vector(6,4),new Vector(1,0),new Vector(8,2));
        Assertions.assertEquals(26, s.area(), 0.001);
    }
    @Test
    public void PerimeterTest() {
        Shape s = new Polygon(new Vector(0,0),new Vector(2,2),new Vector(1,3),new Vector(0,2),new Vector(2,0),new Vector(3,1));
        Assertions.assertEquals(4+4*Math.sqrt(2.0), s.perimeter(), 0.001);
    }
    
}