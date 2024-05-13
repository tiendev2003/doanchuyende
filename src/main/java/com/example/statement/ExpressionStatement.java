package com.example.statement;

import com.example.context.ExceptionContext;
import com.example.expression.Expression;

import lombok.Getter;

@Getter
public class ExpressionStatement extends Statement {
    private final Expression expression;

    public ExpressionStatement(Integer rowNumber, String blockName, Expression expression) {
        super(rowNumber, blockName);
        this.expression = expression;
    }

    @Override
    public void execute() {
        expression.evaluate();
        ExceptionContext.addTracedStatement(this);
    }
}
