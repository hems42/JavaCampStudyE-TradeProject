package Entities.concretes;

import Entities.abstracts.Entity;


public class User implements Entity {

    private int id;
    private String name;
    private String surname;
    private String eMail;
    private String password;
    private String sex;

    public User(int id,String name, String surname, String eMail, String password, String sex) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.password = password;
        this.sex = sex;
    }

    public User() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
