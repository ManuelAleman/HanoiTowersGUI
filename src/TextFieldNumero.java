
/*
 * Autor: Berrelleza Aleman Jesus Manuel
 * Dr. Clemente Garcia Gerardo
 * Fecha: 11-10-2023
 * Descripción: HANOI - Juego de las torres de Hanoi
 */
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextFieldNumero extends JTextField implements KeyListener {

    public TextFieldNumero(int columnas){
        super(columnas);
        addKeyListener(this);
    }

    public int getNumero(){
        String texto = getText();
        int numero = Integer.parseInt(texto);
        return Math.min(numero, 16);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if(!Character.isDigit(c)){
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
