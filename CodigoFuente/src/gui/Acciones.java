package gui;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logic.ColaProcesos;
import logic.Particion;
import logic.Proceso;

/**
 * clase encargada de efectuar operaciones en los componentes graficos.
 *
 * @author
 */
public class Acciones {

    private ColaProcesos colaProcesos;

    public Acciones(ColaProcesos cp) {
        this.colaProcesos = cp;
    }

    public void actualizarTabla(DefaultTableModel dtm) {

        this.removerTabla(dtm);

        for (int i = 0; i < this.colaProcesos.getDeque().size(); i++) {

            Object[] fila = new Object[5];

            fila[0] = this.colaProcesos.getDeque().get(i).getNombre();
            fila[1] = this.colaProcesos.getDeque().get(i).getEstado();
            fila[2] = this.colaProcesos.getDeque().get(i).getTiempoEjecucionR();
            fila[3] = this.colaProcesos.getDeque().get(i).getTiempoEjecucionT();
            fila[4] = this.colaProcesos.getDeque().get(i).getTamano();

            dtm.addRow(fila);
        }
    }

    public void actu(DefaultTableModel dtm, ArrayList<Particion> array) {
        this.removerTabla(dtm);
        for (int i = 0; i < array.size(); i++) {
            Particion p = array.get(i);

            Object[] fila = new Object[5];

            fila[0] = p.obtenerProceso().getNombre();
            fila[1] = p.obtenerProceso().getEstado();
            fila[2] = p.obtenerProceso().getTiempoEjecucionR();
            fila[3] = p.obtenerProceso().getTiempoEjecucionT();
            fila[4] = p.obtenerProceso().getTamano();

            dtm.addRow(fila);
        }

    }

    /**
     * Remuve las filas de la tabla.
     *
     * @param dtm
     */
    public void removerTabla(DefaultTableModel dtm) {
        for (int i = dtm.getRowCount() - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }

    /**
     * Actualiza los procesos terminados en la tabla.
     *
     * @param dtm
     * @param terminados
     * @param procesos
     */
    public void procesosTerminados(DefaultTableModel dtm, ColaProcesos colaProcesos) {
        for (int i = 0; i < colaProcesos.getTamano(); i++) {
            Proceso p = colaProcesos.getProceso(i);
            Object[] fila = new Object[5];

            fila[0] = p.getNombre();
            fila[1] = p.getEstado();
            fila[3] = p.getTiempoEjecucionR();
            fila[4] = p.getTiempoEjecucionT();

            dtm.addRow(fila);

        }
    }

}
