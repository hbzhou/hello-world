package com.itsz.java.design.pattern.composite;

public class Department extends CompositeComponent {


    public Department(String name, String desc) {
        super(name, desc);
    }

    @Override
    public void print() {
        System.out.println(getDesc()+" "+ getName());
    }
}
