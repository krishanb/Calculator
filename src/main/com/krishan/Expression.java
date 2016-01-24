package com.krishan;

public class Expression {

   private double firstNumber;
    private double secondNumber;
    private String operator;
    private double answer;

    public Expression(double firstNumber, double secondNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;

        switch(operator) {
            case "+":
                this.answer = firstNumber+secondNumber;
                break;
            case "-":
                this.answer = firstNumber-secondNumber;
                break;
            case "*":
                this.answer = firstNumber*secondNumber;
                break;
            default:
                if(secondNumber == 0) {
                    System.out.println("That's a maths error - ain't nobody dividing by no zero!");
                } else{
                    this.answer = firstNumber/secondNumber;
                }
        }
    }

    public double getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return String.format("%f %s %f = %f.2", firstNumber, operator, secondNumber, answer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expression that = (Expression) o;

        if (Double.compare(that.firstNumber, firstNumber) != 0) return false;
        if (Double.compare(that.secondNumber, secondNumber) != 0) return false;
        if (Double.compare(that.answer, answer) != 0) return false;
        return !(operator != null ? !operator.equals(that.operator) : that.operator != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(firstNumber);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(secondNumber);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        temp = Double.doubleToLongBits(answer);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
