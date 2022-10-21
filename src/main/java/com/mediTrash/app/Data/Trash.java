package com.mediTrash.app.Data;

//Класс для мусора, чтобы легче было его создавать

public class Trash {

    private String nameOfTrash;
    private int trashId;
    private String category;
    private float countOfTrash;
    private int trashCode;

    public Trash(String nameOfTrash, int trashId, String category, float countOfTrash) {
        this.nameOfTrash = nameOfTrash;
        this.trashId = trashId;
        this.category = category;
        this.countOfTrash = countOfTrash;
    }

    public Trash(String nameOfTrash, float countOfTrash) {
        this.nameOfTrash = nameOfTrash;
        this.countOfTrash = countOfTrash;
    }

    public Trash(String nameOfTrash, float countOfTrash, int trashId) {
        this.nameOfTrash = nameOfTrash;
        this.countOfTrash = countOfTrash;
        this.trashId = trashId;
    }

    public Trash (String nameOfTrash) {
        this.nameOfTrash = nameOfTrash;
    }


    public String getNameOfTrash() {
        return nameOfTrash;
    }

    public void setNameOfTrash(String nameOfTrash) {
        this.nameOfTrash = nameOfTrash;
    }

    public int getTrashId() {
        return trashId;
    }

    public void setTrashId(int trashId) {
        this.trashId = trashId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCountOfTrash() {
        return countOfTrash;
    }

    public void setCountOfTrash(int countOfTrash) {
        this.countOfTrash = countOfTrash;
    }

    public int getTrashCode() {
        return trashCode;
    }

    public void setTrashCode(int trashCode) {
        this.trashCode = trashCode;
    }
}