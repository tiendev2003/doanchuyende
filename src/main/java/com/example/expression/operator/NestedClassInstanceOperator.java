package com.example.expression.operator;

import com.example.context.ExceptionContext;
import com.example.expression.ClassExpression;
import com.example.expression.Expression;
import com.example.expression.value.ClassValue;
import com.example.expression.value.ThisValue;
import com.example.expression.value.Value;

public class NestedClassInstanceOperator extends BinaryOperatorExpression {
    public NestedClassInstanceOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Value<?> evaluate() {
        Value<?> left = getLeft().evaluate();
        if (left == null) return null;

        // access class's property via this instance
        // this :: new NestedClass []
        if (left instanceof ThisValue) {
            left = ((ThisValue) left).getValue();
        }

        if (left instanceof ClassValue && getRight() instanceof ClassExpression) {
            // instantiate nested class
            // new Class [] :: new NestedClass []
            return ((ClassExpression) getRight()).evaluate((ClassValue) left);
        } else {
            return ExceptionContext.raiseException(String.format("Unable to access class's nested class `%s``", getRight()));
        }
    }
}
