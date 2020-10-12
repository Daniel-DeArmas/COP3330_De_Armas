public class Cube extends Shape3D {

    double lengthCube;

    public Cube(double length) {
        this.lengthCube = length;
        getArea();
    }

    @Override
    public String getName() {
        return "cube";
    }

    @Override
    public double getArea() {
        return lengthCube * lengthCube * 6;
    }

    @Override
    double getVolume() {
        return lengthCube * lengthCube * lengthCube;
    }
}