/*
 * Autor: Berrelleza Aleman Jesus Manuel
 * Dr. Clemente Garcia Gerardo
 * Fecha: 11-10-2023
 * Descripción: HANOI - Juego de las torres de Hanoi
 */
public class ModeloMovimientos {
    private int n;
    private int inicio;
    private int destino;

    public ModeloMovimientos(int n,int inicio, int destino) {
        this.n = n;
        this.inicio = inicio;
        this.destino = destino;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
