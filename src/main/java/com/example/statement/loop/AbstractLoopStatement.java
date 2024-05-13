package com.example.statement.loop;

import com.example.context.BreakContext;
import com.example.context.ExceptionContext;
import com.example.context.MemoryContext;
import com.example.context.NextContext;
import com.example.context.ReturnContext;
import com.example.statement.CompositeStatement;
import com.example.statement.Statement;

public abstract class AbstractLoopStatement extends CompositeStatement {
    public AbstractLoopStatement(Integer rowNumber, String blockName) {
        super(rowNumber, blockName);
    }

    protected abstract void init();

    protected abstract boolean hasNext();

    protected abstract void preIncrement();

    protected abstract void postIncrement();

    @Override
    public void execute() {
        // memory scope for counter variables
        MemoryContext.pushScope(MemoryContext.newScope());
        try {

            // init loop
            init();

            while (hasNext()) {
                preIncrement();

                // isolated memory scope for each iteration
                MemoryContext.pushScope(MemoryContext.newScope());

                try {

                    // execute inner statements
                    for (Statement statement : getStatements2Execute()) {
                        statement.execute();

                        // stop the execution in case Exception occurred
                        if (ExceptionContext.isRaised())
                            return;

                        // stop the execution in case ReturnStatement is invoked
                        if (ReturnContext.getScope().isInvoked())
                            return;

                        // stop the execution in case BreakStatement is invoked
                        if (BreakContext.getScope().isInvoked())
                            return;

                        // jump to the next iteration in case NextStatement is invoked
                        if (NextContext.getScope().isInvoked())
                            break;
                    }
                } finally {
                    NextContext.reset();
                    MemoryContext.endScope(); // release each iteration memory

                    // increment the counter even if the NextStatement is called
                    postIncrement();
                }

            }
        } finally {
            MemoryContext.endScope(); // release loop memory
            BreakContext.reset();
        }
    }
}
