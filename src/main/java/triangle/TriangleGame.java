package triangle;

import interfaces.IPlay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleGame implements IPlay {

    private List<Triangle> triangleList = new ArrayList<>();
    private GetTrianglesData getTrianglesData = new GetTrianglesData();

    public void Play() throws Exception {
        getTrianglesData.GetData();
        CalculateAreas();
        PrintResult();
    }

    private void PrintResult() {
        System.out.println("============= Triangles list: ===============");
        Collections.sort(triangleList, new Triangle());
        for (int i = 0; i < triangleList.size(); i++) {
            System.out.printf("[%s]: %f cm\n", triangleList.get(i).getTriangleName(), triangleList.get(i).getArea());
        }
    }

    private void CalculateAreas() {
        for (int i = 0; i < triangleList.size(); i++) {
            triangleList.get(i).setArea(triangleList.get(i).CalculateArea());
        }
    }


}
