package model;

import java.util.Random;

public class Calculate {
    private final int difficulty;
    private final int firstValue;
    private final int secondValue;
    private final Operator operator;
    private int result;
    private final boolean processed;

    public Calculate(int difficulty) {
        this.processed = false;

        Random random = new Random();

        this.difficulty = difficulty;
        this.operator = new Operator(random.nextInt(3));

        // Generate value based in difficulty
        this.firstValue = random.nextInt(Integer.parseInt("1" + new String(new char[this.difficulty]).replace("\0", "0")));
        this.secondValue = random.nextInt(Integer.parseInt("1" + new String(new char[this.difficulty]).replace("\0", "0")));

        this.calculate();
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public Operator getOperator() {
        return operator;
    }

    public int getResult() {
        return result;
    }

    public boolean isProcessed() {
        return processed;
    }

    @Override
    public String toString() {
        return "First Value: " + this.getFirstValue() +
                "\nSecond Value: " + this.getSecondValue() +
                "\nOperator: " + this.getOperator().getStrOperator() +
                "\nDifficult: " + this.getDifficulty();
    }

    private void sum(){
        this.result = this.getFirstValue() + getSecondValue();
    }

    private void subtract(){
        this.result = this.getFirstValue() - getSecondValue();
    }

    private void multiplier(){
        this.result = this.getFirstValue() * getSecondValue();
    }

    private void calculate(){
        switch (this.getOperator().getOperator()) {
            case 0 -> this.sum();
            case 1 -> this.subtract();
            case 2 -> this.multiplier();
            default -> System.out.println("Invalid operator");
        }
    }

    public boolean isCorrectAnswer(int answer){
        return answer == this.getResult();
    }

    public String printEquation(){
        if (this.isProcessed()) {
            return this.getFirstValue() + " " + this.getOperator().getOperatorSymbol() + " " + this.getSecondValue() + " = " + this.getResult();
        } else {
            return this.getFirstValue() + " " + this.getOperator().getOperatorSymbol() + " " + this.getSecondValue() + " = ";
        }

    }

}

