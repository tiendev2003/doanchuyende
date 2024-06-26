package com.example.expression.operator;

import com.example.context.ExceptionContext;
import com.example.expression.AssignExpression;
import com.example.expression.Expression;
import com.example.expression.value.Value;

public class AssignmentOperator extends BinaryOperatorExpression {
    public AssignmentOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Value<?> evaluate() {
        Value<?> left = getLeft().evaluate();
        if (left == null) return null;
        Value<?> right = getRight().evaluate();
        if (right == null) return null;

        if (getLeft() instanceof AssignExpression) {
            return ((AssignExpression) getLeft()).assign(right);
        } else {
            return ExceptionContext.raiseException(String.format("Unable to make an assignment for `%s``", getLeft()));
        }
    }
}
