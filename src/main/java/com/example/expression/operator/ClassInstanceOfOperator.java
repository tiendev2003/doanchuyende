package com.example.expression.operator;

import com.example.context.ExceptionContext;
import com.example.expression.Expression;
import com.example.expression.VariableExpression;
import com.example.expression.value.ClassValue;
import com.example.expression.value.LogicalValue;
import com.example.expression.value.Value;

public class ClassInstanceOfOperator extends BinaryOperatorExpression {
    public ClassInstanceOfOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Value<?> evaluate() {
        Value<?> left = getLeft().evaluate();
        if (left == null) return null;
        if (left instanceof ClassValue && getRight() instanceof VariableExpression) {
            String classType = ((VariableExpression) getRight()).getName();
            return new LogicalValue(((ClassValue) left).containsRelation(classType));
        } else {
            return ExceptionContext.raiseException(String.format("Unable to perform `is` operator for the following operands `%s` and `%s`", left, getRight()));
        }
    }
}
