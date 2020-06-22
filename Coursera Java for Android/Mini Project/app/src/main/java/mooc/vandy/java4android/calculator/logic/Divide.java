package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide implements Operation {
    private int num1;
    private int num2;
    private int quotient;
    private int remainder;
    private int flag = 0;

    public Divide(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        calculate();
    }

    @Override
    public void calculate() {
        if(num2 == 0){
            flag = 1;
        }
        else{
            quotient = num1/num2;
            remainder = num1%num2;
        }
    }

    @Override
    public String toString() {
        String s;
        if(flag == 1)
            s = "No number can be divided by 0";
        else
            s = String.valueOf(quotient) +" R: "+ String.valueOf(remainder);
        return s;
    }
}
