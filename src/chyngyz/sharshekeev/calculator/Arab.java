package chyngyz.sharshekeev.calculator;

public class Arab extends Calculable {

    private int value1;
    private int value2;
    private int result;

    Arab(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public void addition() {
        this.result = value1 + value2;
    }

    @Override
    public void subtraction() {
        this.result = value1 + value2;
    }

    @Override
    public void multiple() {
        this.result = value1 * value2;
    }

    @Override
    public void division() {
        try {
            this.result = value1 / value2;
        } catch (ArithmeticException e) {
            System.out.print("Division by zero is not possible!");
            return;
        }
    }

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public String getStringResult() {
        return "" + result;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }
}
