package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.logic.Add;
import mooc.vandy.java4android.calculator.logic.Divide;
import mooc.vandy.java4android.calculator.logic.Multiply;
import mooc.vandy.java4android.calculator.logic.Subtract;
import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic 
       implements LogicInterface {
    /**
     * Reference to the Activity output.
     */
    private static final int ADDITION = 1;
    private static final int SUBTRACTION = 2;
    private static final int MULTIPLICATION = 3;
    private static final int DIVISION = 4;

    protected ActivityInterface mOut;

    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out){
        mOut = out;
    }

    /**
     * Perform the @a operation on @a argumentOne and @a argumentTwo.
     */
    public void process(int argumentOne,
                        int argumentTwo,
                        int operation){

        if(operation == ADDITION){
            Operation add = new Add(argumentOne,argumentTwo);
            mOut.print(add.toString());
        }
        else if(operation == SUBTRACTION){
            Operation sub = new Subtract(argumentOne,argumentTwo);
            mOut.print(sub.toString());
        }
        else if(operation == MULTIPLICATION){
            Operation mul = new Multiply(argumentOne,argumentTwo);
            mOut.print(mul.toString());
        }
        else{
            Operation div = new Divide(argumentOne,argumentTwo);
            mOut.print(div.toString());
        }
    }
}
