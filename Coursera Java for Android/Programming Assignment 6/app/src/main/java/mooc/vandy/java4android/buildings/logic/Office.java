package mooc.vandy.java4android.buildings.logic;

import java.util.Objects;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office<sTotalOffices>
       extends Building {
       
    // TODO - Put your code here.
    private String mBusinessName;
    private int mParkingSpaces;
    private static int sTotalOffices = 0;

    public Office(int mLength, int mWidth, int mLotLength, int mLotWidth) {
        super(mLength, mWidth, mLotLength, mLotWidth);
        mBusinessName = null;
        mParkingSpaces = 0;
        sTotalOffices++;
    }

    public Office(int mLength, int mWidth, int mLotLength, int mLotWidth, String mBusinessName) {
        super(mLength, mWidth, mLotLength, mLotWidth);
        this.mBusinessName = mBusinessName;
        sTotalOffices++;
    }

    public Office(int mLength, int mWidth, int mLotLength, int mLotWidth, String mBusinessName, int mParkingSpaces) {
        super(mLength, mWidth, mLotLength, mLotWidth);
        this.mBusinessName = mBusinessName;
        this.mParkingSpaces = mParkingSpaces;
        sTotalOffices++;
    }

    public String getBusinessName() {
        return mBusinessName;
    }

    public void setBusinessName(String mBusinessName) {
        this.mBusinessName = mBusinessName;
    }

    public int getParkingSpaces() {
        return mParkingSpaces;
    }

    public void setParkingSpaces(int mParkingSpaces) {
        this.mParkingSpaces = mParkingSpaces;
    }

    public String toString(){
        String s = "Business: ";
        if(mBusinessName == null)
            s += "unoccupied ";
        else
            s += this.mBusinessName;
        if(this.mParkingSpaces > 0)
            s += "has " +this.mParkingSpaces + "parking spaces ";
        s += "(total offices: " + this.sTotalOffices + ")";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Office)) return false;
        Office<?> office = (Office<?>) o;
        return mParkingSpaces == office.mParkingSpaces &&
                this.calcBuildingArea() == office.calcBuildingArea();
    }

    @Override
    public int hashCode() {
        return Objects.hash(mBusinessName, mParkingSpaces);
    }
}
