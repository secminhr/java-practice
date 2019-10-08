import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Assertions;

public class CircleTest {
    @Test
    public void AreaTest() {
        Circle c = new Circle(5);
        Assertions.assertEquals(25*Math.PI, c.area());
    }

    @Test
    public void PerimeterTest() {
        Circle c = new Circle(5);
        Assertions.assertEquals(10*Math.PI, c.perimeter());
    }
    
}