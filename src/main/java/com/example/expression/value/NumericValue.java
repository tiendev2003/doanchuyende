package com.example.expression.value;

public class NumericValue extends ComparableValue<Double> {
    public NumericValue(Double value) {
        super(value);
    }

    @Override
    public String toString() {
        if ((getValue() % 1) == 0)
            return String.valueOf(getValue().intValue());
        return super.toString();
    }
}
