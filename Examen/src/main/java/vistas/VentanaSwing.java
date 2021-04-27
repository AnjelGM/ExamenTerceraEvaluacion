/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vistas;

import controlador.Controlador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import modelo.Paciente;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VentanaSwing extends JFrame implements IVista{
    private Controlador controlador;
    private byte operacion;
    private boolean hayPlazas;
    private String calendario;
    private Paciente paciente;
    private JLabel quedanPlazas, quedanPlazas2, dni, nombre, edad, jlCalendario, vacio;
    private JTextField dni2, nombre2, edad2;
    private JTextArea jtaCalendario;
    private JButton reservar, anular;
    
    private JPanel informacion, botones; 
    
    public VentanaSwing(){
        GridLayout layoutInicial = new GridLayout(3, 1);
        getContentPane().setLayout(layoutInicial);
        inicarLabels();
        iniciarJTextField();
        iniciarJButtons();
        iniciarJPanels();
        
        getContentPane().add(informacion);
        getContentPane().add(jtaCalendario);
        getContentPane().add(botones);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calendario vacunas");
        setLocationRelativeTo(null);
        pack();
    }
    
    private void inicarLabels(){
        quedanPlazas = new JLabel("¿Quedan plazas libres?");
        quedanPlazas2 = new JLabel("Si");
        dni = new JLabel("DNI");
        nombre = new JLabel("Nombre");
        edad = new JLabel("Edad");
        jlCalendario = new JLabel("Calendario");
        vacio = new JLabel("");
    }
    private void iniciarJTextField(){
        dni2 = new JTextField("");
        nombre2 = new JTextField("");
        edad2 = new JTextField("");
        jtaCalendario = new JTextArea("");
    }
    
    private void iniciarJButtons(){
        reservar = new JButton("RESERVAR CITA");
        anular = new JButton("ANULAR CITA");
        
        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                operacion = 1;
                String dni, nombre;
                byte edad;
                dni = dni2.getText();
                nombre = nombre2.getText();
                try{
                    edad = Byte.parseByte(edad2.getText());
                    paciente = new Paciente(edad, dni, nombre);
                    controlador.notificacion();
                }catch(java.lang.NumberFormatException ex){
                    edad2.setText("");
                }
            }
        });
        
        anular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                operacion = 2;
                String dni, nombre;
                byte edad;
                dni = dni2.getText();
                nombre = nombre2.getText();
                try{
                    edad = Byte.parseByte(edad2.getText());
                    paciente = new Paciente(edad, dni, nombre);
                    controlador.notificacion();
                }catch(java.lang.NumberFormatException ex){
                    edad2.setText("");
                }
            }
        });
    }
    
    private void iniciarJPanels(){
        GridLayout lInformacion = new GridLayout(5, 2);
        FlowLayout lBotones = new FlowLayout();
        informacion = new JPanel(lInformacion);
        botones = new JPanel(lBotones);
        
        informacion.add(quedanPlazas);
        informacion.add(quedanPlazas2);
        
        informacion.add(dni);
        informacion.add(dni2);
        
        informacion.add(nombre);
        informacion.add(nombre2);
        
        informacion.add(edad);
        informacion.add(edad2);
        
        informacion.add(jlCalendario);
        informacion.add(vacio);
        
        botones.add(reservar);
        botones.add(anular);
    }
    
    @Override
    public byte getOperacion() {
        return operacion;
    }

    @Override
    public Paciente getPaciente() {
        return paciente;
    }

    @Override
    public void setCalendario(String calendario) {
        this.calendario = calendario;
        jtaCalendario.setText(calendario);
    }

    @Override
    public void setHayPlazas(boolean hayPlazas) {
        this.hayPlazas = hayPlazas;
        if(hayPlazas){
            quedanPlazas2.setText("SI");
        }else{
            quedanPlazas2.setText("NO");
        }
    }

    @Override
    public void setControlador(Controlador cc) {
        controlador = cc;
    }

    @Override
    public void mostrar() {
        setVisible(true);
    }

}
