package com.mediTrash.app.Data;

import java.sql.Timestamp;

public class WasteDisposal {

    String name;
    String trashName;
    String category;
    float count;

    public int getVhid() {
        return vhid;
    }

    public void setVhid(int vhid) {
        this.vhid = vhid;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    int ico, vhid;
    String code;
    java.sql.Timestamp date;

    public WasteDisposal(int vhid, String name, String trashName, String category, float count, int ico, String code, java.sql.Timestamp d) {
        this.vhid = vhid;
        this.name = name;
        this.trashName = trashName;
        this.category = category;
        this.count = count;
        this.ico = ico;
        this.code = code;
        this.date = d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrashName() {
        return trashName;
    }

    public void setTrashName(String trashName) {
        this.trashName = trashName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIco() {
        return ico;
    }

    public void setIco(int ico) {
        this.ico = ico;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}