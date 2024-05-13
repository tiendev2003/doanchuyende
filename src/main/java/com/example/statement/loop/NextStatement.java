package com.example.statement.loop;

import com.example.context.NextContext;
import com.example.statement.Statement;

public class NextStatement extends Statement {
    public NextStatement(Integer rowNumber, String blockName) {
        super(rowNumber, blockName);
    }

    @Override
    public void execute() {
        NextContext.getScope().invoke();
    }
}
