package com.example.statement.loop;

import com.example.context.BreakContext;
import com.example.statement.Statement;

public class BreakStatement extends Statement {
    public BreakStatement(Integer rowNumber, String blockName) {
        super(rowNumber, blockName);
    }

    @Override
    public void execute() {
        BreakContext.getScope().invoke();
    }
}
