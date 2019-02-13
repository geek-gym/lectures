package ru.meistersoft;

import java.util.*;

class CalculatorStack {

    private Stack<Double> valuesStack;
    private Stack<CalculatorOperator> operatorsStack;
    private Map<CalculatorOperator, Integer> operatorsPrecedence;
    private Map<CalculatorOperator, Runnable> operatorsFunctions;

    CalculatorStack(){
        this.valuesStack = new Stack<>();
        this.operatorsStack = new Stack<>();
        this.operatorsPrecedence = CreatePrecedenceMap();
        this.operatorsFunctions = CreateFunctionsMap();
    }

    void PushValue(Double value){
        this.valuesStack.push(value);
    }

    void PushOperator(CalculatorOperator operator) {
        if (this.operatorsStack.isEmpty()) {
            this.operatorsStack.push(operator);
            return;
        }

        if (this.operatorsPrecedence.get(this.operatorsStack.peek()) < this.operatorsPrecedence.get(operator)) {
            this.operatorsStack.push(operator);
        }
        else {
            Runnable function = this.operatorsFunctions.get(this.operatorsStack.pop());
            function.run();
            PushOperator(operator);
        }
    }

    double GetResult() {
        while (!this.operatorsStack.isEmpty()) {
            Runnable function = this.operatorsFunctions.get(this.operatorsStack.pop());
            function.run();
        }
        return this.valuesStack.firstElement();
    }

    void Clear() {
        this.valuesStack.empty();
        this.operatorsStack.empty();
    }

    private Map<CalculatorOperator, Integer> CreatePrecedenceMap() {
        Map<CalculatorOperator, Integer> result = new HashMap<>();
        result.put(CalculatorOperator.Add, 1);
        result.put(CalculatorOperator.Sub, 1);
        result.put(CalculatorOperator.Mul, 2);
        result.put(CalculatorOperator.Div, 2);
        return result;
    }

    private Map<CalculatorOperator, Runnable> CreateFunctionsMap() {
        Map<CalculatorOperator, Runnable> result = new HashMap<>();
        result.put(CalculatorOperator.Add, this::Add);
        result.put(CalculatorOperator.Sub, this::Sub);
        result.put(CalculatorOperator.Div, this::Div);
        result.put(CalculatorOperator.Mul, this::Mul);
        return result;
    }

    private void Add() {
        double left = this.valuesStack.pop();
        double right = this.valuesStack.pop();
        valuesStack.push(left + right);
    }

    private void Sub() {
        double right = this.valuesStack.pop();
        double left = this.valuesStack.pop();
        valuesStack.push(left - right);
    }

    private void Mul() {
        double left = this.valuesStack.pop();
        double right = this.valuesStack.pop();
        valuesStack.push(left * right);
    }

    private void Div() {
        double right = this.valuesStack.pop();
        double left = this.valuesStack.pop();
        if (right == 0) {
            throw new ArithmeticException("division by 0");
        }
        valuesStack.push(left / right);
    }
}