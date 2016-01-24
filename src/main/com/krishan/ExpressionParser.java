package com.krishan;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.Double.parseDouble;
import static java.util.stream.Collectors.*;

public class ExpressionParser {

    private static List<String> operators = Arrays.asList("+", "-", "*", "/");

    public static Expression parseExpression(String expression) {
        if(expression == null || expression.isEmpty()) throw new IllegalArgumentException();

        Integer numberOfOperators = operators.stream().map(operator -> expression.length() - expression.replaceAll("\\" + operator, "").length()).collect(summingInt(Integer::intValue));
        if(numberOfOperators < 1) throw new IllegalArgumentException("Expression doesn't contain +, -, *, /");
        if(numberOfOperators > 1) throw new UnsupportedOperationException("Multiple operators not supported - we're working on this!");

        Optional<Optional<Expression>> optionalExpression = operators.stream().map(op -> {
            final String[] splitArray = expression.split("\\" + op);
            Optional<Expression> exp = (splitArray.length == 2) ? Optional.of(new Expression(parseDouble(splitArray[0]), parseDouble(splitArray[1]), op)) : Optional.empty();
            return exp;
        }).filter(Optional::isPresent).findFirst();
        return optionalExpression.orElseThrow(IllegalStateException::new).orElseThrow(IllegalStateException::new);
    }
}
