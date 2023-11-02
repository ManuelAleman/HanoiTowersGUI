
/*
 * Autor: Berrelleza Aleman Jesus Manuel
 * Dr. Clemente Garcia Gerardo
 * Fecha: 11-10-2023
 * Descripción: HANOI - Juego de las torres de Hanoi
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Vista extends JFrame {

    private JLabel label;
    private Graphics g;
    private Image imagen;
    private JLabel contadorMovimientos;
    private TextFieldNumero textField;
    private JButton boton;
    private JPanel panel;
    private ArrayList<CoordenadasDisco> coordenadasDiscos;
    private ArrayList<ModeloMovimientos> movimientos;
    private int mov, torreNueva, discoActual, torreAnterior, mult;
    private int coorX, coorY, ancho;

    private int discos1, discos2 , discos3;
    private boolean bandera;


    public Vista(){
        super("Torres de Hanoi");
        hazInterfaaz();
        imagen = createImage(getWidth(), getHeight());
        g = imagen.getGraphics();
        repaint();
        coordenadasDiscos = new ArrayList<>();
    }

    public void hazInterfaaz(){
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Numero de discos? ");
        textField = new TextFieldNumero(10);
        boton = new JButton("Iniciar");

        contadorMovimientos = new JLabel("Movimientos: 0");

        panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(boton);
        panel.add(contadorMovimientos);

        add(panel);
        setVisible(true);
    }

    public void dibuja(){
        if(g == null){
            return;
        }
        super.paint(g);

        g.setColor(Color.black);
        g.fillRect(40, 530, 720, 20);

        g.fillRect(200, 200, 20, 330);
        g.fillRect(400, 200, 20, 330);
        g.fillRect(600, 200, 20, 330);

        for (CoordenadasDisco coordenadasDisco : coordenadasDiscos) {
            g.setColor(coordenadasDisco.getColor());
            g.fillRoundRect(coordenadasDisco.getCorX(), coordenadasDisco.getCorY()
                    , coordenadasDisco.getAncho(), CONSTANTES.ALTO_DISCO, 20, 20);
        }
    }

    public void actualizarDisco() {

        discoActual = movimientos.get(mov).getN();
        torreNueva = movimientos.get(mov).getDestino();
        torreAnterior = movimientos.get(mov).getInicio();

        contadorMovimientos.setText("Movimientos: "+(mov+1));

        actualizarMovimientoDisco();
        actualizarCoordenadasDisco();

        if (mov == movimientos.size() - 1) {
            bandera = true;
            return;
        }
        mov++;
    }

    private void actualizarMovimientoDisco() {
        switch (torreAnterior) {
            case 1 -> discos1--;
            case 2 -> discos2--;
            case 3 -> discos3--;
        }

        switch (torreNueva) {
            case 1 -> {
                torreNueva = CONSTANTES.TORRE_UNO;
                discos1++;
                mult = discos1;
            }
            case 2 -> {
                torreNueva = CONSTANTES.TORRE_DOS;
                discos2++;
                mult = discos2;
            }
            case 3 -> {
                torreNueva = CONSTANTES.TORRE_TRES;
                discos3++;
                mult = discos3;
            }
        }
    }

    public void actualizarCoordenadasDisco() {
        int y = CONSTANTES.MAXIMO_Y;
        while( coordenadasDiscos.get(discoActual).getCorY() > y){
            coordenadasDiscos.get(discoActual).setCorY(coordenadasDiscos.get(discoActual).getCorY()-CONSTANTES.VELOCIDAD);
            paint(getGraphics());
        }
        int coordenadaAux = coordenadasDiscos.get(discoActual).getCorX()+50;
        while( coordenadaAux < torreNueva){
            coordenadaAux+=CONSTANTES.VELOCIDAD;
            coordenadasDiscos.get(discoActual).setCorX(coordenadaAux-(CONSTANTES.ANCHO_DISCO-70) + 20 + (discoActual*5));
            paint(getGraphics());
        }

        while( coordenadaAux > torreNueva){
            coordenadaAux-=CONSTANTES.VELOCIDAD;
            coordenadasDiscos.get(discoActual).setCorX(coordenadaAux-(CONSTANTES.ANCHO_DISCO-70) + 20 + (discoActual*5));
            paint(getGraphics());
        }

        while( coordenadasDiscos.get(discoActual).getCorY() < (CONSTANTES.ALTURA_BARRA-CONSTANTES.ALTO_DISCO) - CONSTANTES.ALTO_DISCO * (mult-1)){
            coordenadasDiscos.get(discoActual).setCorY(coordenadasDiscos.get(discoActual).getCorY()+CONSTANTES.VELOCIDAD);
            paint(getGraphics());
        }
    }

    public void paint ( Graphics gl ){
        dibuja();
        gl.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }

    public void limpiar(){
        mov=0;
        discos1=0;
        discos2=0;
        discos3=0;
        g.clearRect(0, 0, getWidth(), getHeight());
        coordenadasDiscos.clear();
        bandera = false;
    }
    public void escuchador(Controlador c){
        boton.addActionListener(c);
    }

    public JButton getBoton() {
        return boton;
    }

    public TextFieldNumero getTextField() {
        return textField;
    }

    public void setnDisco(int nDisco) {
        discos1 = nDisco;
        for (int i = 0; i < nDisco; i++) {
            coorX = ((CONSTANTES.TORRE_UNO-(CONSTANTES.ANCHO_DISCO-70) ) + 20) +(i*5);

            coorY= CONSTANTES.ALTURA_BARRA - CONSTANTES.ALTO_DISCO * (i+1);
            ancho = CONSTANTES.ANCHO_DISCO - 10 * i;
            coordenadasDiscos.add(new CoordenadasDisco(coorX, coorY, ancho));
            System.out.println(coorX+" "+coorY+" "+ancho);
        }
    }

    public void setMovimientos(ArrayList<ModeloMovimientos> movimientos) {
        this.movimientos = movimientos;
    }

    public boolean isBandera() {
        return bandera;
    }


}

