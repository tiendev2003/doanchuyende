package com.example.expression.operator;

import static com.example.expression.value.NullValue.NULL_INSTANCE;

import java.util.Objects;

import com.example.context.ExceptionContext;
import com.example.expression.Expression;
import com.example.expression.value.ComparableValue;
import com.example.expression.value.LogicalValue;
import com.example.expression.value.Value;

public class GreaterThanOrEqualToOperator extends BinaryOperatorExpression {
    public GreaterThanOrEqualToOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Value<?> evaluate() {
        Value<?> left = getLeft().evaluate();
        if (left == null) return null;
        Value<?> right = getRight().evaluate();
        if (right == null) return null;
        boolean result;
        if (left == NULL_INSTANCE || right == NULL_INSTANCE) {
            return ExceptionContext.raiseException(String.format("Unable to perform greater than or equal to for NULL values `%s`, '%s'", left, right));
        } else if (Objects.equals(left.getClass(), right.getClass()) && left instanceof ComparableValue) {
            
            result = ((Comparable) left.getValue()).compareTo(right.getValue()) >= 0;
        } else {
            result = left.toString().compareTo(right.toString()) >= 0;
        }
        return new LogicalValue(result);
    }
}
