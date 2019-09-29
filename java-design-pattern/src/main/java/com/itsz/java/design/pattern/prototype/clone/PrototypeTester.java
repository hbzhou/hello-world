package com.itsz.java.design.pattern.prototype.clone;

/**
 *
 * 主要两种方式来做原型模式
 * 1. deepclone
 * 2. ObjectInputStream 对象流的方式
 * @author jeremy
 */
public class PrototypeTester {

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepCloneableTarget target = new DeepCloneableTarget("property");
        DeepPrototype  prototype = new DeepPrototype("zhangsan",target);

        DeepPrototype prototype1 = ((DeepPrototype) prototype.clone());
        DeepPrototype prototype2 = ((DeepPrototype) prototype.clone());
        DeepPrototype prototype3 = ((DeepPrototype) prototype.clone());
        DeepPrototype prototype4 = ((DeepPrototype) prototype.clone());
        DeepPrototype prototype5 = ((DeepPrototype) prototype.clone());

        System.out.println("1=============="+prototype1);

        System.out.println("2=============="+prototype2);

        System.out.println("3=============="+prototype3);

        System.out.println("4=============="+prototype4);

        System.out.println("5=============="+prototype5);

    }
}
