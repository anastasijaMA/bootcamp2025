package module6.activity;

public class Circle extends Shape{

    double radius;

    public Circle(){
    }

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 3.14 * (radius * radius);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * 3.14 * radius;
    }
}
