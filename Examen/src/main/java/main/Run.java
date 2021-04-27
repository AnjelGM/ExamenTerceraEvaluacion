/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import controlador.Controlador;
import modelo.*;
import vistas.*;

/**
 * 
 * @author Angel
 */
public class Run {
    public static void main(String[] args) {
        IVista vista = new VentanaSwing();
        IModelo modelo = new FicheroBinario();
        Controlador controlador = new Controlador(modelo, vista);
        
        vista.setControlador(controlador);
        
        vista.mostrar();
    }
}
