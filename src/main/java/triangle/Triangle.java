package triangle;

import java.util.Comparator;

public class Triangle implements Comparator<Triangle> {
    private String triangleName;
    private float firstSide;
    private float secondSide;
    private float thirdSide;
    private double area;

    public String getTriangleName() {
        return triangleName;
    }

    public void setTriangleName(String triangleName) {
        this.triangleName = triangleName;
    }

    public float getFirstSide() {
        return firstSide;
    }

    public void setFirstSide(float firstSide) {
        this.firstSide = firstSide;
    }

    public float getSecondSide() {
        return secondSide;
    }

    public void setSecondSide(float secondSide) {
        this.secondSide = secondSide;
    }

    public float getThirdSide() {
        return thirdSide;
    }

    public void setThirdSide(float thirdSide) {
        this.thirdSide = thirdSide;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double CalculatePerimeter() {
        return (firstSide + secondSide + thirdSide) / 2;
    }

    public double CalculateArea() {
        double perimeter = CalculatePerimeter();
        double area = Math.sqrt(perimeter * (perimeter - firstSide) * (perimeter - secondSide) * (perimeter - thirdSide));
        return area;
    }

    @Override
    public int compare(Triangle firstTriangle, Triangle secondTriangle) {
        return (int) (firstTriangle.area - secondTriangle.area);
    }
}