package com.example.expression.value;

public abstract class IterableValue<T> extends Value<T> implements Iterable<Value<?>> {
    public IterableValue(T value) {
        super(value);
    }
}
