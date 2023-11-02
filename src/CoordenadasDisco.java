
/*
 * Autor: Berrelleza Aleman Jesus Manuel
 * Dr. Clemente Garcia Gerardo
 * Fecha: 11-10-2023
 * Descripción: HANOI - Juego de las torres de Hanoi
 */
import java.awt.*;

public class CoordenadasDisco {
    private int corX;
    private int corY;
    private int ancho;
    private Color color;

    public CoordenadasDisco(int corX, int corY, int ancho) {
        this.corX = corX;
        this.corY = corY;
        this.ancho = ancho;
        this.color = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
    }

    public int getCorX() {
        return corX;
    }

    public void setCorX(int corX) {
        this.corX = corX;
    }

    public int getCorY() {
        return corY;
    }

    public void setCorY(int corY) {
        this.corY = corY;
    }

    public Color getColor() {
        return color;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
}

