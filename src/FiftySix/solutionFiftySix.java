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

        String line =   "--XXX--\n"+
                        "-X--XX-\n"+
                        "-X-X-X-\n"+
                        "--XXXX-\n"+
                        "--XX--X";
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

        for(int x = 0; x < 5; x++) {
            game(map);
            int count = 0;

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (map[j][i]) {
                        //System.out.print("X");
                        count++;
                    }
                    else {
                  //      System.out.print("-");
                    }
                }
                //System.out.println("");
            }
            System.out.print(count+" ");
        }

    }

    public static void game(boolean[][] mapIn) {
        // mark deads
        boolean[][] deadMarks = new boolean[mapSize][mapSize];
        boolean[][] newBorns = new boolean[mapSize][mapSize];

        for (int i = 1; i < mapSize-1; i++) {
            for (int j = 1; j < mapSize-1; j++) {
                int neighbours = 0;

                if(mapIn[j+1][i]) {
                    neighbours++;
                }
                if(mapIn[j+1][i+1]) {
                    neighbours++;
                }
                if(mapIn[j][i+1]) {
                    neighbours++;
                }
                if(mapIn[j-1][i+1]) {
                    neighbours++;
                }
                if(mapIn[j-1][i]) {
                    neighbours++;
                }
                if(mapIn[j-1][i-1]) {
                    neighbours++;
                }
                if(mapIn[j][i-1]) {
                    neighbours++;
                }
                if(mapIn[j+1][i-1]) {
                    neighbours++;
                }

                if((neighbours < 2 || neighbours > 3) && mapIn[j][i]) {
                    deadMarks[j][i] = true;
                }

                if(neighbours == 3 && !mapIn[j][i]) {
                    newBorns[j][i] = true;
                }
            }
        }

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if(deadMarks[j][i]) {
                    mapIn[j][i] = false;
                }
                if(newBorns[j][i]) {
                    mapIn[j][i] = true;
                }
            }
        }
    }
}