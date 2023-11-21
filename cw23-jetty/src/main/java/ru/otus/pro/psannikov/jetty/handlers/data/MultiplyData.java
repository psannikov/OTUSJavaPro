package ru.otus.pro.psannikov.jetty.handlers.data;

public class MultiplyData {
    Double arg1;
    Double arg2;
    Double result;

    public MultiplyData(final Double arg1, final Double arg2, final Double result) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.result = result;
    }

    public Double getArg1() {
        return arg1;
    }

    public void setArg1(final Double arg1) {
        this.arg1 = arg1;
    }

    public Double getArg2() {
        return arg2;
    }

    public void setArg2(final Double arg2) {
        this.arg2 = arg2;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(final Double result) {
        this.result = result;
    }
}
