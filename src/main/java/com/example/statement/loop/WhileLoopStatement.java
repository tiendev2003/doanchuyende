package com.example.statement.loop;

import com.example.expression.Expression;
import com.example.expression.value.LogicalValue;
import com.example.expression.value.Value;

public class WhileLoopStatement extends AbstractLoopStatement {
    private final Expression hasNext;

    public WhileLoopStatement(Integer rowNumber, String blockName, Expression hasNext) {
        super(rowNumber, blockName);
        this.hasNext = hasNext;
    }

    @Override
    protected void init() {
    }

    @Override
    protected boolean hasNext() {
        Value<?> value = hasNext.evaluate();
        return value instanceof LogicalValue && ((LogicalValue) value).getValue();
    }

    @Override
    protected void preIncrement() {
    }

    @Override
    protected void postIncrement() {
    }
}
