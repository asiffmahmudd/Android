package mooc.vandy.java4android.buildings.logic;

import java.util.Objects;

/**
 * This is the House class file that extends Building.
 */
public class House 
       extends Building {

    // TODO - Put your code here.
    private String mOwner;
    private boolean mPool;

    public House(int mLength, int mWidth, int mLotLength, int mLotWidth) {
        super(mLength, mWidth, mLotLength, mLotWidth);
        mOwner = null;
        mPool = false;
    }

    public House(int mLength, int mWidth, int mLotLength, int mLotWidth, String mOwner) {
        super(mLength, mWidth, mLotLength, mLotWidth);
        this.mOwner = mOwner;
        mPool = false;
    }

    public House(int mLength, int mWidth, int mLotLength, int mLotWidth, String mOwner, boolean mPool) {
        super(mLength, mWidth, mLotLength, mLotWidth);
        this.mOwner = mOwner;
        this.mPool = mPool;
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(String mOwner) {
        this.mOwner = mOwner;
    }

    public boolean hasPool() {
        return mPool;
    }

    public void setPool(boolean mPool) {
        this.mPool = mPool;
    }

    public String toString(){
        String s = "Owner: ";
        if(this.mOwner == null)
            s += "n/a";
        else
            s += this.mOwner;
        if(this.hasPool())
            s += "; has a pool";
        if(this.calcBuildingArea() < this.calcLotArea()){
            s += "; has a big open space";
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof House))
            return false;
        House house = (House) o;
        return mPool == house.mPool && this.calcBuildingArea() == ((House) o).calcBuildingArea();
    }

    public int hashCode() {
        return Objects.hash(mPool);
    }
}
