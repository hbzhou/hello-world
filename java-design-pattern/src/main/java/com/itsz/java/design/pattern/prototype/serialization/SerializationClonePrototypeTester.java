package com.itsz.java.design.pattern.prototype.serialization;


public class SerializationClonePrototypeTester {

    public static void main(String[] args) {

        SerializeTarget target = new SerializeTarget("property");
        SerializationPrototype prototype = new SerializationPrototype("zhangsan",target);

        SerializationPrototype prototype1 = ((SerializationPrototype) CloneUtil.getObject(prototype));
        SerializationPrototype prototype2 = ((SerializationPrototype) CloneUtil.getObject(prototype));
        SerializationPrototype prototype3 = ((SerializationPrototype) CloneUtil.getObject(prototype));
        SerializationPrototype prototype4 = ((SerializationPrototype) CloneUtil.getObject(prototype));
        SerializationPrototype prototype5 = ((SerializationPrototype) CloneUtil.getObject(prototype));



        System.out.println("1=============="+prototype1);

        System.out.println("2=============="+prototype2);

        System.out.println("3=============="+prototype3);

        System.out.println("4=============="+prototype4);

        System.out.println("5=============="+prototype5);

    }
}
