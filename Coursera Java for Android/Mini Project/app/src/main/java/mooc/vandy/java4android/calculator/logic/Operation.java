package mooc.vandy.java4android.calculator.logic;

import android.annotation.TargetApi;
import android.os.Build;

public interface Operation {
    @TargetApi(Build.VERSION_CODES.N)
    public void calculate();
    public String toString();
}
