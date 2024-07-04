package com.monserrat.app;
import com.monserrat.app.dao.UsuarioDAO;
import com.monserrat.app.model.Usuario;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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
    public ResponseEntity<?> addUsuario(@RequestBody Usuario user) {
        UsuarioDAO userDao=new UsuarioDAO();
        // Check if the user already exists by email
        Usuario existingUser = userDao.findUserByEmail(user.getEmail());
        if (existingUser!= null) {
        // If the user exists, return an error response and status 201
        return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\":\"Ese email ya se encuentra registrado\"}");
        }

        Usuario newUser=new Usuario(user.getEmail(), user.getPass());
        userDao.add(newUser);  
        
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\":\"Usuario registrado correctamente\"}");
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/loginUser")
    public ResponseEntity<?> loginUser(@RequestBody Usuario user) {
        UsuarioDAO userDao=new UsuarioDAO();
        // Check if the user already exists by email and the password matches
        Integer checkUser=userDao.findUser(user.getEmail(), user.getPass());
        switch (checkUser) {
            // Email and password are correct
            case 1:
                return ResponseEntity.ok("{\"message\":\"Usuario logueado correctamente\"}");
            // Password incorrect return status 409
            case 0:
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\":\"Contraseña incorrecta!\"}");
            // User does not exist in db, return status 409
            case -1:
                return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\":\"El usuario con ese email no existe!\"}");
            // Unexpected error, return status 500
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\":\"An unexpected error occurred.\"}");
        }
    }
    

}
