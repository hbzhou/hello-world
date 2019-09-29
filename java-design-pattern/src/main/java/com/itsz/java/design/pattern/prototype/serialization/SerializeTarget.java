package com.itsz.java.design.pattern.prototype.serialization;

import java.io.Serializable;

import lombok.Data;

/**
 * @author jeremy
 */
@Data
public class SerializeTarget implements Serializable {

    private String property;

    public SerializeTarget(String property) {
        this.property = property;
    }
}
