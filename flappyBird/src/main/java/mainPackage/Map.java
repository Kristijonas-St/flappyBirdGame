package mainPackage;

import java.util.Random;

public class Map {
    static int currentColumn = 0;
    static int mapWidth = 15;
    static int mapLength = 100;
    static int[][] mapFrame = new int[mapWidth][mapLength];

    static int pipesHorizontalGap = 6;
    static int pipesVerticalGap = 4;

    public static void formatMap() {
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

    public static void printMap(int mapType) {
        for (int i = 0; i < Map.getMapWidth(); i++) {
            for (int j = 0; j < Map.getMapLength(); j++) {
                if (mapType == 1) {
                    System.out.print(mapFrame[i][j] + " ");
                } else if (mapType == 2) {
                    switch (mapFrame[i][j]) {
                        case 0:
                            System.out.print("  ");
                            break;
                        case 1:
                            System.out.print("# ");
                            break;
                        case 2:
                            System.out.print("O ");
                            break;
                    }
                }
            }
            System.out.println();
        }
    }


    public static void modifyMap(int height, int length, int value) {
        if(mapFrame[height][length] == 0) {
            mapFrame[height][length] = value;
        }
    }



    public static int getCurrentColumn() {
        return currentColumn;
    }

    public static int getMapWidth() {
        return mapWidth;
    }

    public static int getMapLength() {
        return mapLength;
    }

    public static int[][] getMapFrame() {
        return mapFrame;
    }

    public static int getPipesHorizontalGap() {
        return pipesHorizontalGap;
    }

    public static int getPipesVerticalGap() {
        return pipesVerticalGap;
    }
}
