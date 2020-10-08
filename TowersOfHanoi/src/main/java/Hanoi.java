import javax.swing.*;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class Hanoi {


    static int POLE_A = 0;
    static int POLE_B = 1;
    static int POLE_C = 2;
    static int [][] positions;
    static int [] heights = new int [3];
    static int startHeight;
    static int delay;


    public static void main ( String ... args ) {
        try {
            int delay = Integer.parseInt(args[1]);
            int startInt = Integer.parseInt(args[0]);
            //int startInt = 3;
            startHeight = startInt;
            positions = new int [3][startInt];
        }
        catch (Exception e){
            System.out.println("Sorry, argument has to be a number E.g. 'Hanoi 5'");
            System.exit(0);
        }

        for (int i = 0; i <startHeight ; i++)
            positions [ POLE_A ][i] = startHeight -i;

        heights [ POLE_A ] = startHeight-1;
        heights [ POLE_B ] = -1;
        heights [ POLE_C ] = -1;

        printTower();
        move(POLE_A,POLE_C, startHeight);
    }


    static void move (int source , int target , int height )  {
        if ( height == 0) return ;
        int temp = 2*( source + target )%3;
        move (source , temp , height - 1);
        if(source >= 0) {
            if (positions[source][heights[source]] == 0) {
                System.out.println("This is blank ");
            } else if (positions[target][heights[target]+1] == 0
            ) {
                positions[target][heights[target]+1] =
                        positions[source][heights[source]];
                positions[source][heights[source]] = 0;

                heights[target]++;
                heights[source]--;
                printTower();
            }
        }
        move (temp , target , height - 1);
    }


    static void printTower()  {
        //This method clears the cmd window and print the current Hanoi tower
        try
        {
            Thread.sleep(delay);
            final String os = System.getProperty("os.name");
            if(os.contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else Runtime.getRuntime().exec("clear");

        }
        catch (Exception e)
        {
            System.out.println(e);//  Handle any exceptions.
        }
        for(int x = startHeight-1 ; x>=0 ; x-- ){
            System.out.print("| " + positions[0][x] + " ");
            System.out.print("| " + positions[1][x] + " ");
            System.out.print("| " + positions[2][x] + " ");
            System.out.println();
        }
    }
}
