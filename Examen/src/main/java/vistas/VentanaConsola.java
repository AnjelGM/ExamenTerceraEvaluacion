/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vistas;

import controlador.Controlador;
import java.util.Scanner;
import modelo.Paciente;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VentanaConsola implements IVista{
    private Controlador controlador;
    private byte operacion;
    private boolean hayPlazas;
    private String calendario;
    private Paciente paciente;

    @Override
    public byte getOperacion() {
        return operacion;
    }

    @Override
    public void setControlador(Controlador cc) {
        controlador = cc;
    }

    @Override
    public void mostrar() {
        Scanner sc = new Scanner(System.in);
        String dni, nombre;
        byte edad;
        while(true){
            System.out.print("¿Quedan plazas libres?\t");
            if(hayPlazas){
                System.out.println("Si");
            }else{
                System.out.println("No");
            }
            System.out.println(calendario);
            System.out.println("¿Que operacion quieres hacer?\n"
                    + "1 Reservar Cita\n2 Anular Cita");
            operacion = sc.nextByte();
            sc.nextLine();
            if(operacion == 1){
                if(hayPlazas){
                    System.out.print("Introduce tu DNI\t");
                    dni = sc.nextLine();
                    System.out.println("Introduce tu nombre\t");
                    nombre = sc.nextLine();
                    System.out.println("Introduce tu edad\t");
                    try{
                    edad = sc.nextByte();
                    sc.nextLine();
                    paciente = new Paciente(edad, dni, nombre);
                    controlador.notificacion();
                }catch(java.lang.NumberFormatException ex){
                    System.out.println("Introduce un numero en la edad");
                }
                }else{
                    System.out.println("No quedan plazas libres");
                }
            }else if(operacion == 2){
                System.out.print("Introduce tu DNI\t");
                dni = sc.nextLine();
                System.out.println("Introduce tu nombre\t");
                nombre = sc.nextLine();
                System.out.println("Introduce tu edad\t");
                try{
                    edad = sc.nextByte();
                    sc.nextLine();
                    paciente = new Paciente(edad, dni, nombre);
                    controlador.notificacion();
                }catch(java.lang.NumberFormatException ex){
                    System.out.println("Introduce un numero en la edad");
                }
            }
        }
    }

    @Override
    public void setCalendario(String calendario) {
        this.calendario = calendario;
    }

    @Override
    public void setHayPlazas(boolean hayPlazas) {
        this.hayPlazas = hayPlazas;
    }

    @Override
    public Paciente getPaciente() {
        return paciente;
    }
    
}
