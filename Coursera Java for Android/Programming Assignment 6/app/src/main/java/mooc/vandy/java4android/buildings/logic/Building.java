package mooc.vandy.java4android.buildings.logic;

/**
 * This is the Building class file.
 */
public class Building {
    
    // TODO - Put your code here.
    private int mLength;
    private int mWidth;
    private int mLotLength;
    private int mLotWidth;

    public Building(int mLength, int mWidth, int mLotLength, int mLotWidth) {
        this.mLength = mLength;
        this.mWidth = mWidth;
        this.mLotLength = mLotLength;
        this.mLotWidth = mLotWidth;
    }

    public int getLength() {
        return mLength;
    }

    public void setLength(int mLength) {
        this.mLength = mLength;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int mWidth) {
        this.mWidth = mWidth;
    }

    public int getLotLength() {
        return mLotLength;
    }

    public void setLotLength(int mLotLength) {
        this.mLotLength = mLotLength;
    }

    public int getLotWidth() {
        return mLotWidth;
    }

    public void setLotWidth(int mLotWidth) {
        this.mLotWidth = mLotWidth;
    }

    public int calcBuildingArea(){
        return this.mLength*this.mWidth;
    }

    public int calcLotArea(){
        return this.mLotLength*this.mLotWidth;
    }

    @Override
    public String toString() {
        return "Owner:n/a";
    }
}
