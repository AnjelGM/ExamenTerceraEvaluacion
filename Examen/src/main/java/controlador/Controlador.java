/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import modelo.*;
import vistas.*;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Controlador {
    IModelo modelo;
    IVista vista;

    public Controlador(IModelo modelo, IVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setCalendario(modelo.devolerCalendario());
        vista.setHayPlazas(modelo.quedanReservas());
    }
    
    public void notificacion(){
        switch(vista.getOperacion()){
            case 1:
                modelo.reservar(vista.getPaciente());
                break;
            case 2:
                modelo.anularReserva(vista.getPaciente());
                break;
        }
        vista.setHayPlazas(modelo.quedanReservas());
        vista.setCalendario(modelo.devolerCalendario());
    }
}
