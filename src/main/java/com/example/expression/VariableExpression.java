package com.example.expression;

import com.example.context.MemoryContext;
import com.example.expression.value.Value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class VariableExpression implements Expression, AssignExpression {
    private final String name;

    @Override
    public Value<?> evaluate() {
        return MemoryContext.getScope().get(name);
    }

    @Override
    public Value<?> assign(Value<?> value) {
        if (value == null) return null;
        MemoryContext.getScope().set(name, value);
        return value;
    }
}
