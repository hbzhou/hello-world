package com.itsz.java.design.pattern.prototype.serialization;

import java.io.Serializable;

import lombok.Data;

/**
 * @author jeremy
 */
@Data
public class SerializationPrototype  implements Serializable {

    private String name;

    private SerializeTarget target;

    public SerializationPrototype(String name, SerializeTarget target) {
        this.name = name;
       // this.target =target;
    }
}
