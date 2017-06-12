package gui;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logic.Estado;
import logic.Particion;

/**
 *
 * @author 
 */
public class PintarLista {
    
    
    public void pintarEtiquetas (JPanel panel,ArrayList<Particion> array){
        int y = 40;
        JTextField campo  = new JTextField("Espacio_D");
        JTextField color  = new JTextField();
        campo.setBounds(20, 20, 70, 20);
        color.setBounds(120, 20, 40, 20);
        campo.setBackground(Color.WHITE);
        color.setBackground(Color.WHITE);
        campo.setEditable(false);
        color.setEditable(false);
        panel.add(campo);
        panel.add(color);
        for (int i = 0; i < array.size(); i++) {
            Particion p = array.get(i);
            Estado e = p.obtenerProceso().getEstado();
            JTextField field = new JTextField(p.obtenerProceso().getNombre());
            JTextField estado = new JTextField(e.name());
             field.setBounds(20, y, 70, 20);
            estado.setBounds(120,y, 70, 20);
            field.setEditable(false);
            estado.setEditable(false);
//            field.setEnabled(true);
            field.setBackground(p.obtenerProceso().getColor());
            estado.setBackground(p.obtenerProceso().getColor());
            panel.add(field);
            panel.add(estado);
            y+=30;
        }
          panel.updateUI();
        
    }
    
    
    
    
}
