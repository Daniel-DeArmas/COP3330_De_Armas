public class Sphere extends Shape3D {

    double radiusSphere;

    public Sphere(double radius) {
        this.radiusSphere = radius;
        getArea();
    }

    @Override
    public String getName() {
        return "sphere";
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * radiusSphere * radiusSphere;
    }

    @Override
    double getVolume() {
        return Math.PI * radiusSphere * radiusSphere * radiusSphere * 4 / 3;
    }
}