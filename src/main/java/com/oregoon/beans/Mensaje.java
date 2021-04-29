/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oregoon.beans;

import java.util.Objects;

/**
 *
 * @author Rafael Estrella
 */
public class Mensaje {
    private int id_mensaje;
    private String Mensaje;
    private String autor;
    private String fecha;

    public Mensaje() {
    }

    public Mensaje(int id_mensaje, String Mensaje, String autor, String fecha) {
        this.id_mensaje = id_mensaje;
        this.Mensaje = Mensaje;
        this.autor = autor;
        this.fecha = fecha;
    }

    public Mensaje(String Mensaje, String autor, String fecha) {
        this.Mensaje = Mensaje;
        this.autor = autor;
        this.fecha = fecha;
    }
    
    

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id_mensaje;
        hash = 97 * hash + Objects.hashCode(this.Mensaje);
        hash = 97 * hash + Objects.hashCode(this.autor);
        hash = 97 * hash + Objects.hashCode(this.fecha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mensaje other = (Mensaje) obj;
        if (this.id_mensaje != other.id_mensaje) {
            return false;
        }
        if (!Objects.equals(this.Mensaje, other.Mensaje)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mensaje{id_mensaje=").append(id_mensaje);
        sb.append(", Mensaje=").append(Mensaje);
        sb.append(", autor=").append(autor);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }   
    
}
