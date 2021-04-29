/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oregoon.connection;

import com.oregoon.beans.Mensaje;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Estrella
 */
public class MySqlConnection {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public MySqlConnection() {
    }
    
    public void openConnection(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC",
                    "root",
                    "10rafael10");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void closeConnection() throws SQLException{
        if (ps != null || con != null || rs != null) {
            ps.close();
            rs.close();
            con.close();
        }
    }

    public List getInfo(String query) throws SQLException {
        
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();

        List<Mensaje> mensajes = new ArrayList();

        while (rs.next()) {
            mensajes.add(new Mensaje(
                    rs.getInt("id_mensaje"),
                    rs.getString("mensaje"),
                    rs.getString("autor"),
                    rs.getString("fecha")
            ));
        }
        
        return mensajes;
    }
    
    public boolean insert(Mensaje msj) throws SQLException{
        
        boolean flag = false;
        String sql = "Insert into mensajes(mensaje, autor, fecha) values (?,?, current_time())";
        
        ps = con.prepareStatement(sql);
        
        ps.setString(1, msj.getMensaje());
        ps.setString(2, msj.getAutor());
        
        if (!ps.execute()) {
            flag = true;
        } 
        
        ps.close();
        con.close();
        
        return flag;
    }
    
    public boolean update(Mensaje msj) throws SQLException{
        
        boolean flag = false;
        String sql = "update mensajes set mensaje = ?, autor = ? where id_mensaje = ?";
        
        ps = con.prepareStatement(sql);
        
        ps.setString(1, msj.getMensaje());
        ps.setString(2, msj.getAutor());
        ps.setInt(3, msj.getId_mensaje());
        
        flag = ps.executeUpdate() > 0;
        
        ps.close();
        con.close();
        
        return flag;
    }
    
    public boolean delete(Mensaje msj) throws SQLException{
        
        boolean flag = false;
        String sql = "Delete from mensajes where id_mensaje = ?";
        
        ps = con.prepareStatement(sql);
        
        ps.setInt(1, msj.getId_mensaje());
        
        flag = ps.executeUpdate() > 0;
        
        ps.close();
        con.close();
        
        return flag;
    }

}
