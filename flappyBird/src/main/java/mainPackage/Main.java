package mainPackage;

public class Main {


    static int mapWidth = 10;
    static int mapLength = 50;
    static int[][] mapFrame = new int[mapWidth][mapLength];


    public static void formatMap(int[][] mapFrame) {
        for(int i = 0; i < mapWidth; i++){
            for(int j = 0; j < mapLength; j++){
                if( (i == 0 || j == 0) || i == mapWidth - 1 || j == mapLength - 1) {
                    mapFrame[i][j] = 1;
                }
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
        printMap(mapFrame, 2);
    }
}
