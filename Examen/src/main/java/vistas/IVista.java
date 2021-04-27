/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vistas;

import controlador.Controlador;
import modelo.Paciente;
import modelo.Cita;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface IVista {
    public abstract byte getOperacion();
    public abstract Paciente getPaciente();
    
    public abstract void setCalendario(String calendario); 
    public abstract void setHayPlazas(boolean hayPlazas);
    
    public abstract void setControlador(Controlador cc);
    public abstract void mostrar(); //Visualice la IGU
}
