package com.example.statement;

import com.example.context.ExceptionContext;
import com.example.context.ReturnContext;
import com.example.expression.Expression;
import com.example.expression.value.Value;

import lombok.Getter;

@Getter
public class ReturnStatement extends Statement {
    private final Expression expression;

    public ReturnStatement(Integer rowNumber, String blockName, Expression expression) {
        super(rowNumber, blockName);
        this.expression = expression;
    }

    @Override
    public void execute() {
        Value<?> result = expression.evaluate();
        if (result != null) {
            ReturnContext.getScope().invoke(result);
        }
        ExceptionContext.addTracedStatement(this);
    }
}
