package com.monserrat.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.monserrat.app.db.MySQLConnector;
import com.monserrat.app.model.Usuario;

public class UsuarioDAO {
    private Statement st;
    private PreparedStatement ps;
    
    public UsuarioDAO() {
        MySQLConnector mysql = new MySQLConnector();

        st = mysql.connectDb();
    }

    public List<Usuario> listar() {
        try {
            ResultSet rs=st.executeQuery("SELECT * FROM usuarios");
            List<Usuario> listaUsuarios = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario user=new Usuario(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("pass"));
                    listaUsuarios.add(user);
                
            }
            System.out.println("[SUCCESS] - Listado de Usuarios fetched correctly");
            return listaUsuarios;
            
        } catch (Exception e) {
            System.err.println("[ERROR] - Connection error: " + e.getMessage());
        }
        return null;
    }

    public Boolean add(Usuario user) {
        try {
            MySQLConnector mysql = new MySQLConnector();

            st = mysql.connectDb();
            String sql = "INSERT INTO usuarios (email,pass) VALUES (?,?)";
            
            ps = mysql.connectPreparedDb(sql);
 
            // Set parameters for the prepared statement
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPass());
            
            ps.executeUpdate();

            System.out.println("[SUCCESS] - Usuario creado");
        
            return true; 
        } 
        catch(Exception e) {
            System.err.println("[ERROR] - Connection error: " + e.getMessage());
        }
        return false;

    }

    public Usuario findUserByEmail(String email) {
        try {
            MySQLConnector mysql = new MySQLConnector();

            st = mysql.connectDb();
            
            ps = mysql.connectPreparedDb("SELECT * FROM usuarios WHERE email=?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) { 
            String userEmail = rs.getString("email");
            String userPass = rs.getString("pass"); 
            
            return new Usuario(userEmail, userPass);
        }

            
        } catch (Exception e) {
            System.err.println("[ERROR] - Connection error: " + e.getMessage());
        }
        return null;
    }

}
