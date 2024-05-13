package com.example.context;

import com.example.statement.loop.AbstractLoopStatement;
import com.example.statement.loop.NextStatement;

/**
 * Associates a given {@link NextScope} with a loop block
 * <p>
 *
 * @see AbstractLoopStatement
 * @see NextStatement
 */
public class NextContext {
    private static NextScope scope = new NextScope();

    /**
     * Get current {@link NextScope}
     */
    public static NextScope getScope() {
        return scope;
    }

    /**
     * Reset state of the {@link NextContext} on loop exit
     */
    public static void reset() {
        NextContext.scope = new NextScope();
    }
}
