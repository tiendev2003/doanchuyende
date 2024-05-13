package com.example.expression.operator;

import static com.example.expression.value.NullValue.NULL_INSTANCE;

import com.example.context.ExceptionContext;
import com.example.expression.Expression;
import com.example.expression.value.NumericValue;
import com.example.expression.value.TextValue;
import com.example.expression.value.Value;

public class SubtractionOperator extends BinaryOperatorExpression {
    public SubtractionOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Value<?> evaluate() {
        Value<?> left = getLeft().evaluate();
        if (left == null) return null;
        Value<?> right = getRight().evaluate();
        if (right == null) return null;
        if (left == NULL_INSTANCE || right == NULL_INSTANCE) {
            return ExceptionContext.raiseException(String.format("Unable to perform subtraction for NULL values `%s`, '%s'", left, right));
        } else if (left instanceof NumericValue && right instanceof NumericValue) {
            return new NumericValue(((NumericValue) left).getValue() - ((NumericValue) right).getValue());
        } else {
            return new TextValue(left.toString().replaceAll(right.toString(), ""));
        }
    }
}

