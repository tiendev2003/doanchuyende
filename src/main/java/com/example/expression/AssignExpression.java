package com.example.expression;

import com.example.expression.value.Value;

public interface AssignExpression {
    Value<?> assign(Value<?> value);
}
