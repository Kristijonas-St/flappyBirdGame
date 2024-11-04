package mainPackage;

public class Bird {


    private int height, distance;

    public static void spawnBird() {
        Map.modifyMap(Map.getMapWidth() / 2, 1, 2);
    }

    public int getHeight() {
        return height;
    }

    public int getDistance() {
        return distance;
    }
}
