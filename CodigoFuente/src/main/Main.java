package main;

import edu.controller.ControllerListener;

/**
 * Clase principal de ejecucion-
 *
 * @author
 */
public class Main {

    /**
     * permite instanciar la clase controladora y de alli abrir la ventana
     * principal de la aplicacion.
     *
     * @param args
     */
    public static void main(String[] args) {
        ControllerListener cl = new ControllerListener();
        cl.abrirVentanaPrincipal();
    }
}
