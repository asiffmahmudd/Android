package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public boolean isCorner(int row, int column, int i, int j){                  //detects corner of the frame to print '+'
        if((i == 0 && j == 0) || (i == row-1 && j == column-1) || (i == 0 && j == column-1) || (i == row-1) && j == 0)
            return true;
        else
            return false;
    }
    public boolean isSide(int row, int column, int i, int j){                    //detectss side portions of the frame to print '|'
        if((i > 0 && i < row-1) && (j == 0 || j == column-1))
            return true;
        else
            return false;
    }
    public boolean isTopOrBottom(int row, int column, int i, int j){             //detects top and bottom portions of the frame to print '-'
        if((j > 0 && j < column-1) && (i == 0 || i == row-1))
            return true;
        else
            return false;
    }

    public void printFrame(int f){                   //helps to detect frame portion and prints that portion
        if(f == 1) mOut.print('+');
        else if(f == 2) mOut.print('|');
        else if(f == 3) mOut.print('-');
    }

    public void printHalfLine(int i, int j, int column){                         //prints the half line
        if(j == 1) mOut.print('<');
        else if (j == column-2) mOut.print('>');
        else printDash(i);
    }

    public void printRest(int i, int j, int x, int y, int half){                //helps to detect the rest of the portions and print those
        if(j == x) {
            if(i < half)
                mOut.print('/');
            else
                mOut.print('\\');
        }
        else if(j == y){
            if(i < half)
                mOut.print('\\');
            else
                mOut.print('/');
        }
        else if(j < x || j > y){
            mOut.print(' ');
        }
        else{
            printDash(i);
        }
    }

    public void printDash(int i){                                                //prints dashed and double dashed portions inside the frame
        if(i%2 == 0)
            mOut.print('-');
        else
            mOut.print('=');
    }

    public void process(int size) {
        int row = (size*2)+1;
        int column = (size*2)+2;
        int half = row/2;
        int x = (column/2)-1;                                                           //helps to detect '<'
        int y = (column/2);                                                             //helps to detect '>'
        int f = 0;
        for(int i = 0; i < row; i++){
            if(i < half && i > 1){
                x--;
                y++;
            }
            else if(i > half+1 && i < row-1){
                x++;
                y--;
            }
            for(int j = 0; j < column; j++){
                f = 0;
                if(isCorner(row,column, i, j))
                    f = 1;
                else if(isSide(row,column, i, j))
                    f = 2;
                else if(isTopOrBottom(row,column, i, j))
                    f = 3;

                if(f > 0) printFrame(f);
                else{
                    if(i == half)
                        printHalfLine(i,j,column);
                    else{
                        printRest(i,j,x,y,half);
                    }
                }
            }
            mOut.print("\n");
        }

    }


}
