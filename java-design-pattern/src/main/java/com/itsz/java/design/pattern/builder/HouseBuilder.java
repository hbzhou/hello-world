package com.itsz.java.design.pattern.builder;

/**
 * @author jeremy
 */
public abstract class HouseBuilder {

    private House house;

    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void buildRoof();


    public House build() {
        return house;
    }


}
