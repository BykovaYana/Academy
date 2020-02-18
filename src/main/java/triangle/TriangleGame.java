package triangle;

import interfaces.IPlay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleGame implements IPlay {

    private List<Triangle> triangleList;
    private TrianglesDataProvider trianglesDataProvider;

    public TriangleGame() {
        triangleList = new ArrayList<>();
        trianglesDataProvider = new TrianglesDataProvider();
    }

    public void play() throws Exception {
        trianglesDataProvider.getData();
        calculateAreas();
        printGameResults();
    }

    private void printGameResults() {
        System.out.println("============= Triangles list: ===============");
        Collections.sort(triangleList, new Triangle());
        for (int i = 0; i < triangleList.size(); i++) {
            System.out.printf("[%s]: %fcm\n", triangleList.get(i).getTriangleName(), triangleList.get(i).getArea());
        }
    }

    private void calculateAreas() {
        for (int i = 0; i < triangleList.size(); i++) {
            triangleList.get(i).setArea(triangleList.get(i).calculateArea());
        }
    }
}