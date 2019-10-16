import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Assertions;

public class PolygonTest {
    private Polygon p = new Polygon(new Vector(5,0),new Vector(10,0),new Vector(9,6),new Vector(8,6));
    private Polygon q = new Polygon(new Vector(0,0),new Vector(2,0),new Vector(2,2),new Vector(1,3),new Vector(0,2));
    @Test
    public void areaTest() {
        Assertions.assertEquals(18,p.area(),0.001);
    }
    @Test
    public void perimeterTest() {
        Assertions.assertEquals(6+2*Math.sqrt(2),q.perimeter(),0.001);
    }
    @Test
    public void outputTest() {
        Assertions.assertEquals(
            "(0.0, 0.0), (2.0, 0.0), (2.0, 2.0), (1.0, 3.0), (0.0, 2.0)", q.toString());
    }
}