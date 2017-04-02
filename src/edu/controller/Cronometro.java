package edu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;


/**
 * Cronometro tiempo Ejecucion.
 * @author 
 */
public class Cronometro implements ActionListener{
    
    private JLabel segundos;
    private JLabel minutos;
    private byte count;
    private byte countMinutos;
    
    public Cronometro (JLabel segundos, JLabel minutos){
        this.segundos = segundos;
        this.minutos = minutos;
        this.count = 0;
        this.countMinutos = 0;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        count++;
        if (count==60){
            countMinutos++;
            count = 0;
        }
        this.segundos.setText(String.valueOf(count));
        this.minutos.setText(String.valueOf(countMinutos));
    }
    
}
