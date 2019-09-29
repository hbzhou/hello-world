package com.itsz.java.design.pattern.builder;

import lombok.Data;

/**
 * @author jeremy
 */
@Data
public class HouseBuildDirector {

    private HouseBuilder houseBuilder;


    public HouseBuildDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House buildHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.buildRoof();
        return houseBuilder.build();
    }
}
