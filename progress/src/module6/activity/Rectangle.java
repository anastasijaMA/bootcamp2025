package module6.activity;

public class Rectangle extends Shape {

    double length;
    double breadth;

    public Rectangle(){

    }

    public Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return length * breadth;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + breadth);
    }
}
