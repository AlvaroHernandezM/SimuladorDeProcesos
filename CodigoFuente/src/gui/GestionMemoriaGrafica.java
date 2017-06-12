package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import logic.Particion;

/**
 * Clase que permite estipular la logica y la interfaz de la gestion de memoria
 *
 * @author SO
 */
public class GestionMemoriaGrafica {

    private int ancho;
    private int alto;
    private int altoCelda;
    private double r;
    private JPanel panel;
    private JPanel panelEtiquetas;
    private JPanel panelTiempo;

    public GestionMemoriaGrafica(JPanel panel, JPanel etiquetas, JPanel panelTiempo,double memoria) {
        this.ancho = 0;
        this.alto = 0;
        this.altoCelda = 0;
        this.panel = panel;
        this.r = (500/ memoria);
        this.panelEtiquetas = etiquetas;
        this.panelTiempo = panelTiempo;
        pintar(this.panel.getGraphics(), this.panelEtiquetas.getGraphics(), this.panelTiempo.getGraphics(), memoria);
        System.err.println("pixe " + r);
    }

    public void pintar(Graphics g, Graphics g2, Graphics g3, double memoria) {
        double r = (memoria / 10);
        double rt = r;
        this.ancho = (int) this.panel.getWidth();
        this.alto = (int) this.panel.getHeight();
        int anchoCelda = (int) (this.panel.getWidth() / 10);
        altoCelda = (int) (this.panel.getHeight() / 10);
        Color c;
        c = new Color(255, 255, 255);
        g.setColor(c);
        g.fillRect(0, 0, this.ancho, this.alto);
        c = new Color(180, 180, 180);
        g.setColor(c);
        for (int i = anchoCelda; i < this.ancho; i += anchoCelda) {
            g.drawLine(i, 0, i, this.alto);
            g2.drawString(String.valueOf(r), i - 15, 20);
            r = r + rt;
        }
        for (int j = altoCelda, z = 10; j < this.alto; j += altoCelda, z += 10) {
            g.drawLine(0, j, this.ancho, j);
            g3.drawString(String.valueOf(z), 25, j);
        }

        this.panel.paintComponents(g);
        this.panelEtiquetas.paintComponents(g2);
        this.panelTiempo.paintComponents(g3);
    }

    public void pintarProcesos(ArrayList<Particion> array, JPanel panel) {
        Graphics g = panel.getGraphics();

        int x = 0;
        int x1 = 0;
        int y1 = 0;
        for (int i = 0; i < array.size(); i++) {
            Particion p = array.get(i);
            if (!removerPintura(p)) {
                g.setColor(p.obtenerProceso().getColor());
                x = (int)(p.getPosInicial() * r);
                x1= (int) (p.getPosFinal() * r) - x;
                y1 = conversion2(p.obtenerProceso().getTiempoEjecucionR());
                g.fillRect(x, 0, x1, y1);
                g.setColor(Color.WHITE);
                g.fillRect(x, p.obtenerProceso().getTiempoEjecucionR(), x1,
                        p.obtenerProceso().getTiempoEjecucionR());
                panel.paintComponents(g);
            }else{
                g.setColor(Color.WHITE);
               g.fillRect((int)(p.getPosInicial()*r),0,(int)(p.getPosFinal()*r)-(int)(p.getPosInicial()*r),
                       conversion2(p.obtenerProceso().getTiempoEjecucionT()));
            }
        }
    }

    public boolean removerPintura(Particion p) {
        if (p.obtenerProceso().getTiempoEjecucionR() == 0) {
            return true;
        }
        return false;
    }

    public int conversion2(int dato) {
        int tmp = dato * this.altoCelda / 10;
        return tmp;
    }

}
