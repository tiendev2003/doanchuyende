package com.example.statement;

import com.example.context.ExceptionContext;
import com.example.expression.Expression;
import com.example.expression.value.LogicalValue;
import com.example.expression.value.Value;

import lombok.Getter;

@Getter
public class AssertStatement extends Statement {
    private final Expression expression;

    public AssertStatement(Integer rowNumber, String blockName, Expression expression) {
        super(rowNumber, blockName);
        this.expression = expression;
    }

    @Override
    public void execute() {
        Value<?> value = expression.evaluate();
        if (value instanceof LogicalValue && !((LogicalValue) value).getValue()) {
            ExceptionContext.raiseException("Assertion error");
            ExceptionContext.addTracedStatement(this);
        }
    }
}
