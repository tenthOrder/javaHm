package ru.itis;

public class Main {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[7];
	    shapes[0] = new Ellipse(0, 0, 10, 5);
	    shapes[1] = new Circle(0, 0 , 5);
	    shapes[2] = new Triangle(0, 0 , 3, 8, 10);
	    shapes[3] = new Trapezium(0, 0, 7, 3, 5, 10); //invalid sides
	    shapes[4] = new Rhombus(0 , 0, 5, Math.PI/6);
	    shapes[5] = new Rectangle(0, 0, 2, 13);
	    shapes[6] = new Square(0, 0, 10);
	    for (Shape shape : shapes) {
            System.out.println(shape.getArea() + " " + shape.getPerimeter());
        }
    }
}
