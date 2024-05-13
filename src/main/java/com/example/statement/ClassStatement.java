package com.example.statement;

import com.example.StatementParser;
import com.example.context.definition.ClassDefinition;
import com.example.token.Token;

import lombok.Getter;

/**
 * Statement for constructor
 * <p>
 *
 * @see ClassDefinition
 * @see StatementParser#parseClassDefinition(Token)
 */
@Getter
public class ClassStatement extends CompositeStatement {
    private final Integer rowNumber;

    public ClassStatement(Integer rowNumber, String blockName) {
        super(rowNumber, blockName);
        this.rowNumber = rowNumber;
    }
}
