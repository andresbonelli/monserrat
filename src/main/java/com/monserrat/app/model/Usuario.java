package com.monserrat.app.model;

public class Usuario {
    private Integer id;
    private String email;
    private String pass;

    public Usuario() {}

     public Usuario(Integer id, String name, String pass) {
        this.id = id;
        this.email = name;
        this.pass = pass;
    }
    
    public Usuario(String name, String pass) {
        this.email = name;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPass() {
        return pass;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setEmail(String name) {
        this.email = name;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }



}
