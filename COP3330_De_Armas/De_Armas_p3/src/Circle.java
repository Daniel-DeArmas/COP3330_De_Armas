public class Circle extends Shape2D{

    double radiusCircle;

    public Circle(double radius){
        this.radiusCircle = radius;
        getArea();
    }

    @Override
    public String getName(){
        return "circle";
    }

    @Override
    public double getArea(){
        return Math.PI * radiusCircle * radiusCircle;
    }
}
