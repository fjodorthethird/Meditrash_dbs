package com.mediTrash.app.Data;


import java.sql.Date;
import java.text.SimpleDateFormat;

public class AuthorisedPerson {

    private int id;
    private String nazev, ico, ulice, misto, psc, provoz, iczujp, upres;
    private Date datum;

    public AuthorisedPerson(int id, String nazev, String ico, String ulice, String misto, String psc, Date datum, String provoz, String iczujp, String upres) {
        this.id = id;
        this.nazev = nazev;
        this.ico = ico;
        this.ulice = ulice;
        this.misto = misto;
        this.psc = psc;
        this.provoz = provoz;
        this.iczujp = iczujp;
        this.upres = upres;
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getMisto() {
        return misto;
    }

    public void setMisto(String misto) {
        this.misto = misto;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getProvoz() {
        return provoz;
    }

    public void setProvoz(String provoz) {
        this.provoz = provoz;
    }

    public String getIczujp() {
        return iczujp;
    }

    public void setIczujp(String iczujp) {
        this.iczujp = iczujp;
    }

    public String getUpres() {
        return upres;
    }

    public void setUpres(String upres) {
        this.upres = upres;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
