package com.example.context;

import com.example.expression.value.Value;

import lombok.Getter;


@Getter
public class ReturnScope {
    private boolean invoked;
    private Value<?> result;

    /**
     * Notify current scope that <strong>return</strong> statement invoked
     */
    public void invoke(Value<?> result) {
        this.invoked = true;
        this.result = result;
    }
}
