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
}