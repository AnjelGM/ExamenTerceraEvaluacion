/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;

/**
 * 
 * @author Angel
 */
public class Paciente implements Serializable{
    private byte edad;
    private String dni;
    private String nombre;

    public Paciente(byte edad, String dni, String nombre) {
        this.edad = edad;
        this.dni = dni;
        this.nombre = nombre;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public byte getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public boolean equals (Object object){
        Paciente otroPaciente = (Paciente) object;
        return this.getDni().equals(otroPaciente.getDni());
    }
}
