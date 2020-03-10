package com.itsz.java.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class Student {

    private String name;

    private int age;

    private Classroom classroom;


}
