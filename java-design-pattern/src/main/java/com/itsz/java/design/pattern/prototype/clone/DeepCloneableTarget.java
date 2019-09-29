package com.itsz.java.design.pattern.prototype.clone;

import lombok.Data;

@Data
public class DeepCloneableTarget implements Cloneable {

    private String property;

    public DeepCloneableTarget(String property) {
        this.property = property;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
