package com.monserrat.app.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.monserrat.app.db.MySQLConnector;
import com.monserrat.app.model.Usuario;

public class UsuarioDAO {
    private Statement st;
    
    public UsuarioDAO() {
        MySQLConnector mysql = new MySQLConnector();

        st = mysql.connectDb();
    }

    public List<Usuario> listar() {
        try {
            ResultSet rs=st.executeQuery("SELECT * FROM usuario");
            List<Usuario> listaUsuarios = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario user=new Usuario(
                    rs.getInt("IDUSUARIO"),
                    rs.getString("NOMBRE"),
                    rs.getString("PASSWORD"));
                    listaUsuarios.add(user);
                
            }
            System.out.println("[SUCCESS] - Listado de Usuarios fetched correctly");
            return listaUsuarios;
            
        } catch (Exception e) {
            System.err.println("[ERROR] - Connection error: " + e.getMessage());
        }
        return null;
    }

}
