package ru.otus.pro.psannikov.cw12.creational_patterns;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class Builder {
    public static void main(String[] args) {
        CarForBuilder car = CarForBuilder.builder().setChassis("chassis")
                .setPaint("paint")
                .setBody("body")
                .setInterior("interior")
                .build();
        System.out.println(car);
    }
}
@ToString
final class CarForBuilder {
    private final String chassis;
    private final String body;
    private final String paint;
    private final String interior;

    public static BuilderForCar builder () {return new BuilderForCar();}
    private CarForBuilder (BuilderForCar builder) {
        chassis = builder.chassis;
        body = builder.body;
        paint = builder.paint;
        interior = builder.interior;
    }
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static final class BuilderForCar {
        private String chassis;
        private String body;
        private String paint;
        private String interior;
        public CarForBuilder build() {return new CarForBuilder(this);}
        public BuilderForCar setChassis(String chassis){this.chassis = chassis; return this;}
        public BuilderForCar setBody(String body){this.body = body; return this;}
        public BuilderForCar setPaint(String paint){this.paint = paint; return this;}
        public BuilderForCar setInterior(String interior){this.interior = interior; return this;}
    }
}
