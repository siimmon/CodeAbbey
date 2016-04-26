package FiftySix;

/**
 * Created by u120987 on 26/04/2016.
 */
import java.util.*;

class solutionFiftySix {
    public static int mapSize = 100;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        boolean[][] map = new boolean[mapSize][mapSize];

        String line =   "-------\n"+
                "---XX--\n"+
                "-XXX---\n"+
                "-------\n"+
                "-------";
        String[] lineSplit = line.split("\n");
        // put the 7x5 map from input in from 50x50 so the edges dont mess things up

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                String[] lineSplitVals = lineSplit[i].split("");
                if (lineSplitVals[j].equals("X")) {
                    map[j+50][i+50] = true;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[j][i]) {
                    System.out.print("X");
                }
                else {
                    System.out.print("-");
                }
            }
            System.out.println("");
        }
    }

    public static void game(boolean[][] mapIn) {
        // mark deads
        boolean[][] deadMarks = mapIn;

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                int neighbours = 0;

                if(mapIn[j][i]) {
                    // we're here if()
                }
            }
        }

    }
}