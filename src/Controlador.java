
/*
 * Autor: Berrelleza Aleman Jesus Manuel
 * Dr. Clemente Garcia Gerardo
 * Fecha: 11-10-2023
 * Descripción: HANOI - Juego de las torres de Hanoi
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private Modelo modelo;
    private Vista vista;
    private Timer t;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo=modelo;
        this.vista=vista;
        t = new Timer(1, this);
        t.setRepeats(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.getBoton()){
            vista.getBoton().setEnabled(false);
            int num = vista.getTextField().getNumero();
            modelo = new Modelo(num);
            vista.repaint();
            modelo.resolverTorres();
            vista.setnDisco(num);
            vista.setMovimientos(modelo.getMovimientos());
            t.start();
        }

        if(e.getSource() == t){
            vista.actualizarDisco();
            if(vista.isBandera()){
                JOptionPane.showMessageDialog(null, "Se resolvio en "+modelo.getMovimientos().size()+" movimientos");
                t.stop();
                vista.limpiar();
                vista.getBoton().setEnabled(true);
            }
        }





    }
}