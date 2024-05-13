package com.example.statement;

import com.example.context.ExceptionContext;
import com.example.expression.Expression;
import com.example.expression.value.NullValue;
import com.example.expression.value.TextValue;
import com.example.expression.value.Value;

import lombok.Getter;

@Getter
public class RaiseExceptionStatement extends Statement {
    private final Expression expression;

    public RaiseExceptionStatement(Integer rowNumber, String blockName, Expression expression) {
        super(rowNumber, blockName);
        this.expression = expression;
    }

    @Override
    public void execute() {
        Value<?> value = expression.evaluate();
        if (value != null) {
            if (value == NullValue.NULL_INSTANCE) {
                value = new TextValue("Empty exception");
            }
            ExceptionContext.raiseException(value);
        }
        ExceptionContext.addTracedStatement(this);
    }
}
