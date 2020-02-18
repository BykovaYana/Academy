package triangle;

import java.util.Comparator;

public class Triangle implements Comparator<Triangle> {
    private String triangleName;
    private float firstSide;
    private float secondSide;
    private float thirdSide;
    private double area;

    public Triangle(float firstSide, float secondSide, float thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public Triangle() {
    }

    public String getTriangleName() {
        return triangleName;
    }

    public void setTriangleName(String triangleName) {
        this.triangleName = triangleName;
    }

    public float getFirstSide() {
        return firstSide;
    }

    public float getSecondSide() {
        return secondSide;
    }

    public float getThirdSide() {
        return thirdSide;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double calculatePerimeter() {
        return (firstSide + secondSide + thirdSide) / 2;
    }

    public double calculateArea() {
        double perimeter = calculatePerimeter();
        double area = Math.sqrt(perimeter * (perimeter - firstSide) * (perimeter - secondSide) * (perimeter - thirdSide));
        return area;
    }

    public int compare(Triangle firstTriangle, Triangle secondTriangle) {
        return (int) (firstTriangle.area - secondTriangle.area);
    }
}