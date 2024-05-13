package com.example.statement;

import java.util.function.Supplier;

import com.example.context.MemoryContext;
import com.example.expression.value.LogicalValue;
import com.example.expression.value.NumericValue;
import com.example.expression.value.TextValue;
import com.example.expression.value.Value;
import com.example.token.TokenType;

import lombok.Getter;

@Getter
public class InputStatement extends Statement {
    private final String name;
    private final Supplier<String> consoleSupplier;

    public InputStatement(Integer rowNumber, String blockName, String name, Supplier<String> consoleSupplier) {
        super(rowNumber, blockName);
        this.name = name;
        this.consoleSupplier = consoleSupplier;
    }

    @Override
    public void execute() {
        System.out.printf("enter \"%s\" >>> ", name.replace("_", " "));
        String line = consoleSupplier.get();

        Value<?> value;
        if (line.matches(TokenType.Numeric.getRegex())) {
            value = new NumericValue(Double.parseDouble(line));
        } else if (line.matches(TokenType.Logical.getRegex())) {
            value = new LogicalValue(Boolean.valueOf(line));
        } else {
            value = new TextValue(line);
        }

        MemoryContext.getScope().set(name, value);
    }
}
