package com.example.expression.operator;

import com.example.context.definition.ClassDetails;
import com.example.expression.Expression;
import com.example.expression.VariableExpression;
import com.example.expression.value.ClassValue;
import com.example.expression.value.Value;

/**
 * Cast a class instance from one type to other
 */
public class ClassCastOperator extends BinaryOperatorExpression {
    public ClassCastOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Value<?> evaluate() {
        Value<?> left = getLeft().evaluate();
        if (left == null) return null;

        // evaluate expressions
        ClassValue classInstance = (ClassValue) left;
        String typeToCastName = ((VariableExpression) getRight()).getName();

        // retrieve class details
        ClassDetails classDetails = classInstance.getValue().getClassDetails();

        // check if the type to cast is different from original
        if (classDetails.getName().equals(typeToCastName)) {
            return classInstance;
        } else {
            // retrieve ClassValue of other type
            return classInstance.getRelation(typeToCastName);
        }
    }
}
