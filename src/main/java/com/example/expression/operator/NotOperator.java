package com.example.expression.operator;

import com.example.context.ExceptionContext;
import com.example.expression.Expression;
import com.example.expression.value.LogicalValue;
import com.example.expression.value.Value;

public class NotOperator extends UnaryOperatorExpression {
    public NotOperator(Expression value) {
        super(value);
    }

    @Override
    public Value<?> evaluate() {
        Value<?> value = getValue().evaluate();
        if (value == null) return null;
        if (value instanceof LogicalValue) {
            return new LogicalValue(!(((LogicalValue) value).getValue()));
        } else {
            return ExceptionContext.raiseException(String.format("Unable to perform NOT operator for non logical value `%s`", value));
        }
    }
}

