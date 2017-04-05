package edu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 * Clase que permite ver el tiempo general que tarda la aplicacion mediante la
 * simulacion de un reloj.
 *
 * @author - SO2017
 */
public class Cronometro implements ActionListener {

    private JLabel segundos;
    private JLabel minutos;
    private byte count;
    private byte countMinutos;

    /**
     * Constructor.
     *
     * @param segundos
     * @param minutos
     */
    public Cronometro(JLabel segundos, JLabel minutos) {
        this.segundos = segundos;
        this.minutos = minutos;
        this.count = 0;
        this.countMinutos = 0;
    }

    /**
     * Acciones de cuando de debe cambiar de segundos a minutos y a horas.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        count++;
        if (count == 60) {
            countMinutos++;
            count = 0;
        }
        this.segundos.setText(String.valueOf(count));
        this.minutos.setText(String.valueOf(countMinutos));
    }

}
