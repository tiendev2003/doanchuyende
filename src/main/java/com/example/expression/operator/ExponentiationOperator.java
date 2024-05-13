package com.example.expression.operator;

import com.example.context.ExceptionContext;
import com.example.expression.Expression;
import com.example.expression.value.NumericValue;
import com.example.expression.value.Value;

public class ExponentiationOperator extends BinaryOperatorExpression {
    public ExponentiationOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Value<?> evaluate() {
        Value<?> left = getLeft().evaluate();
        if (left == null) return null;
        Value<?> right = getRight().evaluate();
        if (right == null) return null;
        if (left instanceof NumericValue && right instanceof NumericValue) {
            return new NumericValue(Math.pow(((NumericValue) left).getValue(), ((NumericValue) right).getValue()));
        } else {
            return ExceptionContext.raiseException(String.format("Unable to make exponentiation with non numeric values `%s` and `%s`", left, right));
        }
    }
}
