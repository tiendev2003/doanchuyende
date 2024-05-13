package com.example.expression.operator;

import com.example.context.ExceptionContext;
import com.example.expression.Expression;
import com.example.expression.value.LogicalValue;
import com.example.expression.value.Value;

public class LogicalOrOperator extends BinaryOperatorExpression {
    public LogicalOrOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Value<?> evaluate() {
        Value<?> left = getLeft().evaluate();
        if (left == null) return null;
        Value<?> right = getRight().evaluate();
        if (right == null) return null;
        if (left instanceof LogicalValue && right instanceof LogicalValue) {
            return new LogicalValue(((LogicalValue) left).getValue() || ((LogicalValue) right).getValue());
        } else {
            return ExceptionContext.raiseException(String.format("Unable to perform OR operator for non logical values `%s`, '%s'", left, right));
        }
    }
}