package com.itsz.java.design.pattern.composite;

import lombok.Data;

@Data
public abstract class CompositeComponent {

    private String name;

    private String desc;


    public CompositeComponent(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    public void add(CompositeComponent component){
        throw new UnsupportedOperationException();
    }

    public void remove (CompositeComponent component){
        throw new UnsupportedOperationException();
    }

    public abstract void print();
}
