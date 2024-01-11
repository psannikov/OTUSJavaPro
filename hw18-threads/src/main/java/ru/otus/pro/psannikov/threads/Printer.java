package ru.otus.pro.psannikov.threads;

public class Printer {
    private int cnt=0;
    private static final int MINVALUE = 0;
    private static final int MAXVALUE = 10;
    private int incr = 1;
    public void printNumbers() {
             if (cnt>MINVALUE && cnt<MAXVALUE) {
                 System.out.println(cnt);
             } else {
                 if (cnt==0) {
                     System.out.println(cnt);
                     incr = 1;
                 } else {
                     System.out.println(cnt);
                     incr = -1;
                 }
             }
             cnt = cnt + incr;
    }
}
