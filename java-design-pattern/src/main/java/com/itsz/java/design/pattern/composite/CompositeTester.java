package com.itsz.java.design.pattern.composite;

public class CompositeTester  {

    public static void main(String[] args) {

        CompositeComponent  university = new University("清华大学","中国顶级学府");

        CompositeComponent  softCollege = new College("软件学院","软件学习");
        CompositeComponent bussinessCollege = new College("商学院","商业学习");

        CompositeComponent softDepartment = new Department("软件工程","软件工程学习");
        CompositeComponent engineerDepartment = new Department("计算机","计算机学习");

        softCollege.add(softDepartment);
        softCollege.add(engineerDepartment);


        bussinessCollege.add(new Department("会计专业","会计学习"));
        bussinessCollege.add(new Department("财经专业", "财务学习"));

        university.add(softCollege);
        university.add(bussinessCollege);


        university.print();
    }
}
