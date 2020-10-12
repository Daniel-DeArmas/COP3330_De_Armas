public class Square extends Shape2D{

    double lengthSquare;

    public Square(double length){
        this.lengthSquare = length;
        getArea();
    }

    @Override
    public String getName(){
        return "square";
    }

    @Override
    public double getArea(){
        return lengthSquare * lengthSquare;
    }
}