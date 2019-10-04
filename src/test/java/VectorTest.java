import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.*;

public class VectorTest {
  @Test
  public void ConstructorTest() {
    Vector v = new Vector(2,3,5);
    Assertions.assertEquals(5,v.getElement(2));
  }
  @Test
  public void outputTest() {
    Vector v = new Vector(2,3,5);
    Assertions.assertEquals("(2.0, 3.0, 5.0)",v.toString());
  }
  @Test
  public void dotTest() {
    Vector u = new Vector(2,3,5);
    Vector v = new Vector(8,5,6);
    Assertions.assertEquals(61,Calculate.dot(u,v));
  }
  @Test
  public void dotExceptionTest() {
    Vector u = new Vector(2,3,5);
    Vector v = new Vector(8,5);
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
      Calculate.dot(u,v);
    });
  }
  @Test
  public void isZeroTest() {
    Vector u = new Vector(0,3,5);
    Vector v = new Vector(0,0,0);
    Assertions.assertEquals(false,u.isZero());
    Assertions.assertEquals(true,v.isZero());
  }
  @Test
  public void lengthTest() {
    Vector u = new Vector(0,3,4);
    Assertions.assertEquals(5,u.length(),0.001);
  }
  @Test
  public void addTest() {
    Vector u = new Vector(2,3,5);
    Vector v = new Vector(8,5,6);
    Vector w = Calculate.add(u,v);
    Assertions.assertAll("Vector w",
      ()-> Assertions.assertEquals(10,w.getElement(0)),
      ()-> Assertions.assertEquals(8,w.getElement(1)),
      ()-> Assertions.assertEquals(11,w.getElement(2))
    );
  }
  @Test
  public void substractTest() {
    Vector u = new Vector(2,3,5);
    Vector v = new Vector(8,5,6);
    Vector w = Calculate.substract(u,v);
    Assertions.assertAll("Vector w",
      ()-> Assertions.assertEquals(-6,w.getElement(0)),
      ()-> Assertions.assertEquals(-2,w.getElement(1)),
      ()-> Assertions.assertEquals(-1,w.getElement(2))
    );
  }
  @Test
  public void distanceTest() {
    Vector u = new Vector(2,3,5);
    Vector v = new Vector(8,5,6);
    Assertions.assertEquals(Math.sqrt(41),Calculate.distance(u,v));
  }
  @Test
  public void area1Test() {
    Vector u = new Vector(0,5,0);
    Vector v = new Vector(0,10,0);
    Vector w = new Vector(0,9,6);
    Assertions.assertEquals(15,Calculate.area(u,v,w),0.001);
  }
  @Test
  public void area2Test() {
    Assertions.assertEquals(18,
      Calculate.area(
        new Vector(5,0),new Vector(10,0),new Vector(9,6),new Vector(8,6)),0.001);
  }
  @Test
  public void perimeterTest() {
    Assertions.assertEquals(6+2*Math.sqrt(2),
      Calculate.perimeter(
        new Vector(0,0),new Vector(2,0),new Vector(2,2),new Vector(1,3),new Vector(0,2)),0.001);
  }
}
