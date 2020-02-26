package triangle;

import interfaces.IPlay;
import util.ConsoleIo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleGame implements IPlay {

    private List<Triangle> triangleList;
    private TrianglesDataProvider trianglesDataProvider;
    private ConsoleIo io;

    public TriangleGame() {
        triangleList = new ArrayList<>();
        trianglesDataProvider = new TrianglesDataProvider();
        io = new ConsoleIo();
    }

    public void play() throws Exception {
        trianglesDataProvider.getData();
        calculateAreas();
        printGameResults();
    }

    private void printGameResults() {
        io.printLine("============= Triangles list: ===============");
        Collections.sort(triangleList, new Triangle());
        for (int i = 0; i < triangleList.size(); i++) {
            io.printFormat("[%s]: %fcm\n", triangleList.get(i).getTriangleName(), triangleList.get(i).getArea());
        }
    }

    private void calculateAreas() {
        for (int i = 0; i < triangleList.size(); i++) {
            triangleList.get(i).setArea(triangleList.get(i).calculateArea());
        }
    }
}