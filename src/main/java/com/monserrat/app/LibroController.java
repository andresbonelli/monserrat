package com.monserrat.app;

import com.monserrat.app.model.Libro;
import com.monserrat.app.dao.LibroDAO;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LibroController {

    @CrossOrigin(origins = "*")
    @GetMapping("/listarLibros")
    public List<Libro> getLibros() {
        LibroDAO libroDao=new LibroDAO();
        return libroDao.listar();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addLibro")
    public void addLibro(@RequestBody String titulo, String genero) {
        Libro libro=new Libro(titulo, genero);
        LibroDAO libroDao=new LibroDAO();
        libroDao.add(libro);   
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delLibro/{id}")
    public void delLibro(@PathVariable("id") Integer id) {
        Libro libro=new Libro(id);

        LibroDAO libroDao=new LibroDAO();
        libroDao.del(libro);
    }
}
