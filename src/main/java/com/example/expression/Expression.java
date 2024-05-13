package com.example.expression;

import com.example.expression.value.Value;

public interface Expression {
    Value<?> evaluate();
}
