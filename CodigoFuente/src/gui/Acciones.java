package gui;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import logic.ColaProcesos;
import logic.Procesos;

/**
 * clase encargada de efectuar operaciones en los componentes graficos.
 *
 * @author
 */
public class Acciones {

    private ColaProcesos colaProcesos;

    /**
     * Constructor recibiendo la cola de procesos.
     *
     * @param cp
     */
    public Acciones(ColaProcesos cp) {
        this.colaProcesos = cp;
    }

    /**
     * permite actualizar la tabla de procesos.
     *
     * @param dtm
     */
    public void actualizarTabla(DefaultTableModel dtm) {

        this.removerTabla(dtm);

        for (int i = 0; i < this.colaProcesos.getDeque().size(); i++) {

            Object[] fila = new Object[7];

            fila[0] = this.colaProcesos.getDeque().get(i).getNombre();
            fila[1] = this.colaProcesos.getDeque().get(i).getEstado();
            fila[2] = this.colaProcesos.getDeque().get(i).getTiempoBloqueoT();
            fila[3] = this.colaProcesos.getDeque().get(i).getTiempoBloqueoR();
            fila[4] = this.colaProcesos.getDeque().get(i).getTiempoEjecucionT();
            fila[5] = this.colaProcesos.getDeque().get(i).getTiempoEjecucionR();
            fila[6] = this.colaProcesos.getDeque().get(i).getTiempoTotal();

            dtm.addRow(fila);
        }

    }

    /**
     * Remueve las filas de la tabla.
     *
     * @param dtm
     */
    public void removerTabla(DefaultTableModel dtm) {
        for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }

    /**
     * Agrega los procesos bloqueados a la tabla.
     *
     * @param dtm
     * @param terminados
     * @param procesos
     */
    public void procesosBloqueados(DefaultTableModel dtm, boolean terminados, Procesos procesos) {
        if (terminados) {
            for (int i = 0; i < procesos.getBloqueados().getTamano(); i++) {
                Object[] fila = new Object[7];

                fila[0] = procesos.getBloqueados().getProceso(i).getNombre();
                fila[1] = procesos.getBloqueados().getProceso(i).getEstado();
                fila[2] = procesos.getBloqueados().getProceso(i).getTiempoBloqueoT();
                fila[3] = procesos.getBloqueados().getProceso(i).getTiempoBloqueoR();
                fila[4] = procesos.getBloqueados().getProceso(i).getTiempoEjecucionT();
                fila[5] = procesos.getBloqueados().getProceso(i).getTiempoEjecucionR();
                fila[6] = procesos.getBloqueados().getProceso(i).getTiempoTotal();

                dtm.addRow(fila);
            }
        }
    }

    /**
     * Permite actualizar los procesos terminados en la tabla.
     *
     * @param dtm
     * @param terminados
     * @param procesos
     */
    public void procesosTerminados(DefaultTableModel dtm, boolean terminados, Procesos procesos) {

        if (terminados) {
            for (int i = 0; i < procesos.getTerminados().getTamano(); i++) {
                Object[] fila = new Object[7];

                fila[0] = procesos.getTerminados().getProceso(i).getNombre();
                fila[1] = procesos.getTerminados().getProceso(i).getEstado();
                fila[2] = procesos.getTerminados().getProceso(i).getTiempoBloqueoT();
                fila[3] = procesos.getTerminados().getProceso(i).getTiempoBloqueoR();
                fila[4] = procesos.getTerminados().getProceso(i).getTiempoEjecucionT();
                fila[5] = procesos.getTerminados().getProceso(i).getTiempoEjecucionR();
                fila[6] = procesos.getTerminados().getProceso(i).getTiempoTotal();

                dtm.addRow(fila);
            }
        }

    }


    public void añadirFilasTabla(DefaultTableModel dtm, JComboBox jComboBox) {
        ArrayList lista = obtenerArrayProcesadores(jComboBox);
        for (int i = 0; i < lista.size(); i++) {
            Object[] fila = new Object[4];
            fila[0] = lista.get(i);
            dtm.addRow(fila);
        }
    }

    /**
     * Retorno de la lista de procesadores a emplear durante la ejecucion.
     *
     * @param jComboBox
     * @return
     */
    public ArrayList obtenerArrayProcesadores(JComboBox jComboBox) {
        int cantidadProcesadores = Integer.parseInt(jComboBox.getSelectedItem().toString());
        ArrayList lista = new ArrayList();
        for (int i = 0; i < cantidadProcesadores; i++) {
            lista.add("Procesador" + (i + 1));
        }
        return lista;
    }

}
