package com.itsz.java.design.pattern.builder;

public class HouseBuilderTester {

    public static void main(String[] args) {

        HouseBuilder builder = new CommonHouseBuilder();

        HouseBuildDirector director = new HouseBuildDirector(builder);

        director.buildHouse();

        //换个建房子的人来玩
        director.setHouseBuilder(new HighHouseBuilder());

        director.buildHouse();


    }
}
