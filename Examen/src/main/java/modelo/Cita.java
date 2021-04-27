/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Cita implements Serializable{
    String dia;
    byte horaInicio, horaFin;
    Paciente paciente;
    boolean reservada;

    public Cita(String dia, byte horaInicio, byte horaFin, boolean reservada) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.reservada = reservada;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDia() {
        return dia;
    }

    public byte getHoraInicio() {
        return horaInicio;
    }

    public byte getHoraFin() {
        return horaFin;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public boolean isReservada() {
        return reservada;
    }
    
    public void setReservada(boolean reservada){
        this.reservada = reservada;
    }
    
}
