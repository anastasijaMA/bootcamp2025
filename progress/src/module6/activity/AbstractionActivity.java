package module6.activity;

public class AbstractionActivity {
    public static void main(String[] args){
        Circle circle = new Circle(5);
        circle.setColor("red");

        System.out.println("-----------------------------");
        System.out.println("Color of circle : " + circle.getColor());
        System.out.println("Area of circle : " + circle.calculateArea());
        System.out.println("Perimeter of circle : " + circle.calculatePerimeter());

        Rectangle rect = new Rectangle(5,6);
        rect.setColor("blue");

        System.out.println("-----------------------------");
        System.out.println("Color of rectangle : " + rect.getColor());
        System.out.println("Area of rectangle : " + rect.calculateArea());
        System.out.println("Perimeter of rectangle : " + rect.calculatePerimeter());
    }
}
