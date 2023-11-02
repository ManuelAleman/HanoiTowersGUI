
/*
 * Autor: Berrelleza Aleman Jesus Manuel
 * Dr. Clemente Garcia Gerardo
 * Fecha: 11-10-2023
 * Descripción: HANOI - Juego de las torres de Hanoi
 */
import java.util.ArrayList;
import java.util.Stack;

public class Modelo {

    private int numeroDiscos;
    private Stack<Integer> torreInicio;
    private Stack<Integer> torreAuxiliar;
    private Stack<Integer> torreDestino;
    private ArrayList<ModeloMovimientos> movimientos;

    public Modelo(int numeroDiscos) {
        this.numeroDiscos = numeroDiscos;
        this.torreInicio = new Stack<>();
        this.torreAuxiliar = new Stack<>();
        this.torreDestino = new Stack<>();
        for (int i = 0; i < numeroDiscos; i++) {
            torreInicio.push(i);
        }
        movimientos = new ArrayList<>();
    }

    public void moverDisco(int torreInicio, int torreDestino) {

        int disco=0;
        switch (torreInicio)
        {
            case 1 -> disco=this.torreInicio.pop();
            case 2 -> disco=this.torreAuxiliar.pop();
            case 3 -> disco=this.torreDestino.pop();
        }
        switch (torreDestino) {
            case 1 -> this.torreInicio.push(disco);
            case 2 -> this.torreAuxiliar.push(disco);
            case 3 -> this.torreDestino.push(disco);
        }
        movimientos.add(new ModeloMovimientos(disco, torreInicio, torreDestino));
    }

    private void resolverTorres(int numeroDiscos, int torreInicio, int torreAuxiliar, int torreDestino) {
        if (numeroDiscos == 1) {
            moverDisco(torreInicio, torreDestino);
        } else {
            resolverTorres(numeroDiscos - 1, torreInicio, torreDestino, torreAuxiliar);
            moverDisco(torreInicio, torreDestino);
            resolverTorres(numeroDiscos - 1, torreAuxiliar, torreInicio, torreDestino);
        }
    }

    public void resolverTorres() {
        resolverTorres(numeroDiscos, 1, 2, 3);
    }

    public Stack<Integer> getTorreInicio() {
        return torreInicio;
    }

    public int getNumeroDiscos() {
        return numeroDiscos;
    }

    public ArrayList<ModeloMovimientos> getMovimientos() {
        return movimientos;
    }
}
