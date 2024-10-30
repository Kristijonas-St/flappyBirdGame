package mainPackage;
import java.util.Random;

public class Main {

    static int currentColumn = 1;
    static int mapWidth = 10;
    static int mapLength = 50;
    static int[][] mapFrame = new int[mapWidth][mapLength];

    static int pipesHorizontalGap = 4;
    static int pipesVerticalGap = 3;


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
        currentColumn += pipesHorizontalGap;

        Random random = new Random();

        for (int i = 1; i < mapWidth - 1; i++) {
            mapFrame[i][currentColumn] = 1;
        }

        int upperPipeTip = random.nextInt(mapWidth - 5) + 1;  // Allows space for a gap within bounds

        int gapHeight = 3;
        for (int i = 0; i < gapHeight; i++) {
            if (upperPipeTip + i < mapWidth - 1) {
                mapFrame[upperPipeTip + i][currentColumn] = 0;
            }
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
                        System.out.print("." + " ");
                    }
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {


        formatMap(mapFrame);
        createPipe();

        printMap(mapFrame, 2);
    }
}
