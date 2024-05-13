package com.example.expression.value;

import com.example.expression.Expression;

import lombok.EqualsAndHashCode;
import lombok.Getter;
 

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Value<T> implements Expression {
    @EqualsAndHashCode.Include
    private T value;

    public Value(T v) {
        setValue(v);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public void setValue(T v) {
        this.value = v;
    }

    @Override
    public Value<?> evaluate() {
        return this;
    }
}
