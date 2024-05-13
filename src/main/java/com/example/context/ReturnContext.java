package com.example.context;

import com.example.expression.FunctionExpression;
import com.example.statement.ReturnStatement;
import com.example.statement.loop.AbstractLoopStatement;

/**
 * Associates a given {@link ReturnScope} with {@link org.example.toylanguage.statement.CompositeStatement}
 * <p>
 *
 * @see AbstractLoopStatement
 * @see ReturnStatement
 * @see FunctionExpression
 */
public class ReturnContext {
    private static ReturnScope scope = new ReturnScope();

    /**
     * Get current {@link ReturnScope}
     */
    public static ReturnScope getScope() {
        return scope;
    }

    /**
     * Reset state of the {@link ReturnContext} on block exit
     */
    public static void reset() {
        ReturnContext.scope = new ReturnScope();
    }
}
