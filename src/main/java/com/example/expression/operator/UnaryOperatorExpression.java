package com.example.expression.operator;

import com.example.expression.Expression;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public abstract class UnaryOperatorExpression implements OperatorExpression {
    private final Expression value;
}

