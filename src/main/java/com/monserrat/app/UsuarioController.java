package com.monserrat.app;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monserrat.app.dao.UsuarioDAO;
import com.monserrat.app.model.Usuario;

@RestController
public class UsuarioController {

    @CrossOrigin(origins = "*")
    @GetMapping("/listarUsuarios")
    public List<Usuario> getUsuarios() {
        UsuarioDAO userDao=new UsuarioDAO();
        return userDao.listar();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addUser")
    public ResponseEntity<String> addUsuario(@RequestBody Usuario user) {
        UsuarioDAO userDao=new UsuarioDAO();
        // Check if the user already exists by email
        Usuario existingUser = userDao.findUserByEmail(user.getEmail());
        if (existingUser!= null) {
        // If the user exists, return an error response
        return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\":\"Ese email ya se encuentra registrado\"}");
        }

        Usuario newUser=new Usuario(user.getEmail(), user.getPass());
        userDao.add(newUser);  
        
        return ResponseEntity.ok("{\"message\":\"Usuario registrado correctamente\"}");
    }

}
