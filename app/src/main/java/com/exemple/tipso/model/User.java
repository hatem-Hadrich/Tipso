package com.exemple.tipso.model;

/**
 * Created by adib on 23/04/15.
 */
public class User {
    private int idUser;
    private String firstName;
    private String secondName;
    private String email;
    private String passWord;
    private String mobile;
    private String job;
    private String gender;
    private String language;
    private String birthday;
    private String country;

    public User(){}
    public User(int idUser, String firstName, String secondName, String email, String passWord, String mobile, String job, String gender, String language, String birthday, String country) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.passWord = passWord;
        this.mobile = mobile;
        this.job = job;
        this.gender = gender;
        this.language = language;
        this.birthday = birthday;
        this.country = country;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
