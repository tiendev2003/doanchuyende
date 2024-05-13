package com.example.context.definition;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.example.StatementParser;
import com.example.statement.FunctionStatement;
import com.example.token.Token;

/**
 * Definition for a function
 * <p>
 *
 * @see StatementParser#parseFunctionDefinition(Token)
 */
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FunctionDefinition implements Definition {
    /**
     * Details for a function
     */
    @EqualsAndHashCode.Include
    private final FunctionDetails details;
    /**
     * Statement(s) defined in the function body
     */
    private final FunctionStatement statement;
    /**
     * Contains nested classes and functions defined in this function
     */
    private final DefinitionScope definitionScope;
}
