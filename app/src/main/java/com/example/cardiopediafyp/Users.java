package com.example.cardiopediafyp;

public class Users {
    private String Uid;
    private String name;
    private String email;
    private String password;
    private int usertype;

    public Users(){

    }

    public Users(String uid, String name, String email, String password, int usertype) {
        this.Uid = uid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
