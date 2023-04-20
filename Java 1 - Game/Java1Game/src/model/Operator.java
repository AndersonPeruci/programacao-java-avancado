package model;

public class Operator {
    private int operator;
    private String strOperator;
    private String operatorSymbol;

    public Operator(int operator){
        this.operator = operator;
        switch (this.operator) {
            case 0 -> {
                this.strOperator = "Sum";
                this.operatorSymbol = "+";
            }
            case 1 -> {
                this.strOperator = "Subtract";
                this.operatorSymbol = "-";
            }
            case 2 -> {
                this.strOperator = "Multiplier";
                this.operatorSymbol = "*";
            }
            default -> {
                this.strOperator = "Unknown operation";
                this.operatorSymbol = null;
            }
        }
    }

    public int getOperator() {
        return operator;
    }

    public String getStrOperator() {
        return strOperator;
    }

    public String getOperatorSymbol() {
        return operatorSymbol;
    }
}
