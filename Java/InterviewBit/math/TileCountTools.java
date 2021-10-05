package math;

/**
 * @author Kedar Erande
 * Problem: A city is of rectangular shape with the size A * B meters. On the occasion of the city's anniversary, a decision was taken to pave the city with square granite flagstones. Each flagstone is of the size C * C. What is the least number of flagstones needed to pave the city?
 * TC is O(1)
 */
public class TileCountTools {
    public static void main(String[] args) {
        System.out.println(countTilesRequired(6, 6, 4));
        System.out.println(countTilesRequired(13, 7, 4));
    }

    public static int countTilesRequired(int rowSize, int columnSize, int tileSize) {

        int resultRow = (int) Math.ceil((double)rowSize/(double)tileSize);
        System.out.println((double)rowSize/(double)tileSize);
        int resultColumn = (int)Math.ceil((double)columnSize/(double)tileSize);

        //System.out.println("  Double.valueOf(Math.ceil(columnSize/tileSize)) : " +  (double)(resultRow*resultColumn));
        return resultRow * resultColumn;
    }
}
