package ru.meistersoft;

import java.security.InvalidParameterException;

class CommandExecutor {
    private CalculatorStack stack;
    private String validCommands = "0123456789.+-/*C~=";
    private String calculator_line;
    private boolean init_line;

    CommandExecutor(CalculatorStack stack) {
        this.stack = stack;
        this.calculator_line = "0";
        this.init_line = true;
    }

    String GetState() {
        return this.calculator_line;
    }

    void PushCommand(String command) {
        CheckCommand(command);

        if (command.equalsIgnoreCase("c")) {
            this.calculator_line = "0";
            this.stack.Clear();
            return;
        }

        if (command.equals(".")) {
            if (this.init_line) {
                this.calculator_line = "";
                this.init_line = false;
            }
            if (this.calculator_line.contains("."))
                return;
            this.calculator_line += command;
            return;
        }

        if (command.equals("0")) {
            if (this.init_line) {
                this.calculator_line = "";
                this.init_line = false;
            }
            if (this.calculator_line.equals("0"))
                return;
            this.calculator_line += command;
            return;
        }

        if ("123456789".contains(command)) {
            if (this.init_line) {
                this.calculator_line = "";
                this.init_line = false;
            }
            this.calculator_line += command;
            return;
        }

        if (command.equals("~")) {
            if (this.calculator_line.charAt(0) == '-') {
                this.calculator_line = this.calculator_line.substring(1);
            }
            else {
                this.calculator_line = "-" + this.calculator_line;
            }
        }

        if (command.equals("+")) {
            double curr_operand = Double.parseDouble(this.calculator_line);
            this.stack.PushValue(curr_operand);
            this.stack.PushOperator(CalculatorOperator.Add);
            this.init_line = true;
        }

        if (command.equals("-")) {
            double curr_operand = Double.parseDouble(this.calculator_line);
            this.stack.PushValue(curr_operand);
            this.stack.PushOperator(CalculatorOperator.Sub);
            this.init_line = true;
        }

        if (command.equals("*")) {
            double curr_operand = Double.parseDouble(this.calculator_line);
            this.stack.PushValue(curr_operand);
            this.stack.PushOperator(CalculatorOperator.Mul);
            this.init_line = true;
        }

        if (command.equals("/")) {
            double curr_operand = Double.parseDouble(this.calculator_line);
            this.stack.PushValue(curr_operand);
            this.stack.PushOperator(CalculatorOperator.Div);
            this.init_line = true;
        }

        if (command.equals("=")) {
            double curr_operand = Double.parseDouble(this.calculator_line);
            this.stack.PushValue(curr_operand);
            this.calculator_line = Double.toString(this.stack.GetResult());
            this.init_line = true;
        }
    }

    private void CheckCommand(String command){
        if (command.length() == 1 && validCommands.contains(command))
            return;
        throw new InvalidParameterException(String.format("Command %s is not available.", command));
    }
}
