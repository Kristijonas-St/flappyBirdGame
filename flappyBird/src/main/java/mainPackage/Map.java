package mainPackage;

import java.util.Random;

public class Map {
    protected int currentColumn = 0;
    protected int mapWidth = 20;
    protected int mapLength = 70;
    protected int[][] mapFrame = new int[mapWidth][mapLength];

    protected int pipesHorizontalGap = 10;
    protected int pipesVerticalGap = 4;

    public void formatMap() {
        for(int i = 0; i < mapWidth; i++){
            for(int j = 0; j < mapLength; j++){
                if( (i == 0 || j == 0) || i == mapWidth - 1 || j == mapLength - 1) {
                    mapFrame[i][j] = 3;
                }
            }
        }
    }
    public void createPipe() {
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
    public void printMapInConsole() {
        for(int i = 0; i < mapWidth; i++){
            for(int j = 0; j < mapLength; j++){
                System.out.print(mapFrame[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
    public void generatePipesForWholeMap() {
        while (currentColumn < mapLength) {
            currentColumn += pipesHorizontalGap;
            createPipe();
        }
    }

    public void modifyBirdPosition(int height, int length, int directionIndex) {
        clearBirdTrail();
        setNewBirdLocation(height,length, directionIndex);
    }
    public void clearBirdTrail() {
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapLength; j++) {
                if (mapFrame[i][j] == 2) {
                    mapFrame[i][j] = 0;
                }
            }
        }
    }
    public void setNewBirdLocation(int height, int length, int directionIndex) {
        if (directionIndex == 1 && length + 1 < mapLength) {
            mapFrame[height][length + 1] = 2;
        } else if (directionIndex == 2 && height - 1 >= 0) {
            mapFrame[height - 1][length] = 2;
        }
    }

    public boolean thereIsObstacleAhead(int height, int length) {
        if(mapFrame[height][length + 1] == 1 || mapFrame[height][length + 1] == 3) {
            return true;
        } else {
            return false;
        }
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapLength() {
        return mapLength;
    }

    public int[][] getMapFrame() {
        return mapFrame;
    }


}
