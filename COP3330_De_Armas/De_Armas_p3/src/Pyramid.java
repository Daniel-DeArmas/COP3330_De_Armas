public class Pyramid extends Shape3D {

    double lengthPyramid;
    double widthPyramid;
    double heightPyramid;

    public Pyramid(double length, double width, double height) {
        this.lengthPyramid = length;
        this.widthPyramid = width;
        this.heightPyramid = height;
        getArea();
    }

    @Override
    public String getName() {
        return "pyramid";
    }

    @Override
    public double getArea() {
        return lengthPyramid * widthPyramid +
                lengthPyramid * Math.sqrt((widthPyramid/2) * (widthPyramid/2) + heightPyramid * heightPyramid) +
                widthPyramid * Math.sqrt((lengthPyramid/2) * (lengthPyramid/2) + heightPyramid * heightPyramid);
    }

    @Override
    double getVolume() {
        return lengthPyramid * widthPyramid * heightPyramid / 3;
    }
}