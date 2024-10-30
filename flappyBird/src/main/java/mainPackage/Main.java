package mainPackage;
import java.util.Random;

public class Main {


    //System.out.println( '\u263A' ); // Smiley Face symbol

    static int currentColumn = 0;
    static int mapWidth = 15;
    static int mapLength = 100;
    static int[][] mapFrame = new int[mapWidth][mapLength];

    static int pipesHorizontalGap = 6;
    static int pipesVerticalGap = 4;

    public static void formatMap(int[][] mapFrame) {
        for(int i = 0; i < mapWidth; i++){
            for(int j = 0; j < mapLength; j++){
                if( (i == 0 || j == 0) || i == mapWidth - 1 || j == mapLength - 1) {
                    mapFrame[i][j] = 1;
                }
            }
        }
    }

    public static void createPipe() {
        int upperPipeTip = 0;
        Random random = new Random();

        if(currentColumn < mapLength) {
            for (int i = 1; i < mapWidth - 1; i++) {
                mapFrame[i][currentColumn] = 1;
            }
            upperPipeTip = random.nextInt(mapWidth - 5) + 1;

            for (int i = 0; i < pipesVerticalGap; i++) {
                if (upperPipeTip + i < mapWidth - 1) {
                    mapFrame[upperPipeTip + i][currentColumn] = 0;
                }
            }
        }

    }

    public static void generatePipesForWholeMap() {
        while (currentColumn < mapLength) {
            currentColumn += pipesHorizontalGap;
            createPipe();
        }
    }


    public static void printMap(int[][] mapFrame, int mapType){
        for(int i = 0; i < mapWidth; i++) {
            for(int j = 0; j < mapLength; j++){

                if(mapType == 1) {
                    System.out.print(mapFrame[i][j] + " ");
                } else if (mapType == 2) {
                    if(mapFrame[i][j] == 1) {
                        System.out.print("#" + " ");
                    } else {
                        System.out.print(" " + " ");
                    }
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        formatMap(mapFrame);
        generatePipesForWholeMap();

        printMap(mapFrame, 2);

    }
}
