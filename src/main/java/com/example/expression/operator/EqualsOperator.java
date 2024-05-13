package com.example.expression.operator;

import static com.example.expression.value.NullValue.NULL_INSTANCE;

import java.util.Objects;

import com.example.expression.Expression;
import com.example.expression.value.LogicalValue;
import com.example.expression.value.Value;

public class EqualsOperator extends BinaryOperatorExpression {
    public EqualsOperator(Expression left, Expression right) {
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
            result = left == right;
        } else if (Objects.equals(left.getClass(), right.getClass())) {
            result = left.getValue().equals(right.getValue());
        } else {
            result = left.toString().equals(right.toString());
        }
        return new LogicalValue(result);
    }
}
