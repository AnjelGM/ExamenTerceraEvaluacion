/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Angel
 */
public interface IModelo {
    public abstract void reservar(Paciente e);
    public abstract void anularReserva(Paciente p);
    public abstract boolean quedanReservas();
    public abstract String devolerCalendario();
    public abstract void generarCalendario();
}
