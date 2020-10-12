public class Triangle extends Shape2D{

    double baseTriangle;
    double heightTriangle;

    public Triangle(double base, double height){
        this.baseTriangle = base;
        this.heightTriangle = height;
        getArea();
    }

    @Override
    public String getName(){
        return "triangle";
    }

    @Override
    public double getArea(){
        return baseTriangle * heightTriangle / 2;
    }
}
