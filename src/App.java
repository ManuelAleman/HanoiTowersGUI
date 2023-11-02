
/*
    * Autor: Berrelleza Aleman Jesus Manuel
    * Dr. Clemente Garcia Gerardo
    * Fecha: 11-10-2023
    * Descripción: HANOI - Juego de las torres de Hanoi
 */

public class App {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(null, vista);
        vista.escuchador(controlador);
    }
}
