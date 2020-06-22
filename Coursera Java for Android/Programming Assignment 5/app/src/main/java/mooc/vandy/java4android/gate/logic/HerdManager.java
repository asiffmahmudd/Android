package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;
    public final int HERD = 24;
    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    public void simulateHerd(Random rand){
        int x, transfer, pen = HERD, pasture = 0, chooseGate;
        System.out.println("East Gate: This gate is closed");
        System.out.println("West Gate: This gate is closed");
        toString(pen,pasture);
        for(int i = 0; i < MAX_ITERATIONS; i++){
            x = rand.nextInt(2);
            if(pen == 0){
                transfer = rand.nextInt(pasture)+1;
                pen += mWestGate.thru(transfer);
            }
            else if (pasture == 0){
                transfer = rand.nextInt(pen)+1;
                pen += mEastGate.thru(transfer);
            }
            else{
                chooseGate = rand.nextInt(2);
                if(chooseGate == 1){
                    transfer = rand.nextInt(pen)+1;
                    pen += mEastGate.thru(transfer);
                }
                else{
                    transfer = rand.nextInt(pen)+1;
                    pen += mEastGate.thru(transfer);
                }
            }
            pasture = HERD - pen;
            toString(pen,pasture);
        }
    }

    public String toString(int pen, int pasture){
        String s =  "There are currently " + pen + " snails in the pen and " + pasture + " snails in the pasture";
        return s;
    }

}
