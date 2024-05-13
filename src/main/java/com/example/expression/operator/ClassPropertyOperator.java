package com.example.expression.operator;

import com.example.context.ExceptionContext;
import com.example.expression.AssignExpression;
import com.example.expression.Expression;
import com.example.expression.FunctionExpression;
import com.example.expression.VariableExpression;
import com.example.expression.value.ClassValue;
import com.example.expression.value.ThisValue;
import com.example.expression.value.Value;

public class ClassPropertyOperator extends BinaryOperatorExpression implements AssignExpression {
    public ClassPropertyOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Value<?> evaluate() {
        Value<?> left = getLeft().evaluate();
        if (left == null) return null;

        // access class's property via this instance
        // this :: class_argument
        if (left instanceof ThisValue) {
            left = ((ThisValue) left).getValue();
        }

        if (left instanceof ClassValue) {
            if (getRight() instanceof VariableExpression) {
                // access class's property
                // new Class [] :: class_property
                return ((ClassValue) left).getValue(((VariableExpression) getRight()).getName());
            } else if (getRight() instanceof FunctionExpression) {
                // execute class's function
                // new Class [] :: class_function []
                return ((FunctionExpression) getRight()).evaluate((ClassValue) left);
            }
        }

        return ExceptionContext.raiseException(String.format("Unable to access class's property `%s``", getRight()));
    }

    @Override
    public Value<?> assign(Value<?> value) {
        Value<?> left = getLeft().evaluate();
        if (left == null) return null;

        // access class's property via this instance
        // this :: class_argument
        if (left instanceof ThisValue) {
            left = ((ThisValue) left).getValue();
        }

        if (left instanceof ClassValue && getRight() instanceof VariableExpression) {
            String propertyName = ((VariableExpression) getRight()).getName();
            ((ClassValue) left).setValue(propertyName, value);
        }
        return left;
    }
}
