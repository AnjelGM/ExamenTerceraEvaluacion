/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import com.github.javafaker.Faker;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class FicheroBinario implements IModelo{
    
    private static final String NOMBREFICHERO1 = "temporal.dat";
    private static final String NOMBREFICHERO2 = "calendario.dat";
    
    public FicheroBinario(){
        generarCalendario();
    }
    
    @Override
    public void reservar(Paciente e) {
        Cita aux;
        File fichero1 = new File(NOMBREFICHERO1);
        FileOutputStream fileout;
        ObjectOutputStream temporal = null;
        File fichero2 = new File(NOMBREFICHERO2);
        FileInputStream filein;
        ObjectInputStream original = null;
        
        try{
            fileout = new FileOutputStream(fichero1);
            temporal = new ObjectOutputStream(fileout);
            
            filein = new FileInputStream(fichero2);
            original = new ObjectInputStream(filein);
            
            while(true){
                aux = (Cita) original.readObject();
                if(aux.getPaciente() == null){
                    aux.setReservada(true);
                    aux.setPaciente(e);
                    temporal.writeObject(aux);
                }else{
                    temporal.writeObject(aux);
                }
            }
        } catch(EOFException ex){
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el fichero");
        } catch (IOException ex) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            original.close();
            temporal.close();
            fichero2.delete();
            fichero1.renameTo(fichero2);
        } catch (IOException ex) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void anularReserva(Paciente paciente) {
        Cita aux2;
        File fichero1 = new File(NOMBREFICHERO1);
        FileOutputStream fileout;
        ObjectOutputStream temporal = null;
        File fichero2 = new File(NOMBREFICHERO2);
        FileInputStream filein;
        ObjectInputStream original = null;
        
        try{
            fileout = new FileOutputStream(fichero1);
            temporal = new ObjectOutputStream(fileout);
            
            filein = new FileInputStream(fichero2);
            original = new ObjectInputStream(filein);
            
            while(true){
                aux2 = (Cita) original.readObject();
                
                if(aux2.getPaciente() == null){
                    temporal.writeObject(aux2);
                }else if(aux2.getPaciente().equals(paciente)){
                    aux2.setPaciente(null);
                    aux2.setReservada(false);
                    temporal.writeObject(aux2);
                }else{
                    temporal.writeObject(aux2);
                }
            }
        } catch(EOFException ex){
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el fichero");
        } catch (IOException ex) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            original.close();
            temporal.close();
            fichero2.delete();
            fichero1.renameTo(fichero2);
        } catch (IOException ex) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean quedanReservas() {
        Cita aux;
        boolean salida = false;
        File fichero2 = new File(NOMBREFICHERO2);
        FileInputStream filein;
        ObjectInputStream original = null;
        
        try{
            
            filein = new FileInputStream(fichero2);
            original = new ObjectInputStream(filein);
            
            while(true){
                aux = (Cita) original.readObject();
                if(!aux.isReservada()){
                    original.close();
                    return true;
                }
            }
        } catch(EOFException ex){
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el fichero");
        } catch (IOException ex) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            original.close();
        } catch (IOException ex1) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex1);
        }
        return false;
    }

    @Override
    public String devolerCalendario() {
        StringBuilder salida = new StringBuilder("");
        Cita aux;
        File fichero2 = new File(NOMBREFICHERO2);
        FileInputStream filein;
        ObjectInputStream original = null;
        salida.append("horas\t\tLunes\t\tMartes\t\tMiercoles\tJueves\t\tViernes\n");
        try{
            
            filein = new FileInputStream(fichero2);
            original = new ObjectInputStream(filein);
            
            for(int count1 = 9, count2 = 10;count1 < 15; count1++, count2++){
                salida.append(count1 + "-" + count2 + "\t\t");
                for(int count3 = 0;count3 < 5; count3++){
                    aux = (Cita) original.readObject();
                    if(aux.getPaciente() == null){
                        salida.append("libre\t\t");
                    }else{
                        salida.append(aux.getPaciente().getDni() + "\t\t");
                    }
                }
                salida.append("\n");
            }
        } catch(EOFException ex){
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el fichero");
        } catch (IOException ex) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            original.close();
        } catch (IOException ex1) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex1);
        }
        return salida.toString();
    }

    @Override
    public void generarCalendario() {
        File fichero2 = new File(NOMBREFICHERO2);
        FileInputStream filein;
        ObjectInputStream original = null;
        
        FileOutputStream fileout;
        ObjectOutputStream temporal = null;
        try{
            filein = new FileInputStream(fichero2);
            original = new ObjectInputStream(filein);
            
            while(true){
                original.readObject();
            }
        } catch(EOFException ex){
            try {
                original.close();
            } catch (IOException ex1) {
                Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (FileNotFoundException ex) {
            try {
                fileout = new FileOutputStream(fichero2);
                temporal = new ObjectOutputStream(fileout);
                Faker a = new Faker();
                Cita cita;
                Paciente paciente;
                String diaSemana = "", nombre, dni;
                byte edad;
                for(byte count1 = 9, count2 = 10;count1 < 15; count1++, count2++){
                    for(byte count3 = 0;count3 < 5; count3++){
                        edad = (byte) a.number().numberBetween(18, 60);
                        dni = a.number().numberBetween(0, 9999) + "";
                        nombre = a.name().firstName();
                        paciente = new Paciente(edad, dni, nombre);
                        switch(count3){
                            case 0:
                                diaSemana = "lunes";
                                break;
                            case 1:
                                diaSemana = "martes";
                                break;
                            case 2:
                                diaSemana = "miercoles";
                                break;
                            case 3:
                                diaSemana = "jueves";
                                break;
                            case 4:
                                diaSemana = "viernes";
                                break;
                        }
                        cita = new Cita(diaSemana, count1, count2, true);
                        cita.setPaciente(paciente);
                        temporal.writeObject(cita);
                    }
                }
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (IOException ex1) {
                Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException ex) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicheroBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
