package com.itsz.data.structure.stack;

import java.util.Stack;

public class Calculator {

    public Stack<Integer> numStack = new Stack();
    public Stack operStack = new Stack();


    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();

        String expression = "2-3+8/2*2-4";

        char[] chars = expression.toCharArray();
        for (char ch : chars) {
            if (calculator.isOper(ch)) {
                if (calculator.operStack.isEmpty()) {
                    calculator.operStack.push(ch);
                } else {
                    char oper = (char) calculator.operStack.peek();
                    if (calculator.priority(ch) <= calculator.priority(oper)) {
                        int num1 = calculator.numStack.pop();
                        int num2 = calculator.numStack.pop();
                        char operator = (char) calculator.operStack.pop();
                        calculator.numStack.push(calculator.cal(num1, num2, operator));
                    }
                    calculator.operStack.push(ch);
                }
            }
            if (calculator.isNum(ch)) {
                calculator.numStack.push(calculator.char2Int(ch));
            }
        }
        while (!calculator.operStack.isEmpty()) {
            calculator.numStack.push(calculator.cal(calculator.numStack.pop(), calculator.numStack.pop(), (char) calculator.operStack.pop()));
        }
        System.out.println(calculator.numStack.pop());


    }

    public int char2Int(char ch) {
        return (int) ch - (int) '0';
    }

    public int cal(int num1, int num2, int operator) {
        int result = 0;
        switch (operator) {
            case '*':
                result = num1 * num2;
                break;
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:

        }
        return result;
    }

    public int priority(int operator) {

        if (operator == '+' || operator == '-') {
            return 0;
        }

        if (operator == '*' || operator == '/') {
            return 1;
        }

        return -1;
    }

    public boolean isNum(char ch) {
        if (Character.isDigit(ch)) {
            return true;
        }
        return false;
    }

    public boolean isOper(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        }
        return false;
    }


}
