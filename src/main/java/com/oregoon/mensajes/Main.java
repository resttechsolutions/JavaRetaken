/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oregoon.mensajes;

import com.oregoon.beans.Mensaje;
import com.oregoon.connection.MySqlConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rafael Estrella
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        MySqlConnection sql = new MySqlConnection();

//        sql.openConnection();
//        System.out.println(sql.insert(new Mensaje("Hello World From Java", "Rafael Estrella", new Date().toString())));
//        sql.closeConnection();

        sql.openConnection();
        ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) sql.getInfo("Select * from mensajes");
        sql.closeConnection();

        Mensaje msj = new Mensaje();

        mensajes.forEach(m -> {
            System.out.println(m.getId_mensaje() + " - " + m.getAutor() + ": " + m.getMensaje() + "  " + m.getFecha());

            if (m.getId_mensaje() == 5) {
                msj.setId_mensaje(m.getId_mensaje());
                msj.setAutor("Alfonso Volquez");
                msj.setMensaje(m.getMensaje());
                msj.setFecha(m.getMensaje());
            }
        });

        sql.openConnection();
        sql.update(msj);
        sql.closeConnection();
        
        msj.setId_mensaje(4);
        
        sql.openConnection();
        sql.delete(msj);
        sql.closeConnection();
        
        

    }
}
