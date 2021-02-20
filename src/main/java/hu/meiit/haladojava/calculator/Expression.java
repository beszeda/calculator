package hu.meiit.haladojava.calculator;

public class Expression {

    private final int operand1;
    private final String operator;
    private final int operand2;


    public Expression(int operand1, String operator,int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public String getOperator() {
        return operator;
    }
}
