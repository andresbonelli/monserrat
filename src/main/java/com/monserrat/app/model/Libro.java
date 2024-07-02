package com.monserrat.app.model;

public class Libro {
    private Integer id;
    private String titulo;
    private String genero;

    
    public Libro(Integer id, String titulo, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
    }

    public Libro(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
    }

    public Libro(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


 
}
