package com.itsz.data.structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jeremy
 * <p>
 * 支持括号，加减乘除的运算
 * 关键点：
 * 需要将 中缀表达式变成后缀表达式
 * 中缀表达式： 1+((2+3)*4)-5
 * 后缀表达式：1 2 3 + 4 * + 5 -
 */
public class SeniorCalculator {

    Stack<String> stack = new Stack();

    List<String> expression = new ArrayList<>();

    /**
     * 将输入的中缀表达式转为后缀表达式
     *
     * @param input
     */
    private void input2Expression(String input) {
        char[] charArray = input.toCharArray();
        for (char ch : charArray) {
            //如果是数字，直接将ch,放进表达式集合
            if (Character.isDigit(ch)) {
                expression.add(String.valueOf(ch));
            } else {
                //如果表达式空栈,直接入栈
                if (stack.isEmpty()) {
                    stack.push(String.valueOf(ch));
                    continue;
                }
                char top = stack.peek().charAt(0);
                if (')' == ch) {
                    while ('(' != top) {
                        expression.add(String.valueOf(stack.pop()));
                        top = stack.peek().charAt(0);
                    }
                    //将左括号出栈
                    stack.pop();
                    continue;
                }

                if ('(' == ch || priority(top) < priority(ch)) {
                    stack.push(String.valueOf(ch));
                    continue;
                }


                if (priority(top) >= priority(ch)) {
                    //将栈中的所有元素依次出栈，直到栈顶元素优先级大于当前操作符,
                    while (!stack.isEmpty() && priority(top) >= priority(ch) && top != '(') {
                        expression.add(String.valueOf(stack.pop()));
                        if (!stack.isEmpty()) {
                            top = stack.peek().charAt(0);
                        }
                    }
                    //将当前操作符入栈
                    stack.push(String.valueOf(ch));
                }
            }

        }

        //将栈中的所有元素压入栈中
        while (!stack.isEmpty()) {
            expression.add(stack.pop());
        }


    }


    /**
     * 获取操作符的优先级
     *
     * @param ch
     * @return
     */
    private int priority(char ch) {
        if ('+' == ch || '-' == ch) {
            return 0;
        }

        if ('*' == ch || '/' == ch) {
            return 1;
        }

        if ('(' == ch || ')' == ch) {
            return 2;
        }
        return -1;

    }

    /**
     * 将后缀表达式计算得到最后结果
     *
     * @return
     */

    private int calculateResult() {
        for (String expression : expression) {
            char ch = expression.charAt(0);
            if (Character.isDigit(ch)) {
                stack.push(expression);
                continue;
            }
            int num1 = Integer.valueOf(stack.pop());
            int num2 = Integer.valueOf(stack.pop());
            if ('+' == ch) {
                stack.push(String.valueOf(num1 + num2));
                continue;
            }

            if ('-' == ch) {
                stack.push(String.valueOf(num2 - num1));
                continue;
            }

            if ('*' == ch) {
                stack.push(String.valueOf(num1 * num2));
                continue;
            }

            if ('/' == ch) {
                stack.push(String.valueOf(num2 / num1));
                continue;
            }
        }

        return Integer.valueOf(stack.pop());
    }


    /**
     * 计算方法
     *
     * @param input
     * @return
     */
    public int calculate(String input) {
        input2Expression(input);
        return calculateResult();
    }

}
