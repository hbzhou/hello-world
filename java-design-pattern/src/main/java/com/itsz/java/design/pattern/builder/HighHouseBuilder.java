package com.itsz.java.design.pattern.builder;

public class HighHouseBuilder extends HouseBuilder {


    @Override
    public void buildBasic() {
        System.out.println("high house building basic....");
    }

    @Override
    public void buildWalls() {
        System.out.println("high house building walls...");

    }

    @Override
    public void buildRoof() {
        System.out.println("high house building roof....");
    }
}
