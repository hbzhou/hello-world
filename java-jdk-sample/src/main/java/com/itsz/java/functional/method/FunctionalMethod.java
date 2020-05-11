package com.itsz.java.functional.method;


import sun.rmi.runtime.Log;

import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FunctionalMethod {

    static class LogicTreeNode<T> {
        LogicTreeNode<T> left;
        LogicTreeNode<T> right;
        Predicate<T> condition;
        Function<T, T> trueHandler;
        Function<T, T> falseHandler;

        public LogicTreeNode(LogicTreeNode<T> left, LogicTreeNode<T> right,
                             Predicate<T> condition, UnaryOperator<T> trueHandler,
                             UnaryOperator<T> falseHandler) {
            this.left = left;
            this.right = right;
            this.condition = condition;
            this.trueHandler = trueHandler;
            this.falseHandler = falseHandler;
        }

        public T calculate(T input) {
            T output = input;
            LogicTreeNode<T> currentNode = this;
            while (Objects.nonNull(currentNode)) {
                if (currentNode.condition.test(output)) {
                    output = currentNode.trueHandler.apply(output);
                    currentNode = currentNode.left;
                } else {
                    output = falseHandler.apply(output);
                    currentNode = currentNode.right;
                }
            }
            return output;
        }
    }

    public static LogicTreeNode createLogicTree() {
        Predicate<Integer> condition = input -> input < 20;
        UnaryOperator<Integer> trueHandler = input -> input * 2;
        UnaryOperator<Integer> falseHandler = input -> input / 2;
        LogicTreeNode<Integer> leftNode = new LogicTreeNode<Integer>(null, null, condition, trueHandler, falseHandler);
        LogicTreeNode<Integer> rightNode = new LogicTreeNode<>(null, null, condition, trueHandler, falseHandler);
        LogicTreeNode<Integer> rootNode = new LogicTreeNode<>(leftNode, rightNode, condition, trueHandler, falseHandler);
        return rootNode;
    }

    public static void main(String[] args) {
        LogicTreeNode logicTree = FunctionalMethod.createLogicTree();
        System.out.println(logicTree.calculate(11));
        int i = new Random().nextInt(101);

    }

}

