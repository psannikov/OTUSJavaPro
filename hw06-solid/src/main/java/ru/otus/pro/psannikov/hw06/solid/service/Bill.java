package ru.otus.pro.psannikov.hw06.solid.service;

public class Bill {
    private final String name;
    private final int valNote1;
    private final int valNote2;
    private final int valNote3;
    private final int valNote4;
    public static Builder builder () {return new Builder();}
    private Bill (Builder builder) {
        name = builder.name;
        valNote1 = builder.valNote1;
        valNote2 = builder.valNote2;
        valNote3 = builder.valNote3;
        valNote4 = builder.valNote4;
    }
    static final class Builder {
        private String name;
        int valNote1;
        int valNote2;
        int valNote3;
        int valNote4;
        public Bill build() {return new Bill(this);}
        public Builder setName(String name){this.name = name; return this;}
        public Builder setValNote1(int valNote1){this.valNote1 = valNote1; return this;}
        public Builder setValNote2(int valNote2){this.valNote2 = valNote2; return this;}
        public Builder setValNote3(int valNote3){this.valNote3 = valNote3; return this;}
        public Builder setValNote4(int valNote4){this.valNote4 = valNote4; return this;}
    }
}

