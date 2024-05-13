package com.example.statement.loop;

import com.example.context.MemoryContext;
import com.example.expression.Expression;
import com.example.expression.VariableExpression;
import com.example.expression.operator.AdditionOperator;
import com.example.expression.operator.LessThanOperator;
import com.example.expression.value.LogicalValue;
import com.example.expression.value.NumericValue;
import com.example.expression.value.Value;

public class ForLoopStatement extends AbstractLoopStatement {
    private final VariableExpression variable;
    private final Expression lowerBound;
    private final Expression uppedBound;
    private final Expression step;
    private static final Expression DEFAULT_STEP = new NumericValue(1.0);

    public ForLoopStatement(Integer rowNumber, String blockName, VariableExpression variable, Expression lowerBound, Expression uppedBound) {
        this(rowNumber, blockName, variable, lowerBound, uppedBound, DEFAULT_STEP);
    }

    public ForLoopStatement(Integer rowNumber, String blockName, VariableExpression variable, Expression lowerBound, Expression uppedBound, Expression step) {
        super(rowNumber, blockName);
        this.variable = variable;
        this.lowerBound = lowerBound;
        this.uppedBound = uppedBound;
        this.step = step;
    }

    @Override
    protected void init() {
        MemoryContext.getScope().set(variable.getName(), lowerBound.evaluate());
    }

    @Override
    protected boolean hasNext() {
        LessThanOperator hasNext = new LessThanOperator(variable, uppedBound);
        Value<?> value = hasNext.evaluate();
        return value instanceof LogicalValue && ((LogicalValue) value).getValue();
    }

    @Override
    protected void preIncrement() {
    }

    @Override
    protected void postIncrement() {
        AdditionOperator stepOperator = new AdditionOperator(variable, step);
        MemoryContext.getScope().set(variable.getName(), stepOperator.evaluate());
    }
}
