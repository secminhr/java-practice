import java.util.InputMismatchException;
import java.util.List;

public class Vector {
  private double[] _v;
  public Vector(double ... elements) {
    _v=elements;
  }
  public double getElement(int index) {
    return _v[index];
  }
  public int getDim(){
    return _v.length;
  }
  public String toString() {
    String result = "(" + String.valueOf(_v[0]);
    for (int i=1;i<_v.length;i++) {
      result += ", " + String.valueOf(_v[i]);
    }
    return result + ")";
  }
  public boolean isZero() {
    for(int i=0;i<_v.length;i++){
      if(_v[i]!=0)
        return false;
    }
    return true;
  }
  public double length() {
    double res = 0;
    for (double i : _v) {
      res += Math.pow(i, 2);
    }
    return Math.sqrt(res);
  }
}

class Calculate {
  public static double dot(Vector u,Vector v) {
    var result = 0;
    if(v.getDim()!=u.getDim())
      throw new ArrayIndexOutOfBoundsException();
    for(int i = 0;i<u.getDim();i++)
      result += u.getElement(i)*v.getElement(i);
    return result;
  }
  public static Vector add(Vector u,Vector v) {    
    if(u.getDim()!=v.getDim())
      throw new ArrayIndexOutOfBoundsException();
    double[] res = new double[u.getDim()];
    for(int i = 0;i<u.getDim();i++)
      res[i]=u.getElement(i)+v.getElement(i);
    return new Vector(res);
  }
  public static Vector substract(Vector u,Vector v) {
    if(u.getDim()!=v.getDim())
      throw new ArrayIndexOutOfBoundsException();
    double[] res = new double[u.getDim()];
    for(int i = 0;i<u.getDim();i++)
      res[i]=u.getElement(i)-v.getElement(i);
    return new Vector(res);
  }
  public static double distance(Vector u,Vector v) {
    return substract(u, v).length();
  }
  public static double area(Vector u, Vector v, Vector w) {
    var s = (Calculate.distance(u, v)+Calculate.distance(v, w)+Calculate.distance(u, w))/2;
    return Math.sqrt(s*(s-Calculate.distance(u, v))*(s-Calculate.distance(v, w))*(s-Calculate.distance(u, w)));
  }
  public static double angle(Vector u, Vector v) {
    if(u.getDim()!=2 || v.getDim()!=2)
        throw new InputMismatchException("Area only can be calculated in two dimension!!");
    if(u.getElement(0)*v.getElement(1)-u.getElement(1)*v.getElement(0)>=0)
      return Math.acos(dot(u, v)/(u.length()*v.length()));
    else
      return 2*Math.PI - Math.acos(dot(u, v)/(u.length()*v.length()));
  }
  public static double area(List<Vector> v) {
    for(Vector i : v)
        if(i.getDim()!=2)
            throw new InputMismatchException("Area only can be calculated in two dimension!!");
    double result = 0;
    for(int i=1;i<v.size()-1;i++)
      result += area(v.get(0), v.get(i), v.get(i+1));
    return result;
  }
  public static double perimeter(List<Vector> v) {
    for(Vector i : v)
        if(i.getDim()!=2)
            throw new InputMismatchException("Perimeter only can be calculated in two dimension!!");
    double result = distance(v.get(0), v.get(v.size()-1));
    for(int i=0;i<v.size()-1;i++)
      result += distance(v.get(i), v.get(i+1));
    return result;
  }
}
