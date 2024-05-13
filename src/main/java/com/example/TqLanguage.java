package com.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.example.context.ExceptionContext;
import com.example.context.MemoryContext;
import com.example.context.definition.DefinitionContext;
import com.example.statement.CompositeStatement;
import com.example.token.Token;

import lombok.SneakyThrows;

public class TqLanguage {
    @SneakyThrows
    public void execute(Path path) {
        String sourceCode = Files.readString(path);

        List<Token> tokens = LexicalParser.parse(sourceCode);

        DefinitionContext.pushScope(DefinitionContext.newScope());
        MemoryContext.pushScope(MemoryContext.newScope());
        try {
            CompositeStatement statement = new CompositeStatement(null, path.getFileName().toString());
            StatementParser.parse(tokens, statement);
            statement.execute();
        } finally {
            DefinitionContext.endScope();
            MemoryContext.endScope();

            if (ExceptionContext.isRaised()) {
                ExceptionContext.printStackTrace();
            }
        }
    }
}
