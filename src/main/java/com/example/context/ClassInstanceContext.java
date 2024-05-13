package com.example.context;

import java.util.Stack;

import com.example.expression.ExpressionReader;
import com.example.expression.FunctionExpression;
import com.example.expression.value.ClassValue;
import com.example.expression.value.ThisValue;

/**
 * Associates a given {@link ClassValue} with <strong>this</strong> reference for the current block of code
 * <p>
 *
 * @see ThisValue#getValue()
 * @see ExpressionReader
 * @see FunctionExpression
 */
public class ClassInstanceContext {
    private static final Stack<ClassValue> values = new Stack<>();

    /**
     * Get current <strong>this</strong> reference
     */
    public static ClassValue getValue() {
        return values.peek();
    }

    /**
     * Push new <strong>this</strong> reference when entering a class's constructor or invoking a class's function
     */
    public static void pushValue(ClassValue instance) {
        values.push(instance);
    }

    /**
     * Pop <strong>this</strong> reference on block exit
     */
    public static void popValue() {
        values.pop();
    }
}
