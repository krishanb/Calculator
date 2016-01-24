package com.krishan;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static com.krishan.ExpressionParser.parseExpression;
import static org.junit.Assert.*;

public class ExpressionParserTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void returnsCorrectExpressionForCorrectInput() {
        Expression expression = parseExpression("1+1");
        assertEquals(new Expression(1, 1, "+"), expression);
    }


    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionWhenInputIsNull() {
        parseExpression(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionWhenInputIsEmptyString() {
        parseExpression("");
    }

    @Test
    public void throwsExceptionWhenInputContainsNoOperators() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Expression doesn't contain +, -, *, /");
        parseExpression("abcdefg");
    }

    @Test
    public void throwsExceptionWhenExpressionContainsMultipleOperators() {
        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage("Multiple operators not supported - we're working on this!");
        parseExpression("1+1+1");
    }

    @Test
    public void throwsExceptionWhenExpressionContainsMultipleOperatorsAgain() {
        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage("Multiple operators not supported - we're working on this!");
        parseExpression("1+1*1");
    }

    @Test
    public void throwsExceptionWhenExpressionContainsMultipleOperatorsAnotherTime() {
        expectedException.expect(UnsupportedOperationException.class);
        expectedException.expectMessage("Multiple operators not supported - we're working on this!");
        parseExpression("5/2*1+7-8");
    }

}