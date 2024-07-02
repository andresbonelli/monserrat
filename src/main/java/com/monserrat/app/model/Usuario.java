package com.monserrat.app.model;

public class Usuario {
    private Integer id;
    private String name;
    private String pass;
    
    public Usuario(Integer id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPass() {
        return pass;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }



}
