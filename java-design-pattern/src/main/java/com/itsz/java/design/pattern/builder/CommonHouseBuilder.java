package com.itsz.java.design.pattern.builder;

/**
 * @author jeremy
 */
public class CommonHouseBuilder extends HouseBuilder {


    @Override
    public void buildBasic() {
        System.out.println("common house building basic....");

    }

    @Override
    public void buildWalls() {
        System.out.println("common house building walls....");

    }

    @Override
    public void buildRoof() {
        System.out.println("common house building roof....");

    }
}
