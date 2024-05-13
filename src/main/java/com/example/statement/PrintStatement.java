package com.example.statement;

import com.example.context.ExceptionContext;
import com.example.expression.Expression;
import com.example.expression.value.Value;

import lombok.Getter;

@Getter
public class PrintStatement extends Statement {
    private final Expression expression;

    public PrintStatement(Integer rowNumber, String blockName, Expression expression) {
        super(rowNumber, blockName);
        this.expression = expression;
    }

    @Override
    public void execute() {
        Value<?> value = expression.evaluate();
        if (value != null) {
            System.out.println(value);
        }
        ExceptionContext.addTracedStatement(this);
    }
}
