package mainPackage;

public class Main {


    static int mapWidthStart = 0, mapWidthEnd = 10;
    static int mapLengthStart = 0, mapLengthEnd = 30;
    static int[][] mapFrame = new int[mapWidthEnd][mapLengthEnd];


    public static void formatMap(int[][] mapFrame) {
        for(int i = 0; i < mapWidthEnd; i++){
            for(int j = 0; j < mapLengthEnd; j++){
                if(i == mapWidthStart || i == mapWidthEnd - 1 || j == mapLengthStart || j == mapLengthEnd - 1) {
                    mapFrame[i][j] = 1;
                }
            }
        }
    }

    public static void printMap(int[][] mapFrame){
        for(int i = 0; i < mapWidthEnd; i++) {
            for(int j = 0; j < mapLengthEnd; j++){
                System.out.print(mapFrame[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        formatMap(mapFrame);
        printMap(mapFrame);
    }
}
