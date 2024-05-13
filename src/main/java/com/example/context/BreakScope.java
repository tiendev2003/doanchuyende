package com.example.context;

import com.example.statement.loop.BreakStatement;

import lombok.Getter;

/**
 * Scope for the loop block defining if the <strong>break</strong> statement invoked
 * <p>
 *
 * @see BreakContext
 * @see BreakStatement
 */
@Getter
public class BreakScope {
    private boolean invoked;

    /**
     * Notify the loop block about invoking the <strong>break</strong> statement
     */
    public void invoke() {
        this.invoked = true;
    }
}
