package com.mediTrash.app.Data;

//Класс для пользователя, всё для работы с ним

public class User {

    private int id;
    private String name;
    private String userAddress;
    private String city;
    private String postcode;
    private String userICO;
    private String userPhone;
    private String email;
    private String fax;
    private String legalPerson;
    private String login;
    private String password;
    private String officeCode;

    public User(int id, String name, String userAddress,
                String city, String postcode, String userICO,
                String userPhone, String email, String fax, String legalPerson,
                String login, String password, String officeCode) {
        this.id = id;
        this.name = name;
        this.userAddress = userAddress;
        this.city = city;
        this.postcode = postcode;
        this.userICO = userICO;
        this.userPhone = userPhone;
        this.email = email;
        this.fax = fax;
        this.legalPerson = legalPerson;
        this.login = login;
        this.password = password;
        this.officeCode = officeCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getUserICO() {
        return userICO;
    }

    public void setUserICO(String userICO) {
        this.userICO = userICO;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }
}
