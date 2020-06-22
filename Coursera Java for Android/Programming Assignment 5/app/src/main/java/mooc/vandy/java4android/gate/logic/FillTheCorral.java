package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    public void setCorralGates(Gate[] gate, Random selectDirection){
        int x;
        mOut.println("Initial gate setup:");
        for(int i = 0; i < gate.length; i++){
            x = selectDirection.nextInt(3);
            if(x == 0)
                gate[i].setSwing(1);
            else if(x == 1)
                gate[i].setSwing(-1);
            else
                gate[i].setSwing(0);
            mOut.println("Gate " + i + ": " + gate[i].toString());
        }
    }

    public boolean anyCorralAvailable(Gate[] corral){
        boolean b = false;
        for(int i = 0; i < corral.length; i++){
            if(corral[i].getSwingDirection() == 1){
                b = true;
                break;
            }
        }
        return b;
    }

    public int corralSnails(Gate[] gate, Random rand){
        int pasture = 5;
        int attempt = 0;
        int rn = 0;
        int rg = 0;

        do {
            rg = rand.nextInt(gate.length);
            rn = rand.nextInt(pasture)+1;
            mOut.println(rn + " are trying to move through corral " + rg);
            pasture -= gate[rg].thru(rn);
            attempt++;
        } while(pasture > 0);

        mOut.println("It took "+attempt+" attempts to corral all of the snails.");
        return attempt;

    }

}
