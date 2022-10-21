package com.mediTrash.app.ZpusobNakladani;

public class ZpusobNakladani {

    private String zpusob, nazev;

    public ZpusobNakladani(String zpusob, String nazev) {
        this.zpusob = zpusob;
        this.nazev = nazev;
    }

    public String getZpusob() {
        return zpusob;
    }

    public void setZpusob(String zpusob) {
        this.zpusob = zpusob;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }
}
