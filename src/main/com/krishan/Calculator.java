package com.krishan;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Expression>  previousExpressions = new ArrayList<>();

    public List<Expression> getPreviousExpressions() {
        return previousExpressions;
    }

    public void performCalculation() {

        System.out.println("Please write an expression");

        String expressionString = InputUtil.getStringFromUser();

        Expression expression = ExpressionParser.parseExpression(expressionString);

        System.out.println("Answer: " + expression.getAnswer());
        previousExpressions.add(expression);
    }

}
