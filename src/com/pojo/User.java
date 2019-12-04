package com.pojo;

public class User {
    public String username;
    public String password;
    public String identity;

    public User(String username, String password, String identity) {
        this.username = username;
        this.password = password;
        this.identity = identity;
    }
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() { return identity; }

    public void setIdentity(String identity) { this.identity = identity; }
    @Override
    public String toString(){
        return "username:"+username+",password:"+password+",identity:"+identity+"";
    }
}
