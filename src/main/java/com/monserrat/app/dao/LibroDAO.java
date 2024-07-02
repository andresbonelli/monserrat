package com.monserrat.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.monserrat.app.db.MySQLConnector;
import com.monserrat.app.model.Libro;

/**
 * Class containing methods for SQL querys
 */
public class LibroDAO {
    private Statement st;
    private PreparedStatement ps;
    
    public LibroDAO() {
        MySQLConnector mysql = new MySQLConnector();

        st = mysql.connectDb();
        
    }

    public List<Libro> listar() {
        try {
            ResultSet rs=st.executeQuery("SELECT * FROM libros");
            List<Libro> listaLibros = new ArrayList<Libro>();
            while (rs.next()) {

                
                Integer id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String genero = rs.getString("genero");
                
               

               

            Libro libro = new Libro(id, titulo, genero);
            listaLibros.add(libro);
                
            }
            System.out.println("[SUCCESS] - Listado de Libros fetched correctly");
            return listaLibros;
            
        } catch (Exception e) {
            System.err.println("[ERROR] - Connection error: " + e.getMessage());
        }
        return null;
    }

    public Boolean add(Libro libro) {
        try {
            MySQLConnector mysql = new MySQLConnector();

            st = mysql.connectDb();
            String sql = "INSERT INTO libro (id,titulo,genero) VALUES (?,?,?)";
            
            ps = mysql.connectPreparedDb(sql);
 
            
            // Set parameters for the prepared statement
            ps.setInt(1,libro.getId());
            
            // Check for possible null parameters
            if (libro.getTitulo()!=null) {
                ps.setString(2, libro.getTitulo());
            } else {
                ps.setNull(2, 0);
            }
            if (libro.getGenero()!=null) {
                ps.setString(3, libro.getGenero());
            } else {
                ps.setNull(3, 0);
            }
            
            ps.executeUpdate();
        
            return true; 
        } 
        catch(Exception e) {
            System.err.println("[ERROR] - Connection error: " + e.getMessage());
        }
        return false;

    }

    public Boolean del(Libro libro) {
        try {
            Integer cantDel=st.executeUpdate("DELETE FROM libros WHERE id="+libro.getId());

            Boolean delOk=(cantDel==1);
            System.out.println("[SUCCESS] - deleted libro "+libro.getTitulo());
            return delOk;

        } catch (Exception e) {
            System.out.println("[ERROR] - failed to delete libro "+libro.getTitulo());
            e.printStackTrace();
        }

        return false;
    }

}
