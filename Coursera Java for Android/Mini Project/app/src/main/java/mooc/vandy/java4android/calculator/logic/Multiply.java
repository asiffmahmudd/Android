package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply implements Operation{
    private int num1;
    private int num2;
    private int result;

    public Multiply(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        calculate();
    }

    @Override
    public void calculate() {
        result = num1*num2;
    }

    @Override
    public String toString() {
        return String.valueOf(result);
    }
}
