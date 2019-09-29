package com.itsz.java.design.pattern.prototype.clone;

import lombok.Data;

@Data
public class DeepPrototype  implements  Cloneable{

    private String name ;

    private DeepCloneableTarget target;


    public DeepPrototype(String name, DeepCloneableTarget target) {
        this.name = name;
        this.target = target;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepPrototype deepProtoType = (DeepPrototype)super.clone();
        deepProtoType.target = ((DeepCloneableTarget) target.clone());
        return deepProtoType;
    }
}
