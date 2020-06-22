package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage 
       extends House {
       
    // TODO - Put your code here.
    private boolean mSecondFloor;

    public Cottage(int dimension, int mLotLength, int mLotWidth) {
        super(dimension, dimension, mLotLength, mLotWidth);
        mSecondFloor = false;
    }

    public Cottage(int dimension, int mLotLength, int mLotWidth, String owner, boolean mSecondFloor) {
        super(dimension, dimension, mLotLength, mLotWidth, owner);
        this.mSecondFloor = mSecondFloor;
    }

    public boolean hasSecondFloor(){
        return mSecondFloor;
    }

    public String toString(){
        return super.toString() + (hasSecondFloor() ? "; is a two story cottage" : "");
    }
}

