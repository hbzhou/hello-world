package com.itsz.java.design.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class University extends CompositeComponent {

    private List<CompositeComponent> compositeComponentList = new ArrayList<>();


    public University(String name, String desc) {
        super(name, desc);
    }

    @Override
    public void add(CompositeComponent component) {
        compositeComponentList.add(component);
    }

    @Override
    public void remove(CompositeComponent component) {
        compositeComponentList.remove(component);
    }

    @Override
    public void print() {
        System.out.println("=========="+getName()+"=============");
        for (CompositeComponent compositeComponent : compositeComponentList) {
            compositeComponent.print();
        }

    }
}
